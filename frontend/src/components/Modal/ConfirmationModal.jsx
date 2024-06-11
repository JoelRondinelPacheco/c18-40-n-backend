import PropTypes from 'prop-types'
import './Modal.css'

const ConfirmationModal = ({ show, onClose, onConfirm }) => {

    if(!show){
        return null;
    }

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2>Confirmación</h2>
          <button onClick={onClose} className="close-button">&times;</button>
        </div>
        <div className="modal-body">
          <p>¿Estás seguro de que deseas asistir a este evento?</p>
          <button className="confirm-button" onClick={() => onConfirm(true)}>Sí</button>
          <button className="cancel-button" onClick={() => onConfirm(false)}>No</button>
        </div>
      </div>
    </div>
  )
}

ConfirmationModal.propTypes = {
    show: PropTypes.bool.isRequired,
    onClose: PropTypes.func.isRequired,
    onConfirm: PropTypes.func.isRequired,
  };

export default ConfirmationModal
