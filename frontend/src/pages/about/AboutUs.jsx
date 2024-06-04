import React from "react";
import "./AboutUs.css";

const AboutUs = () => {
  const teamMember = [
    {
      id: 1,
      name: "Maria Martinez",
      role: "UX/UI",
      image: "/public/ejemplo2.png",
    },
    {
      id: 2,
      name: "Ana Fernandez",
      role: "QA Tester - Scrum master",
      image: "/public/ejemplo3.png",
    },
    {
      id: 3,
      name: "Robin Perez",
      role: "FrontEnd",
      image: "/public/ejemplo1.png",
    },
  ];

  return (
      
      <section className="main-content">
        <h1 className="about-us">Sobre MultiMeet</h1>
        <div className="info">
        <h2>¿Qué es MultiMeet?</h2>
        <p className="info-description">
          MultiMeet es una plataforma que te permite encontrar eventos que se
          adapten a tus gustos y preferencias. Te brindará todas las
          herramientas necesarias del lugar al que vas a asistir.
        </p>
  </div>
        <div className="image">
        <img
          src="/bannerAboutUs.jpg"
          alt="Escenario con luces"
        />
</div>
        <div className="missionVision">
        <h3>Misión</h3>
        <p>
          Nuestra misión es facilitar el acceso a eventos culturales y conectar
          a las personas a través de experiencias compartidas.
        </p>

        <h3>Visión</h3>
        <p>
          Aspiramos a ser la plataforma líder para el descubrimiento y
          organización de eventos, transformando la forma en que las personas se
          conectan con sus pasiones e intereses.
        </p>
</div>
        <div className="history">
        <h3>Nuestra Historia</h3>
        <p>
          MultiMeet nace en 2024 con la idea de facilitar el acceso a eventos
          para todos y conectar personas. La inspiración vino cuando nos dimos
          cuenta de la falta de una plataforma integral para descubrir,
          organizar y participar en eventos culturales locales. Nos motivó el
          deseo de crear un espacio donde la cultura y la comunidad se unen.
        </p>
</div>
        <div className="team">
        <h3>Nuestro Equipo</h3>
        <p>
          Un grupo apasionado por la tecnología y los eventos, comprometido con
          crear una experiencia única para nuestros usuarios.
        </p>
        <div className="team-container">
          {teamMember.map((member) => (
            <div key={member.id} className="team-member">
              <img src={member.image} alt={member.name} />
              <div className="member-info">
                <h4>{member.name}</h4>
                <p>{member.role}</p>
              </div>
            </div>
          ))}
        </div>
        </div>
        </section>
    
  );
};

export default AboutUs;
