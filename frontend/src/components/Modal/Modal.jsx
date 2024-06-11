import { useNavigate } from 'react-router-dom';
import './Modal.css';
import PropTypes from 'prop-types';
import { toast } from 'react-toastify';

const Modal = ({ show, onClose, event, onAttend }) => {
  const navigate = useNavigate();

  const handleViewMore = () => {
    navigate(`/event/${event.id}`);
  };

  const handleAttend = () => {
    const user = JSON.parse(localStorage.getItem('user'));
    if (!user) {
      toast.error('Debes iniciar sesión para asistir al evento', { autoClose: 1000 });
      navigate('/login');
      return;
    } else {
      onAttend();
    }
  };

  if(!show || !event){
    return null;
  }

  const truncateDescription = (description, maxLength) => {
    if (description.length > maxLength) {
      return description.substring(0, maxLength) + '...';
    }
    return description;
  };
  
  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2>{event.title}</h2>
          <button onClick={onClose} className="close-button">&times;</button>
        </div>
        <div className="modal-body">
          <img src={event.image} alt={event.title} className="modal-image" />
          <div className="modal-details">
            <p>{truncateDescription(event.description, 300)}</p>
            <h4>{event.location}</h4>
            <p><strong>{event.date}</strong></p>
            <p><strong>{event.time}</strong></p>
            <p><strong>{event.organizer}</strong></p>
            <button className="attend-button" onClick={handleViewMore}>Ver más</button>
            <button className="attend-button" onClick={handleAttend}>Asistir</button>
          </div>
        </div>
      </div>
    </div>
  )
}

Modal.propTypes = {
  show: PropTypes.bool.isRequired,
  onClose: PropTypes.func.isRequired,
  event: PropTypes.shape({
    id: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    location: PropTypes.string.isRequired,
    date: PropTypes.string.isRequired,
    time: PropTypes.string.isRequired,
    organizer: PropTypes.string.isRequired,
  }),
  onAttend: PropTypes.func.isRequired,
};

export default Modal
