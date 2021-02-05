package fitnessstudio.instance.nrp.customized;

import de.uni_ko.fitnessstudio.lower.DomainModel;
import de.uni_ko.fitnessstudio.lower.DomainModelFitness;
import fitnessstudio.instance.nrp.fitness.MaximiseSatisfaction;
import fitnessstudio.instance.nrp.fitness.MaximiseSatisfactionReimplemented;

/**
 *  Fitness function, which calculates difference two chromosomes.
 * @author strueber
 *
 */
	public class NRPFitness implements DomainModelFitness {
		@Override
		public Double calculate(DomainModel chromosome) {
			return new MaximiseSatisfactionReimplemented().computeFitness(chromosome);
			//new MaximiseSatisfactionReimplemented().computeFitness((NRP) chromosome.getContent());
			//return new MaximiseSatisfaction().computeFitness(((NRP) chromosome.getContent()).getSolutions().get(0));
			//return SatisfactionCalculator.calculateSatisfaction((NRP) chromosome.getContent());
		}
	}
