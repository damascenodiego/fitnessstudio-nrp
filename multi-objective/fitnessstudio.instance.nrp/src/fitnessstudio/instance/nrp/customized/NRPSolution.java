package fitnessstudio.instance.nrp.customized;

import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;
import org.uma.jmetal.util.pseudorandom.RandomGenerator;

import de.uni_ko.fitnessstudio.lower.DomainModelSolution;
import de.uni_ko.fitnessstudio.util.ModelIO;
import nrp.model.nrp.NRP;
import nrp.model.nrp.SoftwareArtifact;

@SuppressWarnings("serial")
public class NRPSolution extends DomainModelSolution<NRP> {
	

	private RandomGenerator<Double> solutionRandomGenerator;
	
	/** Constructor */
	protected NRPSolution(int numberOfVariables, int numberOfObjectives, String inputModelId) {
		super(numberOfVariables, numberOfObjectives, 0);

		this.solutionRandomGenerator = () -> JMetalRandom.getInstance().nextDouble();
		
		String path = "input\\" + inputModelId + ".xmi";
		// NRP solution = createRandomSolution(path);
		NRP solution = createExtremeSolution(path);
		// NRP solution = createEmptySolution(path);
		
		super.setVariable(0, solution);
	}
	
	/** Constructor */
	public NRPSolution(NRPSolution solution) {
		super(solution.getNumberOfVariables(), solution.getNumberOfObjectives(), solution.getNumberOfConstraints());
		
		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			NRP deepCopy = (NRP) EcoreUtil.copy(solution.getVariable(i));;
			setVariable(i, deepCopy);
	    }

	    for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
	    	setObjective(i, solution.getObjective(i)) ;
	    }

	    for (int i = 0; i < solution.getNumberOfConstraints(); i++) {
	    	setConstraint(i, solution.getConstraint(i));
	    }

	    attributes = new HashMap<Object, Object>(solution.attributes) ;
	}

	private NRP createExtremeSolution(String path) {
		NRP inputModel = (NRP) ModelIO.loadModel(path);
		
		if (Math.random() > 0.5) {
			for (int i = 0; i < inputModel.getAvailableArtifacts().size(); i++) {
					SoftwareArtifact artifact = inputModel.getAvailableArtifacts().get(i);
					artifact.getSolutions().add(inputModel.getSolutions().get(0));
					inputModel.getSolutions().get(0).getSelectedArtifacts().add(artifact);
			}
		}
		
		return inputModel;
	}
	
	private NRP createRandomSolution(String path) {
		NRP inputModel = (NRP) ModelIO.loadModel(path);
		for (int i = 0; i < inputModel.getAvailableArtifacts().size(); i++) {
			if (solutionRandomGenerator.getRandomValue() > 0.5) {
				SoftwareArtifact artifact = inputModel.getAvailableArtifacts().get(i);
				artifact.getSolutions().add(inputModel.getSolutions().get(0));
				inputModel.getSolutions().get(0).getSelectedArtifacts().add(artifact);
			}
		}
		
		return inputModel;
	}
	
	private NRP createCompleteSolution(String path) {
		NRP inputModel = (NRP) ModelIO.loadModel(path);
		for (int i = 0; i < inputModel.getAvailableArtifacts().size(); i++) {
				SoftwareArtifact artifact = inputModel.getAvailableArtifacts().get(i);
				artifact.getSolutions().add(inputModel.getSolutions().get(0));
				inputModel.getSolutions().get(0).getSelectedArtifacts().add(artifact);
		}
		
		return inputModel;
	}
	
	private NRP createEmptySolution(String path) {
		NRP inputModel = (NRP) ModelIO.loadModel(path);
		
		return inputModel;
	}
	
	@Override
	public Solution<NRP> copy() {
		return new NRPSolution(this);
	}

}
