package fitnessstudio.instance.nrp.customized;

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
		private static double MAX_COST = 4506.0; // 15311.0;//
		private static double MAX_SATISFACTION = 26.293290563920287; // 202.67799216253337;//
		
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
