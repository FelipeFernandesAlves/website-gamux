import { Outlet } from "react-router-dom"
import Footer from "./shared/components/Footer"
import Header from "./shared/components/Header"
import { Suspense } from "react"

function App() {
  return(
    <div className="App bg-background min-h-svh">
      <Header fixedHeader={true} />
      <Suspense>
        <Outlet />
      </Suspense>
      <Footer />
    </div>
  )
}

export function StaticHeaderLayout() {
  return(
    <div className="App bg-background min-h-svh">
      <Header fixedHeader={false} />
      <Suspense>
        <Outlet />
      </Suspense>
      <Footer />
    </div>
  )
}

export default App
