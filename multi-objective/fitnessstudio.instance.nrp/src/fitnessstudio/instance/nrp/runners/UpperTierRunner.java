package fitnessstudio.instance.nrp.runners;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import nrp.model.nrp.*;
import de.uni_ko.fitnessstudio.lower.DomainModelCrossover;
import de.uni_ko.fitnessstudio.lower.DomainModelProblem;
import de.uni_ko.fitnessstudio.upper.UpperGAManager;
import de.uni_ko.fitnessstudio.util.GAConfiguration;
import de.uni_ko.fitnessstudio.util.ModelIO;
import fitnessstudio.instance.nrp.customized.NRPConstraintChecker;
import fitnessstudio.instance.nrp.customized.NRPConstraintChecker;
import fitnessstudio.instance.nrp.customized.NRPCrossover;
import fitnessstudio.instance.nrp.customized.NRPProblem;

@SuppressWarnings("all")
public class UpperTierRunner {
	private static String INPUT_MODEL_ID = "A";
	private static String INPUT_MODEL = "input\\" + INPUT_MODEL_ID + ".xmi";
	private static String OUTPUT_PREFIX = "output_rules\\" + INPUT_MODEL_ID + "\\"
			+ new SimpleDateFormat("HH_mm_ss").format(Calendar.getInstance().getTime()).toString() + "\\";

	private static int UPPER_TIER_ITERATIONS = 15;
	private static int UPPER_TIER_POPULATION_SIZE = 40;
	private static int LOWER_TIER_MAX_EVALUATIONS = 120;
	private static int LOWER_TIER_POPULATION_SIZE = 6;
	private static int RUNS = 10;
	private static int TIMEOUT = 90;
	
	private static GAConfiguration configurationUpper = new GAConfiguration(UPPER_TIER_ITERATIONS, UPPER_TIER_POPULATION_SIZE, true);
	private static GAConfiguration configurationLower = new GAConfiguration(LOWER_TIER_MAX_EVALUATIONS, LOWER_TIER_POPULATION_SIZE, false);

	public static void main(String[] args) {

		for (int i = 1; i <= RUNS; i++) {
			System.gc();
			System.out.println("============");
			System.out.println("Run " + i);
			System.out.println("============");

			long start = System.currentTimeMillis();

			NRPPackage.eINSTANCE.eClass();
			EPackage metaModel = NRPPackage.eINSTANCE;
			DomainModelProblem domainModelProblem = new NRPProblem(INPUT_MODEL_ID);
			DomainModelCrossover domainModelCrossover = new NRPCrossover(0.9);
			
			NRPConstraintChecker mutationConstraintChecker = new NRPConstraintChecker();
			EObject inputModel = ModelIO.loadModel(INPUT_MODEL);
			
			UpperGAManager manager = new UpperGAManager(mutationConstraintChecker, metaModel, domainModelProblem, domainModelCrossover,
					configurationUpper, configurationLower, inputModel, TIMEOUT);
			manager.setPrefix(OUTPUT_PREFIX + "\\"+i);
			double result = manager.runGA();

			long end = System.currentTimeMillis();
			long time = end - start;
			createLogEntry(i, result, time);
		}
	}

	private static void createLogEntry(int i, double result, long time) {
		String line = i + " \t " + time + " \t " + result + "\n";
		String path = OUTPUT_PREFIX + "log.txt";

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			bw.write(line);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
