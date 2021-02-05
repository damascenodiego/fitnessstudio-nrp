/**
 */
package nrp.model.nrp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Realisation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.RequirementRealisation#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link nrp.model.nrp.RequirementRealisation#getPercentage <em>Percentage</em>}</li>
 *   <li>{@link nrp.model.nrp.RequirementRealisation#getDependsOn <em>Depends On</em>}</li>
 * </ul>
 *
 * @see nrp.model.nrp.NRPPackage#getRequirementRealisation()
 * @model
 * @generated
 */
public interface RequirementRealisation extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.Requirement#getRealisations <em>Realisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' container reference.
	 * @see #setRequirement(Requirement)
	 * @see nrp.model.nrp.NRPPackage#getRequirementRealisation_Requirement()
	 * @see nrp.model.nrp.Requirement#getRealisations
	 * @model opposite="realisations" required="true" transient="false"
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.RequirementRealisation#getRequirement <em>Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' container reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage</em>' attribute.
	 * @see #setPercentage(double)
	 * @see nrp.model.nrp.NRPPackage#getRequirementRealisation_Percentage()
	 * @model default="1.0"
	 * @generated
	 */
	double getPercentage();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.RequirementRealisation#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage</em>' attribute.
	 * @see #getPercentage()
	 * @generated
	 */
	void setPercentage(double value);

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.SoftwareArtifact}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.SoftwareArtifact#getContributesTo <em>Contributes To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getRequirementRealisation_DependsOn()
	 * @see nrp.model.nrp.SoftwareArtifact#getContributesTo
	 * @model opposite="contributesTo" required="true"
	 * @generated
	 */
	EList<SoftwareArtifact> getDependsOn();

} // RequirementRealisation
