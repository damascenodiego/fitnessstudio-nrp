/**
 */
package nrp.model.nrp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.Requirement#getName <em>Name</em>}</li>
 *   <li>{@link nrp.model.nrp.Requirement#getValuations <em>Valuations</em>}</li>
 *   <li>{@link nrp.model.nrp.Requirement#getRealisations <em>Realisations</em>}</li>
 *   <li>{@link nrp.model.nrp.Requirement#getCombines <em>Combines</em>}</li>
 * </ul>
 *
 * @see nrp.model.nrp.NRPPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nrp.model.nrp.NRPPackage#getRequirement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.Requirement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Valuations</b></em>' containment reference list.
	 * The list contents are of type {@link nrp.model.nrp.Valuation}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.Valuation#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valuations</em>' containment reference list.
	 * @see nrp.model.nrp.NRPPackage#getRequirement_Valuations()
	 * @see nrp.model.nrp.Valuation#getRequirement
	 * @model opposite="requirement" containment="true" required="true"
	 * @generated
	 */
	EList<Valuation> getValuations();

	/**
	 * Returns the value of the '<em><b>Realisations</b></em>' containment reference list.
	 * The list contents are of type {@link nrp.model.nrp.RequirementRealisation}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.RequirementRealisation#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realisations</em>' containment reference list.
	 * @see nrp.model.nrp.NRPPackage#getRequirement_Realisations()
	 * @see nrp.model.nrp.RequirementRealisation#getRequirement
	 * @model opposite="requirement" containment="true"
	 * @generated
	 */
	EList<RequirementRealisation> getRealisations();

	/**
	 * Returns the value of the '<em><b>Combines</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.Valuation}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.Valuation#getContributesTo <em>Contributes To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combines</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getRequirement_Combines()
	 * @see nrp.model.nrp.Valuation#getContributesTo
	 * @model opposite="contributesTo"
	 * @generated
	 */
	EList<Valuation> getCombines();

} // Requirement
