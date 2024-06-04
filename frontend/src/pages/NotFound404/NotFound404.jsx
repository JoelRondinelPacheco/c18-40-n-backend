import { Link } from 'react-router-dom'
import './NotFound404.css'

const NotFound404 = () => {
  return (
    <div className='not-found'>
        <h1>Página no disponible</h1>
        <p>Lo sentimos, el enlace que has seguido no está disponible.</p>
        <Link to="/">Volver al inicio</Link>
    </div>
  )
}

export default NotFound404
