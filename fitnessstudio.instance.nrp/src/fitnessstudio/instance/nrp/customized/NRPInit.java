package fitnessstudio.instance.nrp.customized;

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

		for (int i = 0; i < populationSize; i++) {
			result.addChromosome(createRandomSolution());
		} 
		
		return result;
		
	}
	
	private DomainModel createRandomSolution() {
		NRP fresh = (NRP) EcoreUtil.copy(inputModel);
		
		for (int i = 0; i < fresh.getAvailableArtifacts().size(); i++) {
			if (Math.random() > 0.5) {
				SoftwareArtifact artifact = fresh.getAvailableArtifacts().get(i);
				artifact.getSolutions().add(fresh.getSolutions().get(0));
				fresh.getSolutions().get(0).getSelectedArtifacts().add(artifact);
			}
		}
		
		return new DomainModel(fresh, mutator, crossover, fitness);
	}

	@Override
	public void setMutator(DomainModelMutator mutator) {
		this.mutator = mutator;
	}

}
