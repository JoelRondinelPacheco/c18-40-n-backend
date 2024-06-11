import './Blog.css';

const Blog = () => {
  const articles = [
    {
      id: 1,
      category: 'La evolución de la inteligencia artificial',
      title: 'La evolución de la Inteligencia Artificial',
      date: '08/04/2023',
      image: 'bannerAboutUs.jpg'
    },
    {
      id: 2,
      category: 'Las mejores prácticas de desarrollo Web en 2024',
      title: 'Las mejores prácticas de desarrollo Web en 2024',
      date: '08/04/2023',
      image: 'danzaClasica.jpeg'
    },
    {
      id: 3,
      category: 'Cómo la tecnología está transformando al educación',
      title: 'Cómo la tecnología está transformando la educación',
      date: '08/04/2023',
      image: 'bannerAboutUs.jpg'
    },
    {
      id: 4,
      category: 'Las mejores prácticas de desarrollo Web en 2024',
      title: 'Las mejores prácticas de desarrollo Web en 2024',
      date: '08/04/2023',
      image: 'danzaClasica.jpeg'
    },
    {
      id: 5,
      category: 'Cómo la tecnología está transformando al educación',
      title: 'Cómo la tecnología está transformando la educación',
      date: '08/04/2023',
      image: 'bannerAboutUs.jpg'
    },
    {
      id: 6,
      category: 'La evolución de la inteligencia artificial',
      title: 'La evolución de la Inteligencia Artificial',
      date: '08/04/2023',
      image: 'danzaClasica.jpeg'
    },
  ];

  return (
    <div className="blog-container">
      <h1>Blog</h1>
      <div className="blog-grid">
        {articles.map(article => (
          <div key={article.id} className="blog-article">
            <img src={article.image} alt={article.title} className="blog-image" />
            <div className="blog-content">
              <span className="blog-category">{article.category}</span>
              <h2>{article.title}</h2>
              <p className="blog-date">{article.date}</p>
              <p className="blog-excerpt">La evolución de la inteligencia artificial...</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Blog;
