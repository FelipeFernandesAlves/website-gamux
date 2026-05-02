import { createRoot } from 'react-dom/client'
import React, { lazy } from 'react'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'

import "./theme.css";
import App, { StaticHeaderLayout } from './App.tsx'

const LandingPage = lazy(() => import('./features/landing/LandingPage.tsx'))
const GamuxProjectPage = lazy(() => import('./features/gamux-project-page/GamuxProjectPage.tsx'))

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/",
        element: <LandingPage />
      },
    ]
  },
  {
    path: "/",
    element: <StaticHeaderLayout />,
    children: [
      {
        path: "/project/:projectName",
        element: <GamuxProjectPage />
      }
    ]
  }
])

createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
      <RouterProvider router={router} />
    </React.StrictMode>
)
