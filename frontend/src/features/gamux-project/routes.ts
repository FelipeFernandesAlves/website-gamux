import type { RouteObject } from "react-router-dom";
import { StaticHeaderLayout } from "@shared/layouts";
import { lazy } from "react";

const GamuxProjectPage = lazy(() => import('./pages/GamuxProjectPage'))

export const gamuxProjectRoutes:RouteObject[] = [ 
  {
    path: "/project",
    Component: StaticHeaderLayout,
    children: [
      {
        path: "/project/:projectId/:projectSlug",
        Component: GamuxProjectPage
      }
    ]
  }
]