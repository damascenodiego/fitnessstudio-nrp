/**
 */
package nrp.model.nrp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.Cost#getType <em>Type</em>}</li>
 *   <li>{@link nrp.model.nrp.Cost#getAmount <em>Amount</em>}</li>
 * </ul>
 *
 * @see nrp.model.nrp.NRPPackage#getCost()
 * @model
 * @generated
 */
public interface Cost extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link nrp.model.nrp.CostType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see nrp.model.nrp.CostType
	 * @see #setType(CostType)
	 * @see nrp.model.nrp.NRPPackage#getCost_Type()
	 * @model
	 * @generated
	 */
	CostType getType();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.Cost#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see nrp.model.nrp.CostType
	 * @see #getType()
	 * @generated
	 */
	void setType(CostType value);

	/**
	 * Returns the value of the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount</em>' attribute.
	 * @see #setAmount(double)
	 * @see nrp.model.nrp.NRPPackage#getCost_Amount()
	 * @model
	 * @generated
	 */
	double getAmount();

	/**
	 * Sets the value of the '{@link nrp.model.nrp.Cost#getAmount <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount</em>' attribute.
	 * @see #getAmount()
	 * @generated
	 */
	void setAmount(double value);

} // Cost
