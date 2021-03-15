/**
 */
package nrp.model.nrp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.SoftwareArtifact#getName <em>Name</em>}</li>
 *   <li>{@link nrp.model.nrp.SoftwareArtifact#getRequires <em>Requires</em>}</li>
 *   <li>{@link nrp.model.nrp.SoftwareArtifact#getCosts <em>Costs</em>}</li>
 *   <li>{@link nrp.model.nrp.SoftwareArtifact#getContributesTo <em>Contributes To</em>}</li>
 *   <li>{@link nrp.model.nrp.SoftwareArtifact#getSolutions <em>Solutions</em>}</li>
 * </ul>
 *
 * @see nrp.model.nrp.NRPPackage#getSoftwareArtifact()
 * @model
 * @generated
 */
public interface SoftwareArtifact extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nrp.model.nrp.NRPPackage#getSoftwareArtifact_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.SoftwareArtifact#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.SoftwareArtifact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getSoftwareArtifact_Requires()
	 * @model
	 * @generated
	 */
	EList<SoftwareArtifact> getRequires();

	/**
	 * Returns the value of the '<em><b>Costs</b></em>' containment reference list.
	 * The list contents are of type {@link nrp.model.nrp.Cost}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Costs</em>' containment reference list.
	 * @see nrp.model.nrp.NRPPackage#getSoftwareArtifact_Costs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Cost> getCosts();

	/**
	 * Returns the value of the '<em><b>Contributes To</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.RequirementRealisation}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.RequirementRealisation#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributes To</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getSoftwareArtifact_ContributesTo()
	 * @see nrp.model.nrp.RequirementRealisation#getDependsOn
	 * @model opposite="dependsOn" required="true"
	 * @generated
	 */
	EList<RequirementRealisation> getContributesTo();

	/**
	 * Returns the value of the '<em><b>Solutions</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.Solution}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.Solution#getSelectedArtifacts <em>Selected Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutions</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getSoftwareArtifact_Solutions()
	 * @see nrp.model.nrp.Solution#getSelectedArtifacts
	 * @model opposite="selectedArtifacts"
	 * @generated
	 */
	EList<Solution> getSolutions();

} // SoftwareArtifact
