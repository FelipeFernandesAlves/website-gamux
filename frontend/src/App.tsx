import { Outlet } from "react-router-dom"
import Footer from "./components/Footer"
import Header from "./components/header"

function App() {
  return(
    <div className="App">
      <Header />
      <Outlet />
      {/* <Footer /> */}
    </div>
  )
}

export default App
