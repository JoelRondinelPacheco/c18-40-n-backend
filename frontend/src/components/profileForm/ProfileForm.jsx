import React, { useState } from "react";
import './ProfileForm.css';

const ProfileForm = ({ initialData, onSave }) => {
  const [formData, setFormData] = useState(initialData);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleInterestsChange = (e) => {
    const { value } = e.target;
    setFormData({ ...formData, interests: value.split(',') });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSave(formData);
  };

  return (
    <form className="profile-form" onSubmit={handleSubmit}>
      <div className="profile-header">
        <div className="avatar">Jh</div>
        <div className="profile-info">
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleInputChange}
            className="profile-name"
            placeholder="Nombre"
          />
          <input
            type="number"
            name="age"
            value={formData.age}
            onChange={handleInputChange}
            className="profile-age"
            placeholder="Edad"
          />
          <input
            type="text"
            name="location"
            value={formData.location}
            onChange={handleInputChange}
            className="profile-location"
            placeholder="Ubicación"
          />
          <input
            type="text"
            name="interests"
            value={formData.interests.join(', ')}
            onChange={handleInterestsChange}
            className="profile-interests"
            placeholder="Intereses (separados por coma)"
          />
        </div>
      </div>
      <button type="submit" className="save-button">Guardar</button>
    </form>
  );
};

export default ProfileForm;

