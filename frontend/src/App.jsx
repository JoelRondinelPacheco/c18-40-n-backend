import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home/Home';
import Layout from './components/layout/Layout';
import EventDetails from './pages/EventDetails/EventDetails';
import NotFound404 from './pages/NotFound404/NotFound404';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import EventComponent from './pages/EventComponent/EventComponent';
import Login from './pages/auth/Login';
import Register from './pages/auth/Register';
import AboutUs from './pages/about/AboutUs';
import ScrollToTop from './components/scrollToTop/ScrollToTop';
import UserProfile from './pages/userProfile/UserProfile';

function App() {

  return (
    

    <BrowserRouter>
      <ScrollToTop/>
        <Routes>
            <Route path='login' element={<Login />} />
            <Route path='register' element={<Register />} />
            <Route path='*' element={<LayoutWrapper />} />
        </Routes>
        <ToastContainer />
    </BrowserRouter>
  );
}

const LayoutWrapper = () => {
  return(
    <Layout>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='event/:id' element={<EventDetails />} />
        <Route path='create-event' element={<EventComponent />} />
        <Route path='about-us' element={<AboutUs />} />
        <Route path='user-profile' element={<UserProfile/>}/>
        <Route path='*' element={<NotFound404 />} />
      </Routes>
    </Layout>
  )
}

export default App
