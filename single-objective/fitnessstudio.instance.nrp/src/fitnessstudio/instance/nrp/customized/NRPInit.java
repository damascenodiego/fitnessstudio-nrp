package fitnessstudio.instance.nrp.customized;

import java.util.concurrent.ThreadLocalRandom;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.lagodiuk.GAPopulation;


import nrp.model.nrp.*;
import de.uni_ko.fitnessstudio.lower.DomainModel;
import de.uni_ko.fitnessstudio.lower.DomainModelInit;
import de.uni_ko.fitnessstudio.lower.DomainModelMutator;
import fitnessstudio.instance.nrp.fitness.MaximiseSatisfactionReimplemented;
import fitnessstudio.instance.nrp.fitness.MinimiseCost;

public class NRPInit implements DomainModelInit {

	EObject inputModel;
	DomainModelMutator mutator;
	NRPCrossover crossover;
	NRPFitness fitness;
	

	public NRPInit(EObject inputModel, DomainModelMutator mutator, final String INPUT_MODEL_ID) {
		super();
		this.inputModel = inputModel;
		this.mutator = mutator;
		this.crossover = new NRPCrossover();
		this.fitness = new NRPFitness(INPUT_MODEL_ID);
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
			result.addChromosome(createEmptySolution());
			//result.addChromosome(createCompleteSolution());
			//result.addChromosome(createExtremeSolution());
			//result.addChromosome(createRandomSolution());
		} 
		
		//result = createERPPopulation(populationSize);
		
		return result;
	}
	
	private DomainModel createEmptySolution() {
		NRP fresh = (NRP) EcoreUtil.copy(inputModel);
		
		return new DomainModel(fresh, mutator, crossover, fitness);
	}
	
	private DomainModel createCompleteSolution() {
		NRP fresh = (NRP) EcoreUtil.copy(inputModel);
		
		for (int i = 0; i < fresh.getAvailableArtifacts().size(); i++) {
			SoftwareArtifact artifact = fresh.getAvailableArtifacts().get(i);
			artifact.getSolutions().add(fresh.getSolutions().get(0));
			fresh.getSolutions().get(0).getSelectedArtifacts().add(artifact);
		}
		
		return new DomainModel(fresh, mutator, crossover, fitness);
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
	
	private DomainModel createExtremeSolution() {
		NRP fresh = (NRP) EcoreUtil.copy(inputModel);

		if (Math.random() > 0.5) {
			for (int i = 0; i < fresh.getAvailableArtifacts().size(); i++) {
				SoftwareArtifact artifact = fresh.getAvailableArtifacts().get(i);
				artifact.getSolutions().add(fresh.getSolutions().get(0));
				fresh.getSolutions().get(0).getSelectedArtifacts().add(artifact);
			}
		}
		
		return new DomainModel(fresh, mutator, crossover, fitness);
	}

	private void fixSolution(DomainModel domainModel) {
		NRP model = (NRP) domainModel.getContent();
		boolean feasible = false;
		
		while (!feasible) {
			boolean changed = false;
			int nrSelectedArtifacts = model.getSolutions().get(0).getSelectedArtifacts().size();
			for (int i = nrSelectedArtifacts - 1; i >= 0; i--) {
				SoftwareArtifact artifact = model.getSolutions().get(0).getSelectedArtifacts().get(i);
				
				for (SoftwareArtifact dependency : artifact.getRequires()) {
					if (dependency.getSolutions().isEmpty()) {
						// TODO possible indexing issues
						if (Math.random() > 0.5) {
							// add dependency to solution
							dependency.getSolutions().add(model.getSolutions().get(0));
							model.getSolutions().get(0).getSelectedArtifacts().add(dependency);
						} else {
							// remove artifact from solution
							artifact.getSolutions().remove(model.getSolutions().get(0));
							model.getSolutions().get(0).getSelectedArtifacts().remove(artifact);
						}
						changed = true;
					}
				}
			}
			
			feasible = !changed;
		}
	}
	
	private boolean implementAllDependencies(SoftwareArtifact artifact, NRP model) {
		boolean changed = false;
		for (SoftwareArtifact dependency : artifact.getRequires()) {
			if (dependency.getSolutions().isEmpty()) {
				dependency.getSolutions().add(model.getSolutions().get(0));
				model.getSolutions().get(0).getSelectedArtifacts().add(dependency);
				changed = true;
			}
		}
		
		return changed;
	}
	
	private boolean allDependenciesImplemented(SoftwareArtifact artifact) {
		for (SoftwareArtifact dependency : artifact.getRequires()) {
			if (dependency.getSolutions().isEmpty())
				return false;
		}
		
		return true;
	}
	
	private void customFixSolution(DomainModel domainModel) {
		NRP model = (NRP) domainModel.getContent();
		boolean feasible = false;
		
		while (!feasible) {
			boolean changed = false;
			int nrSelectedArtifacts = model.getSolutions().get(0).getSelectedArtifacts().size();
			for (int i = nrSelectedArtifacts - 1; i >= 0; i--) {
				SoftwareArtifact artifact = model.getSolutions().get(0).getSelectedArtifacts().get(i);
				
				if (artifact.getRequires().size() > 0) {
					// Artifact has dependencies
					if (Math.random() > 0.5) {
						// Implement all dependencies
						if (implementAllDependencies(artifact, model))
							changed = true;
					} else if (!allDependenciesImplemented(artifact)) {
						// Remove artifact from solution if not all dependencies are implemented
						artifact.getSolutions().remove(model.getSolutions().get(0));
						model.getSolutions().get(0).getSelectedArtifacts().remove(artifact);
						changed = true;
					}
				}
			}
			
			feasible = !changed;
		}
	}
	
	
	private GAPopulation<DomainModel> createPath(int e) {
		GAPopulation<DomainModel> population = new GAPopulation<DomainModel>();
		
		NRP fresh = (NRP) EcoreUtil.copy(inputModel);
		int requirements = fresh.getAvailableArtifacts().size();
		int step = (int) Math.ceil(requirements / (e + 1.0));
		
		for (int k = 0; k < requirements; k++) {
			int starting = ThreadLocalRandom.current().nextInt(0, requirements);
			for (int i = 0; i < requirements; i++) {
				int index = (i + starting) % requirements;
				SoftwareArtifact artifact = fresh.getAvailableArtifacts().get(index);
				
				if (artifact.getSolutions().isEmpty()) {
					// artifact not already in solution, add
					fresh.getSolutions().get(0).getSelectedArtifacts().add(artifact);
					artifact.getSolutions().add(fresh.getSolutions().get(0));
					break;
				}
			}
			if (k % step == 0) {
				NRP solution = (NRP) EcoreUtil.copy(fresh);
				population.addChromosome(new DomainModel(solution, mutator, crossover, fitness));
			}
		}
		
		return population;
	}
	
	// https://link.springer.com/content/pdf/10.1007%2F978-3-319-13650-9.pdf
	private GAPopulation<DomainModel> createERPPopulation(int populationSize) {
		GAPopulation<DomainModel> population = createPath(30);
		//population.addChromosome(createCompleteSolution());
		
		int solutionsCreated = population.getSize();
		/*
		for (int i = 0; i < population.getSize(); i++) {
			calculateFitness(population.getChromosomeByIndex(i));
		}

		System.out.println("------------");
		*/
		while (solutionsCreated < populationSize) {
			DomainModel individual = createRandomSolution();
			fixSolution(individual);
			population.addChromosome(individual);
			solutionsCreated++;
		}
		
		return population;	
	}
	
	@Override
	public void setMutator(DomainModelMutator mutator) {
		this.mutator = mutator;
	}

}
