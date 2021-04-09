package fitnessstudio.instance.nrp.customized;

import java.util.Map;

import org.apache.commons.math3.util.Pair;

import de.uni_ko.fitnessstudio.lower.DomainModel;
import de.uni_ko.fitnessstudio.lower.DomainModelFitness;
import fitnessstudio.instance.nrp.fitness.MaximiseSatisfaction;
import fitnessstudio.instance.nrp.fitness.MaximiseSatisfactionReimplemented;
import fitnessstudio.instance.nrp.fitness.MinimiseCost;
import nrp.model.nrp.NRP;

/**
 *  Fitness function, which calculates difference two chromosomes.
 * @author strueber
 *
 */
	public class NRPFitness implements DomainModelFitness {
		private final double MAX_COST;// = 18235.0;//4506.0; // 45655.0;// 15311.0;//
		private final double MAX_SATISFACTION;// = 189.02348728630915;//26.293290563920287; //591.5534983624794;// 202.67799216253337;//
		
		private static Map<String, Double> maxCost = Map.of(
				"A", 4506.0,
				"B", 15311.0,
				"C", 24137.0,
				"D", 32177.0,
				"E", 45655.0
			);
		
		private static Map<String, Double> maxSatisfaction = Map.of(
				"A", 26.293290563920287,
				"B", 202.67799216253337,
				"C", 244.25945253000054,
				"D", 603.1506135568646,
				"E", 591.5534983624794
			);
		
		
		public NRPFitness(String model) {
			this.MAX_COST = maxCost.get(model);
			this.MAX_SATISFACTION = maxSatisfaction.get(model);
		}
		
		@Override
		public Double calculate(DomainModel chromosome) {
			NRP nextRelease = (NRP) chromosome.getContent();
			
			Double cost = calculateCost(nextRelease) / MAX_COST;
			Double satisfaction = calculateSatisfaction(nextRelease) / MAX_SATISFACTION;
			
			return satisfaction - cost;
		}
		
		private Double calculateCost(NRP nextRelease) {
			return new MinimiseCost().computeFitness(nextRelease);
		}
		
		private Double calculateSatisfaction(NRP nextRelease) {
			return new MaximiseSatisfactionReimplemented().computeFitness(nextRelease);
		}
	}
