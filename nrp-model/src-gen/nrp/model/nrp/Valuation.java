/**
 */
package nrp.model.nrp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Valuation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.Valuation#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link nrp.model.nrp.Valuation#getValue <em>Value</em>}</li>
 *   <li>{@link nrp.model.nrp.Valuation#getAssignedBy <em>Assigned By</em>}</li>
 *   <li>{@link nrp.model.nrp.Valuation#getContributesTo <em>Contributes To</em>}</li>
 * </ul>
 *
 * @see nrp.model.nrp.NRPPackage#getValuation()
 * @model
 * @generated
 */
public interface Valuation extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.Requirement#getValuations <em>Valuations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' container reference.
	 * @see #setRequirement(Requirement)
	 * @see nrp.model.nrp.NRPPackage#getValuation_Requirement()
	 * @see nrp.model.nrp.Requirement#getValuations
	 * @model opposite="valuations" required="true" transient="false"
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.Valuation#getRequirement <em>Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' container reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see nrp.model.nrp.NRPPackage#getValuation_Value()
	 * @model
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.Valuation#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * Returns the value of the '<em><b>Assigned By</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.Customer}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.Customer#getAssigns <em>Assigns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned By</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getValuation_AssignedBy()
	 * @see nrp.model.nrp.Customer#getAssigns
	 * @model opposite="assigns" required="true"
	 * @generated
	 */
	EList<Customer> getAssignedBy();

	/**
	 * Returns the value of the '<em><b>Contributes To</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.Requirement}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.Requirement#getCombines <em>Combines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributes To</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getValuation_ContributesTo()
	 * @see nrp.model.nrp.Requirement#getCombines
	 * @model opposite="combines"
	 * @generated
	 */
	EList<Requirement> getContributesTo();

} // Valuation
