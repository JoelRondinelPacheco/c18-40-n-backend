import { useState } from 'react';
import './EventComponent.css';

const EventComponent = () => {
  const [eventData, setEventData] = useState({
    title: '',
    date: '',
    location: '',
    address: '',
    city: '',
    category: '',
    startTime: '',
    endTime: '',
    price: '',
    description: '',
    image: null,
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEventData({ ...eventData, [name]: value });
  };

  const handleImageChange = (e) => {
    setEventData({ ...eventData, image: e.target.files[0] });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Aquí puedes agregar la lógica para enviar los datos del evento al servidor
    console.log(eventData);
  };

  return (
    <div className="create-event-container">
      <h1>Crear evento</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Nombre del evento</label>
          <input type="text" name="title" value={eventData.title} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Fecha</label>
          <input type="date" name="date" value={eventData.date} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Lugar</label>
          <input type="text" name="location" value={eventData.location} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Dirección</label>
          <input type="text" name="address" value={eventData.address} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Ciudad</label>
          <input type="text" name="city" value={eventData.city} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Categoría</label>
          <select name="category" value={eventData.category} onChange={handleChange} required>
            <option value="">Selecciona una categoría</option>
            {/* Agrega más opciones de categoría según sea necesario */}
          </select>
        </div>

        <div className="form-group">
          <label>Horario</label>
          <div className="time-group">
            <input type="time" name="startTime" value={eventData.startTime} onChange={handleChange} required />
            <input type="time" name="endTime" value={eventData.endTime} onChange={handleChange} required />
          </div>
        </div>

        <div className="form-group">
          <label>Precio</label>
          <input type="number" name="price" value={eventData.price} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Descripción</label>
          <textarea name="description" value={eventData.description} onChange={handleChange} required />
        </div>

        <div className="form-group">
          <label>Imagen</label>
          <input type="file" onChange={handleImageChange} required />
          {eventData.image && <img src={URL.createObjectURL(eventData.image)} alt="Preview" className="image-preview" />}
        </div>

        <button type="submit" className="submit-button">Crear evento</button>
      </form>
    </div>
  );
};

export default EventComponent;
