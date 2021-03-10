package de.uni_ko.fitnessstudio.lower;

import java.util.List;

import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.util.comparator.RankingAndCrowdingDistanceComparator;

public class LowerNSGAIIManager {
	DomainModelProblem problem;
	DomainModelCrossover crossover;
	DomainModelMutator mutator;
	SelectionOperator<List<DomainModelSolution>, DomainModelSolution> selection;
	
	public LowerNSGAIIManager() {
		
	}
	
	public void runNSGAII() {
		selection = new BinaryTournamentSelection<>(new RankingAndCrowdingDistanceComparator<>());
	}
}
