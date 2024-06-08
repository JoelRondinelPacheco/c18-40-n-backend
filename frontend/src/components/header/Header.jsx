import { useEffect } from 'react';
import './Header.css'
import { Link, useNavigate } from 'react-router-dom'
import { useState } from 'react';

const Header = () => {

  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [userName, setUserName] = useState('');
  const [userRole, setUserRole] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    // Simulación de la lógica de autenticación y rol
    const token = localStorage.getItem('authToken');
    const user = JSON.parse(localStorage.getItem('user'));

    if (token && user) {
      setIsAuthenticated(true);
      setUserName(user.name);
      setUserRole(user.role);
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem('authToken');
    localStorage.removeItem('user');
    setIsAuthenticated(false);
    setUserName('');
    setUserRole('');
    navigate('/');
  };
  return (
    <div className='container-header'>
      <div className="logo">
        <Link to='/'>
          <img src="./logoWhiteOrange.png" title="Logotipo Multimeet" />
        </Link>
      </div>
      <div className='nav-header'>
        {/* <ul>
          <li>Inicio</li>
          <li>Quiénes Somos</li>
          <li>Calendario</li>
          <li>Contacto</li>
        </ul> */}
        <input 
            type="text" 
            className="search-input" 
            placeholder="Buscar evento, organizador, fecha" 
        />
      </div>
      <div className="home-links">
      {isAuthenticated ? (
          <>
            <div className="user-info">
              <span>Hola, {userName}</span>
              <button onClick={handleLogout} className="logout-button">Cerrar Sesión</button>
            </div>
            {userRole === 'organizer' && (
              <Link to='/create-event'>
                <div className="create-event">Crear Evento</div>
                <div>
                  <Link to ="/user-profile">Mi perfil</Link>
                </div>
              </Link>
              
            )}
          </>
        ) : (
          <>
            <Link to='/login'>
              <div className="login">Iniciar Sesión</div>
            </Link>
            <Link to='/register'>
              <div className="register">Registrarse</div>
            </Link>
          </>
        )}
      </div>
    </div>
  )
}

export default Header
