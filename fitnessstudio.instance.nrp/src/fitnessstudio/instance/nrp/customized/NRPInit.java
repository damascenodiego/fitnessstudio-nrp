package fitnessstudio.instance.nrp.customized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.lagodiuk.GAPopulation;


import nrp.model.nrp.*;
import de.uni_ko.fitnessstudio.lower.DomainModel;
import de.uni_ko.fitnessstudio.lower.DomainModelInit;
import de.uni_ko.fitnessstudio.lower.DomainModelMutator;

public class NRPInit implements DomainModelInit {

	EObject inputModel;
	DomainModelMutator mutator;
	NRPCrossover crossover;
	NRPFitness fitness;
	

	public NRPInit(EObject inputModel, DomainModelMutator mutator) {
		super();
		this.inputModel = inputModel;
		this.mutator = mutator;
		this.crossover = new NRPCrossover();
		this.fitness = new NRPFitness();
	}
	
	public NRPInit(EObject inputModel, DomainModelMutator mutator, NRPCrossover crossover,
			NRPFitness fitness) {
		super();
		this.inputModel = inputModel;
		this.mutator = mutator;
		this.crossover = crossover;
		this.fitness = fitness;
	}

	
	public GAPopulation<DomainModel> createPopulation(int populationSize) {
		GAPopulation<DomainModel> result = new GAPopulation<DomainModel>();

		//List<Integer> chosen = new ArrayList<>(populationSize);
		for (int i = 0; i < populationSize; i++) {
			result.addChromosome(createInitialSingletonSolution(i));
			//result.addChromosome(createRandomSolution());
		} 
		
		return result;
		
	}

	// create with adding 
	private  DomainModel createInitialSingletonSolution(int i) {
		NRP fresh = (NRP) EcoreUtil.copy(inputModel);
		SoftwareArtifact initial_artifact = fresh.getAvailableArtifacts().get(i % fresh.getAvailableArtifacts().size());
		
		initial_artifact.getSolutions().add(fresh.getSolutions().get(0));
		fresh.getSolutions().get(0).getSelectedArtifacts().add(initial_artifact);
		
		return new DomainModel(fresh, mutator, crossover, fitness);
	}
	
	private DomainModel createRandomSolution() {
		NRP fresh = (NRP) EcoreUtil.copy(inputModel);
		
		for (int i = 0; i < fresh.getAvailableArtifacts().size(); i++) {
			if (Math.random() > 0.5) {
				fresh.getSolutions().get(0).getSelectedArtifacts().add(fresh.getAvailableArtifacts().get(i));
			}
		}
		
		return new DomainModel(fresh, mutator, crossover, fitness);
	}

	@Override
	public void setMutator(DomainModelMutator mutator) {
		this.mutator = mutator;
	}

}
