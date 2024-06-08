import './Home.css';
import Banner from '../../components/banner/Banner';
import SearchFilter from '../../components/searchFilter/SearchFilter';
// import Recommended from '../../components/recommended/Recommended';
import ItTalks from '../../components/itTalks/ItTalks';

const Home = () => {
  return (
    <>
    <div className='main'>
        <Banner />
        <SearchFilter />
        {/* <Recommended /> commentada ya que es la misma información que itTalks, pero es negociable */}
        <ItTalks />
    </div>
    </>
  )
}

export default Home
