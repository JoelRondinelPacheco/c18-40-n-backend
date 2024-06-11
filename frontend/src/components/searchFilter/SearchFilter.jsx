import './SearchFilter.css'

const SearchFilter = () => {
  return (
    <div className="container-search-filter">
        
        <div className="filters">
            <select className="filter">
                <option>Fecha</option>
            </select>
            <select className="filter">
                <option>Localidad</option>
            </select>
            <select className="filter">
                <option>Horario</option>
            </select>
            <select className="filter">
                <option>Precio</option>
            </select>
            <select className="filter">
                <option>Temática</option>
            </select>
            <button className="apply-button">Aplicar filtros</button>
        </div>
    </div>
  )
}

export default SearchFilter
