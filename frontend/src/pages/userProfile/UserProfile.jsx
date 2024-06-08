import React, { useState } from "react";
import ProfileForm from "../../components/profileForm/ProfileForm";
import "./UserProfile.css";
import { Link } from "react-router-dom";

const initialProfileData = {
  name: "Jhon",
  age: 25,
  location: "Buenos Aires, Argentina",
  interests: ["Arte", "Teatro", "Danza", "Tecnología"],
};

const UserProfile = () => {
  const [isEditing, setIsEditing] = useState(false);
  const [profileData, setProfileData] = useState(initialProfileData);

  const handleSave = (data) => {
    setProfileData(data);
    setIsEditing(false);
  };

  return (
    <div className="user-profile">
      {isEditing ? (
        <ProfileForm initialData={profileData} onSave={handleSave} />
      ) : (
        <div className="profile-view">
          <div className="profile-header">
            <div className="avatar">Jh</div>
            <div className="profile-info">
              <h2>{profileData.name}</h2>
              <p>Edad: {profileData.age}</p>
              <p>Ubicación: {profileData.location}</p>
              <p>Intereses: {profileData.interests.join(", ")}</p>
            </div>
          </div>
          <button className="edit-button" onClick={() => setIsEditing(true)}>
            Editar Perfil
          </button>
          <Link to="/">Regresar al Home</Link>
        </div>
      )}
      <div className="events-section">
        <h2>Próximos eventos</h2>
        <div className="event">
          <img src="/danzaClasica.jpeg" alt="Event" />
          <div>
            <h3>Danza clásica</h3>
            <p>15 de junio, 20:30 hs</p>
            <p>Teatro NUM</p>
          </div>
          <div className="qr-code">QR</div>
        </div>
      </div>
    </div>
  );
};

export default UserProfile;
