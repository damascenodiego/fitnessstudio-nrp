/**
 */
package nrp.model.nrp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see nrp.model.nrp.NRPFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface NRPPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nrp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://nrp.model/nrp";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nrp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NRPPackage eINSTANCE = nrp.model.nrp.impl.NRPPackageImpl.init();

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.NRPImpl <em>NRP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.NRPImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getNRP()
	 * @generated
	 */
	int NRP = 0;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NRP__CUSTOMERS = 0;

	/**
	 * The feature id for the '<em><b>Available Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NRP__AVAILABLE_ARTIFACTS = 1;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NRP__REQUIREMENTS = 2;

	/**
	 * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NRP__SOLUTIONS = 3;

	/**
	 * The number of structural features of the '<em>NRP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NRP_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>NRP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NRP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.CustomerImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Importance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__IMPORTANCE = 1;

	/**
	 * The feature id for the '<em><b>Assigns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__ASSIGNS = 2;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.CostImpl <em>Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.CostImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getCost()
	 * @generated
	 */
	int COST = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__AMOUNT = 1;

	/**
	 * The number of structural features of the '<em>Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.SoftwareArtifactImpl <em>Software Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.SoftwareArtifactImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getSoftwareArtifact()
	 * @generated
	 */
	int SOFTWARE_ARTIFACT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_ARTIFACT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_ARTIFACT__REQUIRES = 1;

	/**
	 * The feature id for the '<em><b>Costs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_ARTIFACT__COSTS = 2;

	/**
	 * The feature id for the '<em><b>Contributes To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_ARTIFACT__CONTRIBUTES_TO = 3;

	/**
	 * The feature id for the '<em><b>Solutions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_ARTIFACT__SOLUTIONS = 4;

	/**
	 * The number of structural features of the '<em>Software Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_ARTIFACT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Software Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_ARTIFACT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.RequirementImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Valuations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__VALUATIONS = 1;

	/**
	 * The feature id for the '<em><b>Realisations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REALISATIONS = 2;

	/**
	 * The feature id for the '<em><b>Combines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__COMBINES = 3;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.RequirementRealisationImpl <em>Requirement Realisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.RequirementRealisationImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getRequirementRealisation()
	 * @generated
	 */
	int REQUIREMENT_REALISATION = 5;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_REALISATION__REQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_REALISATION__PERCENTAGE = 1;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_REALISATION__DEPENDS_ON = 2;

	/**
	 * The number of structural features of the '<em>Requirement Realisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_REALISATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Requirement Realisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_REALISATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.SolutionImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 6;

	/**
	 * The feature id for the '<em><b>Selected Artifacts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__SELECTED_ARTIFACTS = 0;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.impl.ValuationImpl <em>Valuation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.impl.ValuationImpl
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getValuation()
	 * @generated
	 */
	int VALUATION = 7;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUATION__REQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUATION__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Assigned By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUATION__ASSIGNED_BY = 2;

	/**
	 * The feature id for the '<em><b>Contributes To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUATION__CONTRIBUTES_TO = 3;

	/**
	 * The number of structural features of the '<em>Valuation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Valuation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nrp.model.nrp.CostType <em>Cost Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nrp.model.nrp.CostType
	 * @see nrp.model.nrp.impl.NRPPackageImpl#getCostType()
	 * @generated
	 */
	int COST_TYPE = 8;

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.NRP <em>NRP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NRP</em>'.
	 * @see nrp.model.nrp.NRP
	 * @generated
	 */
	EClass getNRP();

	/**
	 * Returns the meta object for the containment reference list '{@link nrp.model.nrp.NRP#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customers</em>'.
	 * @see nrp.model.nrp.NRP#getCustomers()
	 * @see #getNRP()
	 * @generated
	 */
	EReference getNRP_Customers();

	/**
	 * Returns the meta object for the containment reference list '{@link nrp.model.nrp.NRP#getAvailableArtifacts <em>Available Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Artifacts</em>'.
	 * @see nrp.model.nrp.NRP#getAvailableArtifacts()
	 * @see #getNRP()
	 * @generated
	 */
	EReference getNRP_AvailableArtifacts();

	/**
	 * Returns the meta object for the containment reference list '{@link nrp.model.nrp.NRP#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see nrp.model.nrp.NRP#getRequirements()
	 * @see #getNRP()
	 * @generated
	 */
	EReference getNRP_Requirements();

	/**
	 * Returns the meta object for the containment reference list '{@link nrp.model.nrp.NRP#getSolutions <em>Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solutions</em>'.
	 * @see nrp.model.nrp.NRP#getSolutions()
	 * @see #getNRP()
	 * @generated
	 */
	EReference getNRP_Solutions();

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see nrp.model.nrp.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.Customer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nrp.model.nrp.Customer#getName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Name();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.Customer#getImportance <em>Importance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Importance</em>'.
	 * @see nrp.model.nrp.Customer#getImportance()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Importance();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.Customer#getAssigns <em>Assigns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assigns</em>'.
	 * @see nrp.model.nrp.Customer#getAssigns()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Assigns();

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.Cost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cost</em>'.
	 * @see nrp.model.nrp.Cost
	 * @generated
	 */
	EClass getCost();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.Cost#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see nrp.model.nrp.Cost#getType()
	 * @see #getCost()
	 * @generated
	 */
	EAttribute getCost_Type();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.Cost#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see nrp.model.nrp.Cost#getAmount()
	 * @see #getCost()
	 * @generated
	 */
	EAttribute getCost_Amount();

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.SoftwareArtifact <em>Software Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Artifact</em>'.
	 * @see nrp.model.nrp.SoftwareArtifact
	 * @generated
	 */
	EClass getSoftwareArtifact();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.SoftwareArtifact#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nrp.model.nrp.SoftwareArtifact#getName()
	 * @see #getSoftwareArtifact()
	 * @generated
	 */
	EAttribute getSoftwareArtifact_Name();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.SoftwareArtifact#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requires</em>'.
	 * @see nrp.model.nrp.SoftwareArtifact#getRequires()
	 * @see #getSoftwareArtifact()
	 * @generated
	 */
	EReference getSoftwareArtifact_Requires();

	/**
	 * Returns the meta object for the containment reference list '{@link nrp.model.nrp.SoftwareArtifact#getCosts <em>Costs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Costs</em>'.
	 * @see nrp.model.nrp.SoftwareArtifact#getCosts()
	 * @see #getSoftwareArtifact()
	 * @generated
	 */
	EReference getSoftwareArtifact_Costs();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.SoftwareArtifact#getContributesTo <em>Contributes To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributes To</em>'.
	 * @see nrp.model.nrp.SoftwareArtifact#getContributesTo()
	 * @see #getSoftwareArtifact()
	 * @generated
	 */
	EReference getSoftwareArtifact_ContributesTo();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.SoftwareArtifact#getSolutions <em>Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Solutions</em>'.
	 * @see nrp.model.nrp.SoftwareArtifact#getSolutions()
	 * @see #getSoftwareArtifact()
	 * @generated
	 */
	EReference getSoftwareArtifact_Solutions();

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see nrp.model.nrp.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.Requirement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nrp.model.nrp.Requirement#getName()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link nrp.model.nrp.Requirement#getValuations <em>Valuations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Valuations</em>'.
	 * @see nrp.model.nrp.Requirement#getValuations()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Valuations();

	/**
	 * Returns the meta object for the containment reference list '{@link nrp.model.nrp.Requirement#getRealisations <em>Realisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realisations</em>'.
	 * @see nrp.model.nrp.Requirement#getRealisations()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Realisations();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.Requirement#getCombines <em>Combines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Combines</em>'.
	 * @see nrp.model.nrp.Requirement#getCombines()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Combines();

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.RequirementRealisation <em>Requirement Realisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement Realisation</em>'.
	 * @see nrp.model.nrp.RequirementRealisation
	 * @generated
	 */
	EClass getRequirementRealisation();

	/**
	 * Returns the meta object for the container reference '{@link nrp.model.nrp.RequirementRealisation#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requirement</em>'.
	 * @see nrp.model.nrp.RequirementRealisation#getRequirement()
	 * @see #getRequirementRealisation()
	 * @generated
	 */
	EReference getRequirementRealisation_Requirement();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.RequirementRealisation#getPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see nrp.model.nrp.RequirementRealisation#getPercentage()
	 * @see #getRequirementRealisation()
	 * @generated
	 */
	EAttribute getRequirementRealisation_Percentage();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.RequirementRealisation#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see nrp.model.nrp.RequirementRealisation#getDependsOn()
	 * @see #getRequirementRealisation()
	 * @generated
	 */
	EReference getRequirementRealisation_DependsOn();

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see nrp.model.nrp.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.Solution#getSelectedArtifacts <em>Selected Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Selected Artifacts</em>'.
	 * @see nrp.model.nrp.Solution#getSelectedArtifacts()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_SelectedArtifacts();

	/**
	 * Returns the meta object for class '{@link nrp.model.nrp.Valuation <em>Valuation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valuation</em>'.
	 * @see nrp.model.nrp.Valuation
	 * @generated
	 */
	EClass getValuation();

	/**
	 * Returns the meta object for the container reference '{@link nrp.model.nrp.Valuation#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requirement</em>'.
	 * @see nrp.model.nrp.Valuation#getRequirement()
	 * @see #getValuation()
	 * @generated
	 */
	EReference getValuation_Requirement();

	/**
	 * Returns the meta object for the attribute '{@link nrp.model.nrp.Valuation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see nrp.model.nrp.Valuation#getValue()
	 * @see #getValuation()
	 * @generated
	 */
	EAttribute getValuation_Value();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.Valuation#getAssignedBy <em>Assigned By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assigned By</em>'.
	 * @see nrp.model.nrp.Valuation#getAssignedBy()
	 * @see #getValuation()
	 * @generated
	 */
	EReference getValuation_AssignedBy();

	/**
	 * Returns the meta object for the reference list '{@link nrp.model.nrp.Valuation#getContributesTo <em>Contributes To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributes To</em>'.
	 * @see nrp.model.nrp.Valuation#getContributesTo()
	 * @see #getValuation()
	 * @generated
	 */
	EReference getValuation_ContributesTo();

	/**
	 * Returns the meta object for enum '{@link nrp.model.nrp.CostType <em>Cost Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cost Type</em>'.
	 * @see nrp.model.nrp.CostType
	 * @generated
	 */
	EEnum getCostType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NRPFactory getNRPFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.NRPImpl <em>NRP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.NRPImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getNRP()
		 * @generated
		 */
		EClass NRP = eINSTANCE.getNRP();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NRP__CUSTOMERS = eINSTANCE.getNRP_Customers();

		/**
		 * The meta object literal for the '<em><b>Available Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NRP__AVAILABLE_ARTIFACTS = eINSTANCE.getNRP_AvailableArtifacts();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NRP__REQUIREMENTS = eINSTANCE.getNRP_Requirements();

		/**
		 * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NRP__SOLUTIONS = eINSTANCE.getNRP_Solutions();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.CustomerImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__NAME = eINSTANCE.getCustomer_Name();

		/**
		 * The meta object literal for the '<em><b>Importance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__IMPORTANCE = eINSTANCE.getCustomer_Importance();

		/**
		 * The meta object literal for the '<em><b>Assigns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__ASSIGNS = eINSTANCE.getCustomer_Assigns();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.CostImpl <em>Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.CostImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getCost()
		 * @generated
		 */
		EClass COST = eINSTANCE.getCost();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COST__TYPE = eINSTANCE.getCost_Type();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COST__AMOUNT = eINSTANCE.getCost_Amount();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.SoftwareArtifactImpl <em>Software Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.SoftwareArtifactImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getSoftwareArtifact()
		 * @generated
		 */
		EClass SOFTWARE_ARTIFACT = eINSTANCE.getSoftwareArtifact();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE_ARTIFACT__NAME = eINSTANCE.getSoftwareArtifact_Name();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_ARTIFACT__REQUIRES = eINSTANCE.getSoftwareArtifact_Requires();

		/**
		 * The meta object literal for the '<em><b>Costs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_ARTIFACT__COSTS = eINSTANCE.getSoftwareArtifact_Costs();

		/**
		 * The meta object literal for the '<em><b>Contributes To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_ARTIFACT__CONTRIBUTES_TO = eINSTANCE.getSoftwareArtifact_ContributesTo();

		/**
		 * The meta object literal for the '<em><b>Solutions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_ARTIFACT__SOLUTIONS = eINSTANCE.getSoftwareArtifact_Solutions();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.RequirementImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__NAME = eINSTANCE.getRequirement_Name();

		/**
		 * The meta object literal for the '<em><b>Valuations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__VALUATIONS = eINSTANCE.getRequirement_Valuations();

		/**
		 * The meta object literal for the '<em><b>Realisations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REALISATIONS = eINSTANCE.getRequirement_Realisations();

		/**
		 * The meta object literal for the '<em><b>Combines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__COMBINES = eINSTANCE.getRequirement_Combines();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.RequirementRealisationImpl <em>Requirement Realisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.RequirementRealisationImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getRequirementRealisation()
		 * @generated
		 */
		EClass REQUIREMENT_REALISATION = eINSTANCE.getRequirementRealisation();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT_REALISATION__REQUIREMENT = eINSTANCE.getRequirementRealisation_Requirement();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT_REALISATION__PERCENTAGE = eINSTANCE.getRequirementRealisation_Percentage();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT_REALISATION__DEPENDS_ON = eINSTANCE.getRequirementRealisation_DependsOn();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.SolutionImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getSolution()
		 * @generated
		 */
		EClass SOLUTION = eINSTANCE.getSolution();

		/**
		 * The meta object literal for the '<em><b>Selected Artifacts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__SELECTED_ARTIFACTS = eINSTANCE.getSolution_SelectedArtifacts();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.impl.ValuationImpl <em>Valuation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.impl.ValuationImpl
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getValuation()
		 * @generated
		 */
		EClass VALUATION = eINSTANCE.getValuation();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUATION__REQUIREMENT = eINSTANCE.getValuation_Requirement();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUATION__VALUE = eINSTANCE.getValuation_Value();

		/**
		 * The meta object literal for the '<em><b>Assigned By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUATION__ASSIGNED_BY = eINSTANCE.getValuation_AssignedBy();

		/**
		 * The meta object literal for the '<em><b>Contributes To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUATION__CONTRIBUTES_TO = eINSTANCE.getValuation_ContributesTo();

		/**
		 * The meta object literal for the '{@link nrp.model.nrp.CostType <em>Cost Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nrp.model.nrp.CostType
		 * @see nrp.model.nrp.impl.NRPPackageImpl#getCostType()
		 * @generated
		 */
		EEnum COST_TYPE = eINSTANCE.getCostType();

	}

} //NRPPackage
