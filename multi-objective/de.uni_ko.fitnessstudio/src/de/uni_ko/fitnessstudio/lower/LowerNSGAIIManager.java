package de.uni_ko.fitnessstudio.lower;

import java.io.FileNotFoundException;
import java.util.List;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIMeasures;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.lab.visualization.plot.PlotFront;
import org.uma.jmetal.lab.visualization.plot.impl.PlotSmile;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.qualityindicator.impl.hypervolume.Hypervolume;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.comparator.RankingAndCrowdingDistanceComparator;
import org.uma.jmetal.util.front.impl.ArrayFront;
import org.uma.jmetal.util.measure.MeasureListener;
import org.uma.jmetal.util.measure.MeasureManager;
import org.uma.jmetal.util.measure.impl.BasicMeasure;
import org.uma.jmetal.util.measure.impl.DurationMeasure;

public class LowerNSGAIIManager<S> extends AbstractAlgorithmRunner {
	DomainModelProblem<S> problem;
	Algorithm<List<DomainModelSolution<S>>> algorithm;
	DomainModelCrossover<DomainModelSolution<S>> crossover;
	DomainModelMutation<S> mutation;
	SelectionOperator<List<DomainModelSolution<S>>, DomainModelSolution<S>> selection;
	
	public LowerNSGAIIManager(DomainModelProblem<S> problem, 
			DomainModelCrossover<DomainModelSolution<S>> crossover, DomainModelMutation<S> mutation) {
		this.problem = problem;
		this.crossover = crossover;
		this.mutation = mutation;
		this.selection = new BinaryTournamentSelection<>(new RankingAndCrowdingDistanceComparator<>());
	}
	
	public void runNSGAII() throws JMetalException, InterruptedException, FileNotFoundException {
		// Should probably use benchmark (random search) here
		String referenceParetoFront = referenceParetoFront = "resource/reference.csv" ;
		int maxEvaluations = 25000;
		int populationSize = 100 ;
		
		algorithm = 
				new NSGAIIBuilder<>(problem, crossover, mutation, populationSize)
	            	.setSelectionOperator(selection)
	            	.setMaxEvaluations(maxEvaluations)
	            	.setVariant(NSGAIIBuilder.NSGAIIVariant.Measures)
	            	.build();

		((NSGAIIMeasures<DomainModelSolution<S>>) algorithm).setReferenceFront(new ArrayFront(referenceParetoFront));
	    AlgorithmRunner algorithmRunner = 
	    		new AlgorithmRunner.Executor(algorithm)
	            	.execute();
	    
	    /* Measure management */
	   MeasureManager measureManager = ((NSGAIIMeasures<DomainModelSolution<S>>)algorithm).getMeasureManager() ;
	    
	    DurationMeasure currentComputingTime =
	            (DurationMeasure) measureManager.<Long>getPullMeasure("currentExecutionTime");

        BasicMeasure<Double> hypervolumeMeasure =
                (BasicMeasure<Double>) measureManager.<Double>getPushMeasure("hypervolume");

        hypervolumeMeasure.register(new Listener());
        /* End of measure management */
	        
        Thread algorithmThread = new Thread(algorithm) ;
        algorithmThread.start();

        algorithmThread.join();
        
	    List<DomainModelSolution<S>> population = algorithm.getResult();
	    long computingTime = algorithmRunner.getComputingTime();

	    JMetalLogger.logger.info("Total execution time: " + computingTime + "ms");
	
	    printFinalSolutionSet(population);
	    if (!referenceParetoFront.equals("")) {
	      printQualityIndicators(population, referenceParetoFront);
	    }

	    PlotFront plot = new PlotSmile(new ArrayFront(population).getMatrix()) ;
	    plot.plot();
	}
	
	private static class Listener implements MeasureListener<Double> {
		private static int counter = 0 ;
		@Override synchronized public void measureGenerated(Double value) {
			if ((counter++ % 10 == 0)) {
				System.out.println("Hypervolume: " + value) ;
			}
    	}
	}
}
