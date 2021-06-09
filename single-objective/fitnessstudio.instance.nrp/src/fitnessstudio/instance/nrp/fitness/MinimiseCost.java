package fitnessstudio.instance.nrp.fitness;

import nrp.model.nrp.*;

public class MinimiseCost {

	public double computeFitness(NRP nextRelease) {
		double selectedArtifactsCost = nextRelease.getSolutions().get(0).getSelectedArtifacts().stream()
				.mapToDouble(sa -> sa.getCosts().get(0).getAmount())
				.sum();

		return selectedArtifactsCost;
	}

	public String getName() {
		return "Minimise Next Release Cost";
	}
}
