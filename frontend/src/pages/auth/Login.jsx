import React, { useState } from "react";
import "./Auth.css";
import logo from "/Users/user/Desktop/c18-40-n-java-react/frontend/src/assets/logoMultiMeet.png";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});
  const [showPassword, setShowPassword] = useState(false);

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
    // logica de validacion
    let validationError = {};

    if (!username) {
      validationError.username = "Por favor ingrese un Usuario.";
    } else if (username.length < 3) {
      validationError.username = "El usuario debe tener al menos 3 caracteres.";
    }

    if (!password) {
      validationError.password = "Por favor ingrese una Contraseña Valida.";
    } else if (password.length < 8) {
      validationError.password =
        "La contraseña debe tener al menos 8 caracteres.";
    }

    setErrors(validationError); //actualiza el estado de los errores
    // Si no hay errores de validación, maneja el envío del formulario (por ejemplo, llamada a la API)
    if (Object.keys(validationError).length === 0) {
      // Implementa la lógica de inicio de sesión aquí (por ejemplo, llamada a la API)
      console.log("Inicio de sesión exitoso, ¡Bienvenido!:", username, password); // para la prueba

      setUsername("");
      setPassword("");
    }
  };

  const toggleShowPassword = () => {
    setShowPassword((prevState) => !prevState); // invierte el estado actual
  };

  return (
    <section className="userAuth">
      <img src={logo} alt="Logo de Multi Meet" />
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
    </section>
  );
};

export default Login;
