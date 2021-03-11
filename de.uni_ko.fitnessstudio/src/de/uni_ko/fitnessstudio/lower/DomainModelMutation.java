package de.uni_ko.fitnessstudio.lower;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.util.checking.Check;

import de.uni_ko.fitnessstudio.util.EngineFactory;

@SuppressWarnings("serial")
public class DomainModelMutation<S> implements MutationOperator<DomainModelSolution<S>> {
	static boolean initialized = false;
	static Set<Rule> defaultRules;
	
	Engine engine = EngineFactory.createEngine();
	Set<Rule> genRules;
	Set<Unit> fixedRules;
	
	private double mutationProbability;
	
	/** Constructor */
	/*public NRPMutator(double probability) {
		initDefaultRules();
		this.genRules = defaultRules;
		this.fixedRules = new HashSet<>();
		
		this.mutationProbability = probability;
	}*/
	
	/** Constructor */
	public DomainModelMutation(Set<Rule> genRules, double probability) {
		this.genRules = genRules;
		this.fixedRules = new HashSet<>();
		
		this.mutationProbability = probability;
	}
	
	/** Constructor */
	public DomainModelMutation(Set<Rule> genRules, Set<Unit> fixedRules, double probability) {
		this.genRules = genRules;
		this.fixedRules = fixedRules;
		
		this.mutationProbability = probability;
	}
	
	@Override
	public DomainModelSolution<S> execute(DomainModelSolution<S> solution) {
		Check.isNotNull(solution);
		
		EGraph graph = new EGraphImpl((EObject) solution.getVariable(0));
		
		for (Unit unit : fixedRules) {
			if (Math.random() < mutationProbability) {
				UnitApplication app = new UnitApplicationImpl(engine, graph, unit, null);
				app.execute(null);
			}
		}
	
		for (Rule rule : genRules) {
			if (Math.random() < mutationProbability) {
				RuleApplication ruleApp = new RuleApplicationImpl(engine, graph, rule, null);
				ruleApp.execute(null);
			}
		}

		graph.clear();
		
		return solution;
	}
	/*
	private void initDefaultRules() {
		if (initialized)
			return;
		HenshinResourceSet resourceSet = new HenshinResourceSet();
		loadDefaultRules(resourceSet);
		initialized = true;
	}
	
	public void loadDefaultRules(ResourceSet resSet) {
		Resource resource = resSet.getResource(URI.createURI("transformation\\example.henshin"), true);
		Module module = (Module) resource.getContents().get(0);
		defaultRules = new HashSet<Rule>();
		for (Unit u : module.getUnits()) {
			if (u instanceof Rule)
				defaultRules.add(((Rule) u));
		}
	}*/

	@Override
	public double getMutationProbability() {
		return mutationProbability;
	}


}
