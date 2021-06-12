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
- [Eclipse, Modeling Tools distribution](https://www.eclipse.org/downloads/packages/) together with [Henshin](https://www.eclipse.org/henshin/install.php)
- [Maven for Eclipse](https://www.eclipse.org/m2e/) for the multi-objective implementation for importing the JMetal dependencies 
### Upper-tier: generating mutation operators
- Execute the provided runner class de.uni_ko.fitnessstudio.instance.nrp.runners.UpperTierRunner to generate mutation operators. The generation has a couple of configuration options, as can all be set directly in the class.
- After starting the runner class, you should see console output informing you about the generation process.
- The results of the generation process (.henshin files and logs) will be stored to the directory output_rules within the project -- in doubt, please refresh the package explorer using F5.
### Lower-tier: generating solutions using a generated mutation operator
- The solution generation will take the .henshin module used for mutation from the directory de.uni_ko.fitnessstudio.instance.nrp/transformation/fixed. Per default, this directory contains the mutation operator generated during our initial experiments. To use an alternative module, place it in the fixed directory and make sure it's the only .henshin file in this directory.
- Execute the provided runner class de.uni_ko.fitnessstudio.instance.nrp.runners.LowerTierRunnerWithFixed to generate solutions based on the provided mutation operator. Again, a couple of configuration options are available.
- After starting the runner class, you should see console output informing you about the generation process.
- The results of the generation process will be stored to the directory output_models within the project -- in doubt, please refresh the package explorer using F5.
- Remark: As fixed muatation ruleset, de.uni_ko.fitnessstudio.transformation.genetic.mutation.henshin is used. This mutation operator is provided as [part of the MDEOptimiser project](https://mde-optimiser.github.io/case-studies/nrp/).


