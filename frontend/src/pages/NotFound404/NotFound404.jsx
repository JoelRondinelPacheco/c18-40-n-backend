import { Link } from 'react-router-dom'
import './NotFound404.css'

const NotFound404 = () => {
  return (
    <div className='not-found'>
        <h1>Oops!</h1>
        <p>El evento que estás buscando no se encuentra disponible</p>
        <Link to="/">Volver al inicio</Link>
    </div>
  )
}

export default NotFound404
