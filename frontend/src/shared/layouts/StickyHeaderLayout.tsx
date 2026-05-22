import { Suspense } from "react";
import Header from "../components/Header";
import { Outlet } from "react-router-dom";
import Footer from "../components/Footer";


export function StickyHeaderLayout() {
  return(
    <div className="bg-background min-h-svh">
      <Header fixedHeader={true} />
      <Suspense>
        <Outlet />
      </Suspense>
      <Footer />
    </div>
  )
}