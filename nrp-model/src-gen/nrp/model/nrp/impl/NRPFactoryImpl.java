/**
 */
package nrp.model.nrp.impl;

import nrp.model.nrp.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NRPFactoryImpl extends EFactoryImpl implements NRPFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NRPFactory init() {
		try {
			NRPFactory theNRPFactory = (NRPFactory) EPackage.Registry.INSTANCE.getEFactory(NRPPackage.eNS_URI);
			if (theNRPFactory != null) {
				return theNRPFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NRPFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NRPFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case NRPPackage.NRP:
			return createNRP();
		case NRPPackage.CUSTOMER:
			return createCustomer();
		case NRPPackage.COST:
			return createCost();
		case NRPPackage.SOFTWARE_ARTIFACT:
			return createSoftwareArtifact();
		case NRPPackage.REQUIREMENT:
			return createRequirement();
		case NRPPackage.REQUIREMENT_REALISATION:
			return createRequirementRealisation();
		case NRPPackage.SOLUTION:
			return createSolution();
		case NRPPackage.VALUATION:
			return createValuation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case NRPPackage.COST_TYPE:
			return createCostTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case NRPPackage.COST_TYPE:
			return convertCostTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NRP createNRP() {
		NRPImpl nrp = new NRPImpl();
		return nrp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer createCustomer() {
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cost createCost() {
		CostImpl cost = new CostImpl();
		return cost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareArtifact createSoftwareArtifact() {
		SoftwareArtifactImpl softwareArtifact = new SoftwareArtifactImpl();
		return softwareArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementRealisation createRequirementRealisation() {
		RequirementRealisationImpl requirementRealisation = new RequirementRealisationImpl();
		return requirementRealisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution createSolution() {
		SolutionImpl solution = new SolutionImpl();
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Valuation createValuation() {
		ValuationImpl valuation = new ValuationImpl();
		return valuation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostType createCostTypeFromString(EDataType eDataType, String initialValue) {
		CostType result = CostType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCostTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NRPPackage getNRPPackage() {
		return (NRPPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NRPPackage getPackage() {
		return NRPPackage.eINSTANCE;
	}

} //NRPFactoryImpl
