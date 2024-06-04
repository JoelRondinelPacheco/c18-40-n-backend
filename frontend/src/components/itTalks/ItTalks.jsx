import { useState } from 'react'
import './ItTalks.css'
import Modal from '../Modal/Modal'
import events from './events.json'
import ConfirmationModal from '../Modal/ConfirmationModal'
import { toast } from 'react-toastify'

const ItTalks = () => {

  const [showModal, setShowModal] = useState(false);
  const [selectedEvent, setSelectedEvent] = useState(null);
  const [showConfirmationModal, setShowConfirmationModal] = useState(false);

  const handleShowModal = (event) => {
    setSelectedEvent(event);
    setShowModal(true);
  }

  const handleAttend = () => {
    setShowConfirmationModal(true);
  }

  const handleConfirm = (confirm) => {
    if(confirm){
      toast.success(`Asistiendo al evento ${selectedEvent.title}`,{
        autoClose: 1000,
      });
    }
    setShowConfirmationModal(false);
    setShowModal(false);
  }


  return (
    <div className="container-it-talks">
      <h1>Eventos disponibles</h1>
      {/* <div className="main-banner">
        <img src="./test.jpg" alt="Danza clásica en Teatro Num" />
        <div className="banner-text">
          <h2>Danza clásica</h2>
          <p>Teatro Num</p>
        </div>
      </div> */}
      <div className="event-list">
        {events.map((event, index) => (
          <div className="event-card" key={index}>
            <img src={event.image} alt={event.title} />
            <div className="event-text">
              <h3>{event.title}</h3>
              <p>{event.location}</p>
              <p>{event.date}</p>
              <p>{event.time}</p>
              <button className="info-button" onClick={() => handleShowModal(event)}>Vista previa</button>
            </div>
          </div>
        ))}
      </div>
      <Modal show={showModal} onClose={() => setShowModal(false)} event={selectedEvent} onAttend={handleAttend} />
      <ConfirmationModal show={showConfirmationModal} onClose={()=>setShowConfirmationModal(false)} onConfirm={handleConfirm} />
    </div>
  )
}

export default ItTalks
