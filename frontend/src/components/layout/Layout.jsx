import Header from '../header/Header'
import Footer from '../footer/Footer'

const Layout = ({children}) => {
  return (
    <div className='layout'>
      <Header />
      <div>
        {children}
      </div>
      <Footer />
    </div>
  )
}

export default Layout
