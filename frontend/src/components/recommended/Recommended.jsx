import './Recommended.css'

const Recommended = () => {
  return (
    <div className="container-recommended">
      <h1>Danza</h1>
      <div className="main-banner">
        <img src="./test.jpg" alt="Danza clásica en Teatro Num" />
        <div className="banner-text">
          <h2>Danza clásica</h2>
          <p>Teatro Num</p>
        </div>
      </div>
      <div className="event-list">
        <div className="event-card">
          <img src="./test.jpg" alt="Danza clásica en Teatro Num" />
          <div className="event-text">
            <h3>Danza clásica</h3>
            <p>Teatro Num</p>
            <button className="info-button">+ info</button>
          </div>
        </div>
        <div className="event-card">
          <img src="./test.jpg" alt="Danza clásica en Teatro San Martín" />
          <div className="event-text">
            <h3>Danza clásica</h3>
            <p>Teatro San Martín</p>
            <button className="info-button">+ info</button>
          </div>
        </div>
        <div className="event-card">
          <img src="./test.jpg" alt="Danza contemporánea en Espacio Zero" />
          <div className="event-text">
            <h3>Danza contemporánea</h3>
            <p>Espacio Zero</p>
            <button className="info-button">+ info</button>
          </div>
        </div>
      </div>
      {/* se pueden importar con un componente card o la lista json */}
    </div>
  )
}

export default Recommended
