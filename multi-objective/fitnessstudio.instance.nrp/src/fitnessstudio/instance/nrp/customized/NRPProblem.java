package fitnessstudio.instance.nrp.customized;

import org.uma.jmetal.util.checking.Check;

import de.uni_ko.fitnessstudio.lower.DomainModelProblem;
import de.uni_ko.fitnessstudio.lower.DomainModelSolution;
import fitnessstudio.instance.nrp.fitness.MaximiseSatisfaction;
import fitnessstudio.instance.nrp.fitness.MinimiseCost;
import nrp.model.nrp.NRP;


@SuppressWarnings("serial")
public class NRPProblem extends DomainModelProblem<NRP> {
	private final MaximiseSatisfaction satisfaction;
	private final MinimiseCost cost;
	
	public NRPProblem(int variables, int objectives, int constraints) {
		super(variables, objectives, constraints);
		
		this.satisfaction = new MaximiseSatisfaction();
		this.cost = new MinimiseCost();
	}

	@Override
	public DomainModelSolution<NRP> createSolution() {
		return new NRPSolution(getNumberOfVariables(), getNumberOfObjectives());
	}

	@Override
	public void evaluate(DomainModelSolution<NRP> solution) {
		Check.isNotNull(solution);
	    Check.that(getNumberOfObjectives() == 2, "There must be 2 objectives instead of " + getNumberOfObjectives());
		
		solution.setObjective(0, -satisfaction.computeFitness(solution.getVariable(0)));
		solution.setObjective(1, cost.computeFitness(solution.getVariable(0)));
	}
}
