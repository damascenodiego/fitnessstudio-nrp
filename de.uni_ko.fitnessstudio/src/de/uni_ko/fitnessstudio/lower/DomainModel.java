package de.uni_ko.fitnessstudio.lower;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.lagodiuk.Chromosome;

/**
 * Encapsulates a class model as an individual during evolution.
 * @author strueber
 *
 */
public class DomainModel implements Chromosome<DomainModel> {

	EObject content;
	DomainModelMutation mutator;
	DomainModelCrossover crossover;
	DomainModelFitness fitness;

	public DomainModel(EObject content,  DomainModelCrossover crossover,
			DomainModelFitness fitness) {
		super();
		this.content = content;
		this.mutator = new DomainModelMutation();
		this.crossover = crossover;
		this.fitness = fitness;
	}
	public DomainModel(EObject content, DomainModelMutation mutator, DomainModelCrossover crossover,
			DomainModelFitness fitness) {
		super();
		this.content = content;
		this.mutator = mutator;
		this.crossover = crossover;
		this.fitness = fitness;
	}



	public EObject getContent() {
		return content;
	}

	@Override
	public List<DomainModel> crossover(DomainModel anotherChromosome) {
		return crossover.crossover(this, anotherChromosome);
	}

	@Override
	public DomainModel mutate() {		
		return mutator.mutate(this);
	}
	
	@Override
	public String toString() {
		return content.toString();
//		return "CRA " +CRAIndexCalculator.calculateCRAIndex(content) + ", #Classes = " + content.getClasses().size() + ", #Feat./Cl. = " +(double) ((10*content.getFeatures().size()  / Math.max(1,  content.getClasses().size()))/10.0);
	}

	public DomainModelMutation getMutator() {
		return mutator;
	}
	public DomainModelCrossover getCrossover() {
		return crossover;
	}
	public DomainModelFitness getFitness() {
		return fitness;
	}

}
