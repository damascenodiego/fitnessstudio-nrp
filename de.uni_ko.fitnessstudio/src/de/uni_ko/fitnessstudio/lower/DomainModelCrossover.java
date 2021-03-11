package de.uni_ko.fitnessstudio.lower;

import java.util.List;

import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.util.checking.Check;
import org.uma.jmetal.util.pseudorandom.BoundedRandomGenerator;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;
import org.uma.jmetal.util.pseudorandom.RandomGenerator;

import nrp.model.nrp.NRP;


@SuppressWarnings("serial")
public interface DomainModelCrossover<S> extends CrossoverOperator<S> {
	
}
