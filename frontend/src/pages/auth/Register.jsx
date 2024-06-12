import { useState } from "react";
import logo from '/logoBlackOrange.png';
import "./Auth.css";

const Register = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [errors, setErrors] = useState({});
  const [successMessage, setSuccessMessage] = useState("");

  const handleOnChange = (event) => {
    const { name, value } = event.target;
    setErrors((prevState) => ({
      ...prevState,
      [name]: "",
    }));

    if (name === "username") {
      setUsername(value);
    } else if (name === "email") {
      setEmail(value);
    } else if (name === "password") {
      setPassword(value);
    } else if (name === "confirmPassword") {
      setConfirmPassword(value);
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    let validationErrors = {};

    // Validations
    if (username.trim().length === 0) {
      validationErrors.username = "El campo usuario es obligatorio";
    } else if (username.length < 3) {
      validationErrors.username = "El nombre de usuario debe tener al menos 3 caracteres";
    }

    if (email.trim().length === 0) {
      validationErrors.email = "Por favor ingrese un correo electrónico";
    }

    if (password.trim().length < 8) {
      validationErrors.password = "La contraseña debe tener al menos 8 caracteres";
    } else if (!/[a-z]+/.test(password)) {
      validationErrors.password = "La contraseña debe contener al menos una letra minúscula";
    } else if (!/[A-Z]+/.test(password)) {
      validationErrors.password = "La contraseña debe contener al menos una letra mayúscula";
    } else if (!/\d+/.test(password)) {
      validationErrors.password = "La contraseña debe contener al menos un número";
    } else if (!/[!@#\$%\^&\*()_+\-=\[\]{};':"\\|,.<>\/?]+/.test(password)) {
      validationErrors.password = "La contraseña debe contener al menos un carácter especial(#,@,&,$,%)";
    }

    if (confirmPassword.trim().length === 0) {
      validationErrors.confirmPassword = "La confirmación de contraseña es obligatoria";
    } else if (password !== confirmPassword) {
      validationErrors.confirmPassword = "Las contraseñas no coinciden";
    }

    setErrors(validationErrors);

    if (Object.keys(validationErrors).length === 0) {
      try {
        const response = await fetch("http://localhost:8080/api/v1/auth/register", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            username: username,
            email: email,
            password: password,
            repeatedPassword: confirmPassword,
          }),
        });


        if (!response.ok) {
          throw new Error("Error en el registro");
        }

        const data = await response.json();
        console.log("Usuario registrado satisfactoriamente", data);
        setSuccessMessage("Usuario registrado satisfactoriamente");

        // Limpiar los campos después del registro exitoso
        setUsername("");
        setEmail("");
        setPassword("");
        setConfirmPassword("");
      } catch (error) {
        console.error("Error al registrar el usuario:", error);
        setErrors({ apiError: "Error al registrar el usuario. Inténtelo de nuevo más tarde." });
      }
    }
  };

  return (
    <div className="parentContainer">
      <section className="userAuth">
        <img src={logo} alt="Logo de Multi Meet" />
        <h1>Iniciar Registro</h1>
        {successMessage && <p className="success-message">{successMessage}</p>}
        <form className="form" onSubmit={handleSubmit}>
          <label className="label" htmlFor="usuario">
            Usuario
          </label>
          {errors.username && <p className="error-message">{errors.username}</p>}
          <input
            className="input"
            type="text"
            id="usuario"
            name="username"
            value={username}
            onChange={handleOnChange}
          />

          <label className="label" htmlFor="email">
            Correo Electrónico
          </label>
          {errors.email && <p className="error-message">{errors.email}</p>}
          <input
            className="input"
            placeholder="nombredeusuario@dominio.com"
            type="email"
            id="email"
            name="email"
            value={email}
            onChange={handleOnChange}
          />

          <label className="label" htmlFor="contraseña">
            Contraseña
          </label>
          {errors.password && <p className="error-message">{errors.password}</p>}
          <input
            className="input"
            type="password"
            id="contraseña"
            name="password"
            value={password}
            onChange={handleOnChange}
          />

          <label className="label" htmlFor="confirmarContraseña">
            Por favor confirmar contraseña
          </label>
          {errors.confirmPassword && (
            <p className="error-message">{errors.confirmPassword}</p>
          )}
          <input
            className="input"
            type="password"
            id="confirmarContraseña"
            name="confirmPassword"
            value={confirmPassword}
            onChange={handleOnChange}
          />

          <button className="button" type="submit">
            Registrarse
          </button>
        </form>
        <p>{errors.apiError}</p>
        <p>¿Ya tienes una cuenta? <a href="/">Iniciar sesión</a></p>
      </section>
    </div>
  );
};

export default Register;
