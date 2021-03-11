package fitnessstudio.instance.nrp.customized;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.util.pseudorandom.BoundedRandomGenerator;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;
import org.uma.jmetal.util.pseudorandom.RandomGenerator;

import de.uni_ko.fitnessstudio.lower.DomainModelCrossover;
import nrp.model.nrp.NRP;
import nrp.model.nrp.SoftwareArtifact;


@SuppressWarnings("serial")
public class NRPCrossover implements DomainModelCrossover<NRPSolution> {

	private double crossoverProbability;
	private RandomGenerator<Double> crossoverRandomGenerator;
	private BoundedRandomGenerator<Integer> pointRandomGenerator;
	
	/** Constructor */
	public NRPCrossover(double probability) {
		this.crossoverProbability = probability;
		this.crossoverRandomGenerator = () -> JMetalRandom.getInstance().nextDouble();
		this.pointRandomGenerator = (a, b) -> JMetalRandom.getInstance().nextInt(a, b);
	}
	
	@Override
	public double getCrossoverProbability() {
		return crossoverProbability;
	}

	@Override
	public int getNumberOfRequiredParents() {
		return 2;
	}

	@Override
	public int getNumberOfGeneratedChildren() {
		return 2;
	}

	@Override
	public List<NRPSolution> execute(List<NRPSolution> parents) {
		List<NRPSolution> offspring = new ArrayList<>(2);
		offspring.add((NRPSolution) parents.get(0).copy());
	    offspring.add((NRPSolution) parents.get(1).copy());
		
	    if (crossoverRandomGenerator.getRandomValue() > crossoverProbability)
	    	return offspring;
	    
	    int availableArtifacts = parents.get(0).getVariable(0).getAvailableArtifacts().size();
	    int pivot = pointRandomGenerator.getRandomValue(0, availableArtifacts - 1);
	    
	    for (NRPSolution child : offspring) {
	    	doCrossover(parents.get(0).getVariable(0), parents.get(1).getVariable(0), child.getVariable(0), pivot);
	    }
	    
	    return offspring;
	}
	
	public void doCrossover(NRP parent1, NRP parent2, NRP child, int pivot) {
		child.getSolutions().get(0).getSelectedArtifacts().clear();
		
		int n = 0;
		for (SoftwareArtifact artifact : child.getAvailableArtifacts()) {
			if (n < pivot) {
				for (SoftwareArtifact p1_artifact : parent1.getSolutions().get(0).getSelectedArtifacts()) {
					if (artifact.getName() == p1_artifact.getName()) {
						child.getSolutions().get(0).getSelectedArtifacts().add(artifact);
					}
				}
			} else {
				for (SoftwareArtifact p2_artifact : parent2.getSolutions().get(0).getSelectedArtifacts()) {
					if (artifact.getName() == p2_artifact.getName()) {
						child.getSolutions().get(0).getSelectedArtifacts().add(artifact);
					}
				}
			}
			n++;
		}
	}
}