import React, { useState } from "react";
import ProfileForm from "../../components/profileForm/ProfileForm";
import "./UserProfile.css";
import { Link } from "react-router-dom";

const initialProfileData = {
  name: "Agustina Díaz",
  age: 25,
  location: "Buenos Aires, Argentina",
  interests: ["Arte", "Fotografía", "Diseño", "Danza"],
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
            <div className="avatar">AD</div>
            <div className="profile-info">
              <h2>{profileData.name}</h2>
              <p>25 años</p>
              <p>{profileData.location}</p>
              <div className="interests">
                {profileData.interests.map((interest) => (
                  <span key={interest}>{interest}</span>
                ))}
              </div>
            </div>
            <span className="edit-icon" onClick={() => setIsEditing(true)}>✏️</span>
          </div>
        </div>
      )}
      <div className="events-section">
        <div className="events-tabs">
          <button className="active-tab">Próximos eventos</button>
          <button>Historial de eventos</button>
        </div>
        <div className="event">
          <img src="/danzaClasica.jpeg" alt="Event" />
          <div>
            <h3>Danza clásica</h3>
            <p>15 de Junio, 20:30 hs</p>
            <p>Teatro NUM, Juan Ramirez de Velasco 419, CABA</p>
          </div>
          <div className="qr-code">QR</div>
        </div>
        <div className="event">
          <img src="/danzaClasica.jpeg" alt="Event" />
          <div>
            <h3>Danza clásica</h3>
            <p>15 de Junio, 20:30 hs</p>
            <p>Teatro NUM, Juan Ramirez de Velasco 419, CABA</p>
          </div>
          <div className="qr-code">QR</div>
        </div>
      </div>
    </div>
  );
};

export default UserProfile;
