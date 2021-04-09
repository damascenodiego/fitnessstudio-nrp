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
	
		// Single Point Crossover with P_c = 0.9
		if (Math.random() < 0.9) {
			NRP p1 = (NRP) parent1.getContent();
			NRP p2 = (NRP) parent2.getContent();
			
			int pivot = ThreadLocalRandom.current().nextInt(p1.getAvailableArtifacts().size());
			
			result.add(new DomainModel(createChild(p1, p2, pivot), parent1.getMutator(), parent1.getCrossover(), parent1.getFitness()));
			result.add(new DomainModel(createChild(p2, p1, pivot), parent2.getMutator(), parent2.getCrossover(), parent2.getFitness()));
		} else {
			result.add(parent1);
			result.add(parent2);
		}
		
		return result;
	}

	private NRP createChild(NRP p1, NRP p2, int pivot) {
		NRP child = (NRP) EcoreUtil.copy(p1);
		child.getSolutions().get(0).getSelectedArtifacts().clear();
		
		int n = 0;
		for (SoftwareArtifact artifact : child.getAvailableArtifacts()) {
			artifact.getSolutions().clear();
			
			if (n < pivot) {
				for (SoftwareArtifact p1_artifact : p1.getSolutions().get(0).getSelectedArtifacts()) {
					if (artifact.getName().equals(p1_artifact.getName())) {
						artifact.getSolutions().add(child.getSolutions().get(0));
						child.getSolutions().get(0).getSelectedArtifacts().add(artifact);
						break;
					}
				}
			} else {
				for (SoftwareArtifact p2_artifact : p2.getSolutions().get(0).getSelectedArtifacts()) {
					if (artifact.getName().equals(p2_artifact.getName())) {
						artifact.getSolutions().add(child.getSolutions().get(0));
						child.getSolutions().get(0).getSelectedArtifacts().add(artifact);
						break;
					}
				}
			}
			n++;
		}
		
		return child;
	}
}
