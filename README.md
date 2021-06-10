# FitnessStudio applied on the next release problem
*Generating Mutation Operators for a Search-Based Model-Driven Implementation of the Next Release Problem<br>*
based on *[FitnessStudio](https://github.com/dstrueber/fitnessstudio)*
## Contents
The repository contains two implementations:
- ***multi-objective***, a multi-objective implementation for the NRP using NSGA-II from JMetal consisting of the following projects:
  - ***de.uni_ko.fitnessstudio***, a framework for generating mutation operators re-implemented to use the multi-objective NSGA-II
  - ***fitnessstudio.instance.nrp***, a multi-objective instance for applying the framework to the [NRP case](https://mde-optimiser.github.io/case-studies/nrp/)
- ***single-objective***, a single-objective implementation for the NRP using a simple single-objective GA
  - ***de.uni_ko.fitnessstudio***, the [FitnessStudio](https://github.com/dstrueber/fitnessstudio) framework generating mutation operators including a few alterations
  - ***fitnessstudio.instance.nrp***,  a single-objective instance for applying the framework to the [NRP case](https://mde-optimiser.github.io/case-studies/nrp/)

Both implementations make use of the project ***nrp-model***, an EMF meta-model of the NRP by MDEOptimiser. 

## Usage
### Prerequisites
- We recommend using [Eclipse, Modeling Tools distribution](https://www.eclipse.org/downloads/packages/) together with [Henshin](https://www.eclipse.org/henshin/install.php)
###
