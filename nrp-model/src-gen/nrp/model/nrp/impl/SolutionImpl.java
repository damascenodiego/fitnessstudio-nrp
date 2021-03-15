/**
 */
package nrp.model.nrp.impl;

import java.util.Collection;

import nrp.model.nrp.NRPPackage;
import nrp.model.nrp.SoftwareArtifact;
import nrp.model.nrp.Solution;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.impl.SolutionImpl#getSelectedArtifacts <em>Selected Artifacts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends MinimalEObjectImpl.Container implements Solution {
	/**
	 * The cached value of the '{@link #getSelectedArtifacts() <em>Selected Artifacts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<SoftwareArtifact> selectedArtifacts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NRPPackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SoftwareArtifact> getSelectedArtifacts() {
		if (selectedArtifacts == null) {
			selectedArtifacts = new EObjectWithInverseResolvingEList.ManyInverse<SoftwareArtifact>(
					SoftwareArtifact.class, this, NRPPackage.SOLUTION__SELECTED_ARTIFACTS,
					NRPPackage.SOFTWARE_ARTIFACT__SOLUTIONS);
		}
		return selectedArtifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case NRPPackage.SOLUTION__SELECTED_ARTIFACTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSelectedArtifacts()).basicAdd(otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case NRPPackage.SOLUTION__SELECTED_ARTIFACTS:
			return ((InternalEList<?>) getSelectedArtifacts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case NRPPackage.SOLUTION__SELECTED_ARTIFACTS:
			return getSelectedArtifacts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case NRPPackage.SOLUTION__SELECTED_ARTIFACTS:
			getSelectedArtifacts().clear();
			getSelectedArtifacts().addAll((Collection<? extends SoftwareArtifact>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case NRPPackage.SOLUTION__SELECTED_ARTIFACTS:
			getSelectedArtifacts().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case NRPPackage.SOLUTION__SELECTED_ARTIFACTS:
			return selectedArtifacts != null && !selectedArtifacts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SolutionImpl
