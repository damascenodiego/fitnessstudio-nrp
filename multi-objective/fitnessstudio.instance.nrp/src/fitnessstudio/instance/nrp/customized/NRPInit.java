package fitnessstudio.instance.nrp.customized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.uma.jmetal.problem.Problem;
import de.uni_ko.fitnessstudio.nsga.Init;
import de.uni_ko.fitnessstudio.util.ModelIO;
import nrp.model.nrp.NRP;
import nrp.model.nrp.SoftwareArtifact;

public class NRPInit extends Init<NRPSolution> {
	
	private Problem<NRPSolution> problem;
	
	@Override
	public List<NRPSolution> createInitialPopulation(int size, Problem<NRPSolution> problem) {
		this.problem = problem;
		
		List<NRPSolution> population = new ArrayList<>(size);
	    
		//createRandomPopulation(population, size);
		createEmptyPopulation(population, size);
		//createCompletePopulation(population, size);
		//createExtremesPopulation(population, size);
		//createRandomWithExtremesPopulation(population, size);
	    
	    return population;
	}
	
	private void createRandomPopulation(List<NRPSolution> population, int size) {
		for (int i = 0; i < size; i++) {
			population.add(createRandomSolution());
	    }
	}
	
	private void createEmptyPopulation(List<NRPSolution> population, int size) {
		for (int i = 0; i < size; i++) {
			population.add(problem.createSolution());
	    }
	}
	
	private void createCompletePopulation(List<NRPSolution> population, int size) {
		for (int i = 0; i < size; i++) {
			population.add(createCompleteSolution());
	    }
	}
	
	private void createExtremesPopulation(List<NRPSolution> population, int size) {
		for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				population.add(createCompleteSolution());
			} else {
				population.add(problem.createSolution());
			}
	    }
	}
	
	private void createRandomWithExtremesPopulation(List<NRPSolution> population, int size) {
		population.add(problem.createSolution());
		
		for (int i = 1; i < size - 1; i++) {
			population.add(createRandomSolution());
	    }
		
		population.add(createCompleteSolution());
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
	
	private void fixSolution(NRPSolution solution) {
		NRP model = solution.getVariable(0);
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
	
	private List<NRPSolution> createPath(int e, List<NRPSolution> population) {
		NRPSolution fresh = problem.createSolution();
		
		// NRP fresh = (NRP) EcoreUtil.copy(inputModel);
		int requirements = fresh.getVariable(0).getAvailableArtifacts().size();
		int step = (int) Math.ceil(requirements / (e + 1.0));
		
		for (int k = 0; k < requirements - 1; k++) {
			int starting = ThreadLocalRandom.current().nextInt(0, requirements);
			for (int i = 0; i < requirements; i++) {
				int index = (i + starting) % requirements;
				SoftwareArtifact artifact = fresh.getVariable(0).getAvailableArtifacts().get(index);
				
				if (artifact.getSolutions().isEmpty()) {
					// artifact not already in solution, add
					fresh.getVariable(0).getSolutions().get(0).getSelectedArtifacts().add(artifact);
					artifact.getSolutions().add(fresh.getVariable(0).getSolutions().get(0));
					break;
				}
			}
			if (k % step == 0) {
				NRPSolution solution = (NRPSolution) fresh.copy();
				population.add(solution);
			}
		}
		
		return population;
	}
	
	private NRPSolution createRandomSolution() {
		NRPSolution solution = problem.createSolution();
		
		for (int i = 0; i < solution.getVariable(0).getAvailableArtifacts().size(); i++) {
			if (Math.random() > 0.5) {
				SoftwareArtifact artifact = solution.getVariable(0).getAvailableArtifacts().get(i);
				artifact.getSolutions().add(solution.getVariable(0).getSolutions().get(0));
				solution.getVariable(0).getSolutions().get(0).getSelectedArtifacts().add(artifact);
			}
		}
		
		return solution;
	}
	
	private NRPSolution createCompleteSolution() {
		NRPSolution solution = problem.createSolution();
		
		for (int i = 0; i < solution.getVariable(0).getAvailableArtifacts().size(); i++) {
				SoftwareArtifact artifact = solution.getVariable(0).getAvailableArtifacts().get(i);
				artifact.getSolutions().add(solution.getVariable(0).getSolutions().get(0));
				solution.getVariable(0).getSolutions().get(0).getSelectedArtifacts().add(artifact);
		}
		
		return solution;
	}
	
	// https://link.springer.com/content/pdf/10.1007%2F978-3-319-13650-9.pdf
	private List<NRPSolution> createPopulationEPR(int size) {
		List<NRPSolution> population = new ArrayList<>(size);
		
		population.add(problem.createSolution());
		createPath(30, population);
		population.add(createCompleteSolution());
		
		int solutionsCreated = population.size();
		
		while (solutionsCreated < size) {
			NRPSolution solution = createRandomSolution();
			// fixSolution(solution);
			population.add(solution);
			solutionsCreated++;
		}
		
		return population;	
	}
}
