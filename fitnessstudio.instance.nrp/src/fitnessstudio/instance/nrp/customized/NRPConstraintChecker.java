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

import de.uni_ko.fitnessstudio.upper.ConstraintChecker;
import fitnessstudio.instance.nrp.fitness.MinimiseCost;
import nrp.model.nrp.NRP;
import nrp.model.nrp.NRPPackage;

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

	private static boolean creationOrDeletionViolatesConstraints(Rule rule) {
		Set<Node> deletionNodes = new HashSet<Node>(rule.getLhs().getNodes());
		Set<Node> creationNodes = new HashSet<Node>(rule.getRhs().getNodes());
		Map<Node, Node> preservedNodesLhs2Rhs = new HashMap<Node, Node>();
		Map<Node, Node> preservedNodesRhs2Lhs = new HashMap<Node, Node>();
		for (Mapping m : rule.getMappings()) {
			deletionNodes.remove(m.getOrigin());
			creationNodes.remove(m.getImage());
			preservedNodesLhs2Rhs.put(m.getOrigin(), m.getImage());
			preservedNodesRhs2Lhs.put(m.getImage(), m.getOrigin());
		}

		// May not create or delete nodes
		if (!deletionNodes.isEmpty() || !creationNodes.isEmpty()) {
			return true;
		}
		
		// Require edge creation
		//if (!edgeDeleted(preservedNodesLhs2Rhs))
			//return true;
		
		
		// May not create or delete node other than SelectedArtifacts/Solutions
		
		if (createOrDeleteEdgesViolateConstraints(deletionNodes, preservedNodesLhs2Rhs))
			return true;

		if (createOrDeleteEdgesViolateConstraints(creationNodes, preservedNodesRhs2Lhs))
			return true;

		return false;
	}
	
	private static boolean edgeDeleted(Map<Node, Node> graph2graph) {
		for (Node x1 : graph2graph.keySet()) {
			for (Edge e : x1.getOutgoing()) {
				Node x2 = e.getTarget();
				Node y1 = graph2graph.get(x1);
				Node y2 = graph2graph.get(x2);
				if (y1 != null && y2 != null && y1.getOutgoing(e.getType(), y2) == null)
					return true;
						
			}
		}
		
		return false;
	}

	private static boolean createOrDeleteEdgesViolateConstraints(Set<Node> nodes, Map<Node, Node> graph2graph) {
		// An edge is <<delete>> or <<create>>:
		// If its source and target nodes, x1 and x2, are
		// <<preserve>>, but the edge itself, e, has no
		// counterpart between the source and target node counterparts,
		// y1 and y2
		//boolean edgeCreationOrDeletion = false;
		
		for (Node x1 : graph2graph.keySet()) {
			for (Edge e : x1.getOutgoing()) {
				Node x2 = e.getTarget();
				Node y1 = graph2graph.get(x1);
				Node y2 = graph2graph.get(x2);
				if (y1 != null && y2 != null && y1.getOutgoing(e.getType(), y2) == null)
					if (e.getType() != NRPPackage.eINSTANCE.getSolution_SelectedArtifacts() && e.getType() != NRPPackage.eINSTANCE.getSoftwareArtifact_Solutions())
						return true;
					//else
						//edgeCreationOrDeletion = true;
						
			}
		}
		
		return false;
	}

	public boolean satisfiesWellformednessConstraint(EObject model) {
		return true; //new MinimiseCost().computeFitness((NRP) model) < 600;
	}
	
}
