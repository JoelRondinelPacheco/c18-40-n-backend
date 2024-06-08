import './Blog.css';

const Blog = () => {
  const articles = [
    {
      id: 1,
      title: 'La evolución de la Inteligencia Artificial',
      date: '5 de junio de 2024',
      content: 'La inteligencia artificial ha avanzado a pasos agigantados en los últimos años...',
    },
    {
      id: 2,
      title: 'Las mejores prácticas de desarrollo web en 2024',
      date: '3 de junio de 2024',
      content: 'El desarrollo web sigue evolucionando con nuevas tecnologías y frameworks...',
    },
    {
      id: 3,
      title: 'Cómo la tecnología está transformando la educación',
      date: '1 de junio de 2024',
      content: 'La tecnología ha abierto nuevas posibilidades en el ámbito educativo...',
    },
    {
      id: 4,
      title: 'Cómo la tecnología está transformando la educación',
      date: '1 de junio de 2024',
      content: 'La tecnología ha abierto nuevas posibilidades en el ámbito educativo...',
    },
    {
      id: 5,
      title: 'Cómo la tecnología está transformando la educación',
      date: '1 de junio de 2024',
      content: 'La tecnología ha abierto nuevas posibilidades en el ámbito educativo...',
    },
  ];

  return (
    <div className="blog-container">
      <h1>Blog de Tecnología</h1>
      {articles.map(article => (
        <div key={article.id} className="blog-article">
          <h2>{article.title}</h2>
          <p className="blog-date">{article.date}</p>
          <p>{article.content}</p>
        </div>
      ))}
    </div>
  );
}

export default Blog;
