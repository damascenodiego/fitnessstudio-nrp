package fitnessstudio.instance.nrp.customized;

import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.uma.jmetal.solution.Solution;

import de.uni_ko.fitnessstudio.lower.DomainModelSolution;
import de.uni_ko.fitnessstudio.util.ModelIO;
import nrp.model.nrp.NRP;
import nrp.model.nrp.SoftwareArtifact;

@SuppressWarnings("serial")
public class NRPSolution extends DomainModelSolution<NRP> {
	private static String INPUT_MODEL_ID = "NRP3";
	private static String INPUT_MODEL = "input\\" + INPUT_MODEL_ID+".xmi";
	
	/** Constructor */
	protected NRPSolution(int numberOfVariables, int numberOfObjectives) {
		super(numberOfVariables, numberOfObjectives, 0);

		NRP inputModel = (NRP) ModelIO.loadModel(INPUT_MODEL);
		
		for (SoftwareArtifact artifact : inputModel.getAvailableArtifacts()) {
			inputModel.getSolutions().get(0).getSelectedArtifacts().add(artifact);
		}
		
		super.setVariable(0, inputModel);
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

	@Override
	public Solution<NRP> copy() {
		// TODO Auto-generated method stub
		return new NRPSolution(this);
	}

}
