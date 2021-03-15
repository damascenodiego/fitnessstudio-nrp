/**
 */
package nrp.model.nrp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NRP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.NRP#getCustomers <em>Customers</em>}</li>
 *   <li>{@link nrp.model.nrp.NRP#getAvailableArtifacts <em>Available Artifacts</em>}</li>
 *   <li>{@link nrp.model.nrp.NRP#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link nrp.model.nrp.NRP#getSolutions <em>Solutions</em>}</li>
 * </ul>
 *
 * @see nrp.model.nrp.NRPPackage#getNRP()
 * @model
 * @generated
 */
public interface NRP extends EObject {
	/**
	 * Returns the value of the '<em><b>Customers</b></em>' containment reference list.
	 * The list contents are of type {@link nrp.model.nrp.Customer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customers</em>' containment reference list.
	 * @see nrp.model.nrp.NRPPackage#getNRP_Customers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Customer> getCustomers();

	/**
	 * Returns the value of the '<em><b>Available Artifacts</b></em>' containment reference list.
	 * The list contents are of type {@link nrp.model.nrp.SoftwareArtifact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Artifacts</em>' containment reference list.
	 * @see nrp.model.nrp.NRPPackage#getNRP_AvailableArtifacts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<SoftwareArtifact> getAvailableArtifacts();

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link nrp.model.nrp.Requirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see nrp.model.nrp.NRPPackage#getNRP_Requirements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Requirement> getRequirements();

	/**
	 * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
	 * The list contents are of type {@link nrp.model.nrp.Solution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutions</em>' containment reference list.
	 * @see nrp.model.nrp.NRPPackage#getNRP_Solutions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Solution> getSolutions();

} // NRP
