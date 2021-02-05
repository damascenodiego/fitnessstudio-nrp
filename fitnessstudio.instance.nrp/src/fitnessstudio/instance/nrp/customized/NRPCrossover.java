package fitnessstudio.instance.nrp.customized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.emf.ecore.util.EcoreUtil;

import nrp.model.nrp.*;

//import architectureCRA.ArchitectureCRAFactory;
//import architectureCRA.Class;
//import architectureCRA.ClassModel;
//import architectureCRA.Feature;
import de.uni_ko.fitnessstudio.lower.DomainModel;
import de.uni_ko.fitnessstudio.lower.DomainModelCrossover;

public class NRPCrossover implements DomainModelCrossover {

	public List<DomainModel> crossover(DomainModel parent1, DomainModel parent2) {
		List<DomainModel> result = new ArrayList<DomainModel>();
		
		NRP p1 = (NRP) EcoreUtil.copy(parent1.getContent());
		NRP p2 = (NRP) EcoreUtil.copy(parent2.getContent());
		
		// Random integer
		//	minimum: 0
		//	maximum: size - 1
		int pivot = ThreadLocalRandom.current().nextInt(0, p1.getAvailableArtifacts().size());
		
		//result.add(new DomainModel(createChild(p1, p2, pivot), parent1.getMutator(), parent1.getCrossover(), parent1.getFitness()));
		//result.add(new DomainModel(createChild(p2, p1, pivot), parent1.getMutator(), parent1.getCrossover(), parent1.getFitness()));
		result.add(new DomainModel(p1, parent1.getMutator(), parent1.getCrossover(), parent1.getFitness()));
		result.add(new DomainModel(p2, parent2.getMutator(), parent2.getCrossover(), parent2.getFitness()));
		
		return result;
	}

	private NRP createChild(NRP p1, NRP p2, int pivot) {
		NRP child = (NRP) EcoreUtil.copy(p1);
		child.getSolutions().get(0).getSelectedArtifacts().clear();
		
		int n = 0;
		for (SoftwareArtifact artifact : child.getAvailableArtifacts()) {
			if (n < pivot) {
				for (SoftwareArtifact p1_artifact : p1.getSolutions().get(0).getSelectedArtifacts()) {
					if (artifact.getName() == p1_artifact.getName()) {
						child.getSolutions().get(0).getSelectedArtifacts().add(artifact);
					}
				}
			} else {
				for (SoftwareArtifact p2_artifact : p2.getSolutions().get(0).getSelectedArtifacts()) {
					if (artifact.getName() == p2_artifact.getName()) {
						child.getSolutions().get(0).getSelectedArtifacts().add(artifact);
					}
				}
			}
			n++;
		}
		
		return child;
	}
	
}
