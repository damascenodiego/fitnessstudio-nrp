package fitnessstudio.instance.nrp.runners;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.uma.jmetal.util.JMetalException;

import nrp.model.nrp.*;
import de.uni_ko.fitnessstudio.lower.DomainModelCrossover;
import de.uni_ko.fitnessstudio.lower.DomainModelMutation;
import de.uni_ko.fitnessstudio.lower.DomainModelProblem;
import de.uni_ko.fitnessstudio.lower.LowerNSGAIIManager;
import de.uni_ko.fitnessstudio.util.GAConfiguration;
import de.uni_ko.fitnessstudio.util.ModelIO;
import fitnessstudio.instance.nrp.customized.NRPConstraintChecker;
import fitnessstudio.instance.nrp.customized.NRPCrossover;
import fitnessstudio.instance.nrp.customized.NRPConstraintChecker;
import fitnessstudio.instance.nrp.customized.NRPProblem;

@SuppressWarnings("all")
public class LowerTierRunnerWithFixed {
	private static String INPUT_MODEL_ID = "NRP2";
	private static String INPUT_MODEL = "input\\" + INPUT_MODEL_ID+".xmi";
	private static String MUTATION_RULES_DIRECTORY = "transformation\\fixed";
	private static String OUTPUT_PREFIX = "output_models\\" +INPUT_MODEL_ID + "\\" + new SimpleDateFormat("HH_mm_ss").format(Calendar.getInstance().getTime()).toString() + "\\";

	private static int RUNS = 30;
	private static int ITERATIONS = 60;
	private static int POPULATION_SIZE = 40;
	
	private static GAConfiguration configuration = new GAConfiguration(ITERATIONS, POPULATION_SIZE, true);

	public static void main(String[] args) throws JMetalException, InterruptedException, FileNotFoundException {
		NRPPackage.eINSTANCE.eClass();
		System.out.println("============");
		
		DomainModelProblem problem = new NRPProblem(1, 2, 0);
		DomainModelCrossover crossover = new NRPCrossover(1.0);
		DomainModelMutation mutation = new DomainModelMutation(getGenRules(), 0.4);
		
		LowerNSGAIIManager gaManager = new LowerNSGAIIManager(problem, crossover, mutation);
		gaManager.runNSGAII();
		/*
		for (int i = 1; i<=RUNS ; i++) {
			System.out.println("============");
			System.out.println("Run "+i);
			System.out.println("============");

			long start = System.currentTimeMillis();

			EObject inputModel = ModelIO.loadModel(INPUT_MODEL);
			DomainModelMutation mutator = new DomainModelMutation(getGenRules(), getFixedRules());//getFixedMutationRules());
			NRPFitness fitness = new NRPFitness();
			NRPInit init = new NRPInit(inputModel, mutator);
			NRPConstraintChecker constraintChecker = new NRPConstraintChecker();
			
			LowerGAManager gaManager = new LowerGAManager(mutator, fitness, init, configuration, constraintChecker);
			double result = gaManager.runGA();
			DomainModel resultModel = gaManager.getResult();
			long end = System.currentTimeMillis();
			
			double best = 0.0;
			double cumulative = 0.0;

			cumulative += result;
			if (result > best) {
				best = result;
			}
			System.out.println("Best: "+best+", mean: "+(cumulative / i));
			ModelIO.saveProducedModel(resultModel.getContent(), i, result, OUTPUT_PREFIX);
			
			long time = end - start;
			createLogEntry(i, result, time);
		}*/
	}

	private static void createLogEntry(int i, double result, long time) {
		String line = i+ " \t " + time + " \t " + result +"\n";
		String path = OUTPUT_PREFIX + "log.txt";
	
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			bw.write(line);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Set<Rule> getFixedMutationRules() {
		ModelIO.registerPackage();

		Path fixedRulesDirectory = Paths.get(MUTATION_RULES_DIRECTORY);
		Path firstHenshinFile = null;
		try {
			firstHenshinFile = Files.list(fixedRulesDirectory).filter(x -> x.toString().endsWith(".henshin"))
					.collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HenshinResourceSet resSet = new HenshinResourceSet();
		Resource res1 = resSet.getResource(URI.createURI(firstHenshinFile.toString()), true);
		System.out.println(firstHenshinFile.toString());
		Module mod1 = (Module) res1.getContents().get(0);
		Set<Rule> mutationRules = new HashSet<Rule>();
		for (Unit u : mod1.getUnits()) {
			if (u instanceof Rule)
				mutationRules.add(((Rule) u));
		}
		return mutationRules;
	}
	
	private static Set<Unit> getFixedRules() {
		HenshinResourceSet resSet = new HenshinResourceSet();
		Resource resource = resSet.getResource(URI.createURI("..\\de.uni_ko.fitnessstudio\\transformation\\genetic\\mutation.henshin"), true);
		Module module = (Module) resource.getContents().get(0);
		
		Set<Unit> fixedRules = new HashSet<Unit>(module.getUnits());
		
		// Remove all SubUnits from fixedRules
		for (Unit unit : module.getUnits()) {
			List<Unit> subUnits = unit.getSubUnits(true);
			fixedRules.removeAll(subUnits);
		}
		
		return fixedRules;
	}
	
	public static Set<Rule> getGenRules() {
		ModelIO.registerPackage();

		Path fixedRulesDirectory = Paths.get(MUTATION_RULES_DIRECTORY);
		Path firstHenshinFile = null;
		try {
			firstHenshinFile = Files.list(fixedRulesDirectory).filter(x -> x.toString().endsWith(".henshin"))
					.collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HenshinResourceSet resSet = new HenshinResourceSet();
		Resource res1 = resSet.getResource(URI.createURI(firstHenshinFile.toString()), true);
		System.out.println(firstHenshinFile.toString());
		Module mod1 = (Module) res1.getContents().get(0);
		Set<Rule> mutationRules = new HashSet<Rule>();
		for (Unit u : mod1.getUnits()) {
			if (u instanceof Rule)
				mutationRules.add(((Rule) u));
		}
		return mutationRules;
	}
	

}
