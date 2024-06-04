import { Link } from 'react-router-dom'
import './Footer.css'

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-section">
          <img src='./logoWhiteOrange.png' alt="Multimeet Logo" className="footer-logo" />
        </div>
        <div className="footer-section">
          <h4>MULTIMEET</h4>
          <ul>
            <li>Inicio</li>
            <Link to='/about-us'>Quienes Somos</Link>
            <li>Calendario</li>
            <li>Contacto</li>
          </ul>
        </div>
        <div className="footer-section">
          <h4>Clientes y soporte</h4>
          <ul>
            <li>Teléfono</li>
            <li>Mail</li>
            <li>Soporte técnico</li>
            <li>Hablar con un asesor</li>
          </ul>
        </div>
        <div className="footer-section">
          <h4>Contacto</h4>
          <ul>
            <li>Teléfono</li>
            <li>Mail</li>
          </ul>
        </div>
      </div>
      <div className="footer-bottom">
        <p>Multimeet @ 2024 todos los derechos reservados</p>
        <p>
          Política General de seguridad de la información
          <br />
          Políticas de privacidad | Cookies
        </p>
      </div>
    </footer>
  )
}

export default Footer
