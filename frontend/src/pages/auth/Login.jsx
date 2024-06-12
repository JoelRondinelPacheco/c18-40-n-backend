import { useState } from "react";
import "./Auth.css";
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import logo from '/logoBlackOrange.png';

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    switch (name) {
      case "usuario":
        setUsername(value);
        break;
      case "contraseña":
        setPassword(value);
        break;
      default:
        break;
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Logica de validacion
    let validationError = {};

    if (!username) {
      validationError.username = "Por favor ingrese un Usuario.";
    } else if (username.length < 3) {
      validationError.username = "El usuario debe tener al menos 3 caracteres.";
    }

    if (!password) {
      validationError.password = "Por favor ingrese una Contraseña Valida.";
    } else if (password.length < 8) {
      validationError.password = "La contraseña debe tener al menos 8 caracteres.";
    }

    setErrors(validationError); // Actualiza el estado de los errores
    // Si no hay errores de validación, maneja el envío del formulario (por ejemplo, llamada a la API)
    if (Object.keys(validationError).length === 0) {
      let data =  login(username, password)
      console.log(data)
      // Simulación de la lógica de login
      const token = 'your-auth-token';
      const user = { name: 'John', role: 'organizer' }; // o 'user'

      localStorage.setItem('authToken', token);
      localStorage.setItem('user', JSON.stringify(user));

      toast.success('Inicio de sesión exitoso', { autoClose: 1000 });
      navigate('/');
      
      // Limpia los campos de usuario y contraseña después del inicio de sesión
      setUsername("");
      setPassword("");
    }
  };

  const toggleShowPassword = () => {
    setShowPassword((prevState) => !prevState); // Invierte el estado actual
  };

  async function login(username, password) {
    const url = 'http://localhost:8080/api/v1/auth/login';
    const payload = {
      email: username,
      password: password
    };
  
    try {
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(payload)
      });

  
      const data = await response.json();
      console.log(data)
      return data;
    } catch (error) {
      console.error('Error during login:', error);
      throw error;
    }
  }
  

  return (
    <div className="parentContainer">
      <section className="userAuth">
        <img src={logo} title="Logo de Multi Meet" />
        <h1>Iniciar Sesión</h1>
        <form className="form" onSubmit={handleSubmit}>
          <label className="label" htmlFor="usuario">
            Usuario
          </label>
          {errors.username && <p className="error-message">{errors.username}</p>}
          <input
            className="input"
            type="text"
            id="usuario"
            name="usuario"
            value={username}
            onChange={handleChange}
          />

          <label className="label" htmlFor="contraseña">
            Contraseña
          </label>
          {errors.password && <p className="error-message">{errors.password}</p>}
          <div className="password-container">
            <input
              className="input password-input"
              type={showPassword ? "text" : "password"}
              id="contraseña"
              name="contraseña"
              value={password}
              onChange={handleChange}
            />
            <FontAwesomeIcon
              className="password-icon"
              icon={showPassword ? faEyeSlash : faEye}
              onClick={toggleShowPassword}
            />
          </div>

          <button className="button" type="submit">
            Ingresar
          </button>
        </form>
        <Link to="/">Regresar al Home</Link>
      </section>
    </div>
  );
};

export default Login;
