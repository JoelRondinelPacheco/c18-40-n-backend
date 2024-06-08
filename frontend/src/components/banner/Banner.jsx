import { useState, useEffect } from 'react';
import { MdArrowBackIosNew, MdArrowForwardIos } from "react-icons/md";
import './Banner.css';

const images = [
  // Replace these with the paths to your actual images
  './test.jpg',
  './bannerAboutUs.jpg',
  './test.jpg',
  './bannerAboutUs.jpg',
  './test.jpg',
  './bannerAboutUs.jpg',
];

const Banner = () => {
  const [currentImage, setCurrentImage] = useState(0);

  const handlePrevImage = () => {
    setCurrentImage((prevImage) => (prevImage - 1 + images.length) % images.length);
  };

  const handleNextImage = () => {
    setCurrentImage((prevImage) => (prevImage + 1) % images.length);
  };

  useEffect(() => {
    const intervalId = setInterval(() => {
      handleNextImage();
    }, 3000); // Change this value to adjust transition speed (in milliseconds)

    // Cleanup function to clear the interval on component unmount
    return () => clearInterval(intervalId);
  }, []);

  return (
    <div className='container-banner'>
      <img
        src={images[currentImage]}
        alt={`Banner Image ${currentImage + 1}`}
        className='image-banner'
      />

      {/* Navigation Arrows */}
      <div className='banner-arrows'>
        <div className='prev-arrow' onClick={handlePrevImage}>
          <MdArrowBackIosNew size={50} />
        </div>
        <div className='next-arrow' onClick={handleNextImage}>
          <MdArrowForwardIos size={50} />
        </div>
      </div>

      {/* Navigation Dots */}
      <div className='banner-dots'>
        {images.map((_, index) => (
          <span
            key={index}
            className={`banner-dot ${index === currentImage ? 'active' : ''}`}
            onClick={() => setCurrentImage(index)}
          ></span>
        ))}
      </div>
    </div>
  );
};

export default Banner;
