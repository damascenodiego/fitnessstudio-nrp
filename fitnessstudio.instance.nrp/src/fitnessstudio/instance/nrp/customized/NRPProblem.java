package fitnessstudio.instance.nrp.customized;

import de.uni_ko.fitnessstudio.lower.DomainModelProblem;
import de.uni_ko.fitnessstudio.lower.DomainModelSolution;
import nrp.model.nrp.NRP;

public class NRPProblem extends DomainModelProblem<NRP> {

	public NRPProblem(int variables, int objectives, int constraints) {
		super(variables, objectives, constraints);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DomainModelSolution<NRP> createSolution() {
		return new NRPSolution(getNumberOfVariables(), getNumberOfObjectives());
	}

}
