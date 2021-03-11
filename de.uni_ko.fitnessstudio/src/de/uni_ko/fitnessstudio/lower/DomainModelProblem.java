package de.uni_ko.fitnessstudio.lower;

import org.uma.jmetal.problem.Problem;

@SuppressWarnings("serial")
public abstract class DomainModelProblem<S> implements Problem<DomainModelSolution<S>> {
	private int numberOfVariables;
	private int numberOfObjectives;
	private int numberOfConstraints;

	public DomainModelProblem(int variables, int objectives, int constraints) {
		this.numberOfVariables = variables;
		this.numberOfObjectives = objectives;
		this.numberOfConstraints = constraints;
	}
	
	@Override
	public int getNumberOfVariables() {
		return numberOfVariables;
	}

	@Override
	public int getNumberOfObjectives() {
		return numberOfObjectives;
	}

	@Override
	public int getNumberOfConstraints() {
		return numberOfConstraints;
	}

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public void evaluate(DomainModelSolution<S> solution) {
		// TODO change 42 to DomainModelFitness 
		for (int i = 0; i < numberOfVariables; i++) {
			solution.setObjective(i, 42);
		}
	}
}
