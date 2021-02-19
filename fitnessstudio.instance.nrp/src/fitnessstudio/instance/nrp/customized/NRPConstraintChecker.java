package fitnessstudio.instance.nrp.customized;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;

import nrp.model.nrp.*;
import de.uni_ko.fitnessstudio.upper.ConstraintChecker;
import fitnessstudio.instance.nrp.fitness.MinimiseCost;



public class NRPConstraintChecker implements ConstraintChecker {
	
	public boolean satisfiesMutationConstraints(Collection<Rule> content) {	
		for (Rule rule : content) {
			if (!satisfiesMutationConstraints(rule))
				return false;
		}

		return true;
	}

	public boolean satisfiesMutationConstraints(Rule rule) {
		if (creationOrDeletionViolatesConstraints(rule))
			return false;

		if (!satisfiesMutationConstraints(rule.getMultiRules())) {
			return false;
		}
		return true;
	}

	// All classes are fixed
	// All references except selectedArtifacts (and solutions software artifact is in) are fixed
	private static boolean creationOrDeletionViolatesConstraints(Rule rule) {
		Set<Node> deletionNodes = new HashSet<Node>(rule.getLhs().getNodes());
		Set<Node> creationNodes = new HashSet<Node>(rule.getRhs().getNodes());
		Map<Node, Node> nodesLhs2Rhs = new HashMap<Node, Node>();
		Map<Node, Node> nodesRhs2Lhs = new HashMap<Node, Node>();
		
		for (Mapping m : rule.getMappings()) {
			deletionNodes.remove(m.getOrigin());
			creationNodes.remove(m.getImage());
			
			nodesLhs2Rhs.put(m.getOrigin(), m.getImage());
			nodesRhs2Lhs.put(m.getImage(), m.getOrigin());
		}
		
		// A node is deleted or created, which is not allowed
		if (!deletionNodes.isEmpty() || !creationNodes.isEmpty()) {
			return true;
		}
		
		boolean deletionEdgeViolation = creationOrDeletionEdgeViolatesConstraints(nodesLhs2Rhs);
		boolean creationEdgeViolation = creationOrDeletionEdgeViolatesConstraints(nodesRhs2Lhs);
		if (deletionEdgeViolation || creationEdgeViolation) {
			return true;
		}
		
		return false;
	}

	private static boolean creationOrDeletionEdgeViolatesConstraints(Map<Node, Node> nodeMap) {
		for (Node x1 : nodeMap.keySet()) {		// lhs source node	
			for (Edge e : x1.getOutgoing()) {	// lhs edge	(x1 -> x2)
				Node x2 = e.getTarget();		// lhs target node
				Node y1 = nodeMap.get(x1);		// rhs source node (mapped)
				Node y2 = nodeMap.get(x2);		// rhs target node (mapped)
				
				// If rhs has no edge from source to target node
				// and lhs edge is not of type selectedartifacts/artifact_solutions
				if (/*y1 != null && y2 != null && */y1.getOutgoing(e.getType(), y2) == null) {
					
					if (e.getType() != NRPPackage.eINSTANCE.getSolution_SelectedArtifacts() && e.getType() != NRPPackage.eINSTANCE.getSoftwareArtifact_Solutions())
						return true;
						
				}
			}
		}
		
		return false;
	}
	public boolean satisfiesWellformednessConstraint(EObject nrp) {
		return new MinimiseCost().computeFitness((NRP) nrp) < 9999999;//1600;
		//return true; //SatisfactionCalculator.calculateSatisfaction((NRP) model) < 400; //CRAIndexCalculator.isCorrect((ClassModel) model);
	}

}
