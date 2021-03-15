/**
 */
package nrp.model.nrp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nrp.model.nrp.Solution#getSelectedArtifacts <em>Selected Artifacts</em>}</li>
 * </ul>
 *
 * @see nrp.model.nrp.NRPPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends EObject {
	/**
	 * Returns the value of the '<em><b>Selected Artifacts</b></em>' reference list.
	 * The list contents are of type {@link nrp.model.nrp.SoftwareArtifact}.
	 * It is bidirectional and its opposite is '{@link nrp.model.nrp.SoftwareArtifact#getSolutions <em>Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Artifacts</em>' reference list.
	 * @see nrp.model.nrp.NRPPackage#getSolution_SelectedArtifacts()
	 * @see nrp.model.nrp.SoftwareArtifact#getSolutions
	 * @model opposite="solutions"
	 * @generated
	 */
	EList<SoftwareArtifact> getSelectedArtifacts();

} // Solution
