import type { RouteObject } from "react-router-dom";
import { lazy } from "react";
import { StickyHeaderLayout } from "@/shared/layouts";

const LandingPage = lazy(() => import('./pages/LandingPage'))

export const landingRoutes:RouteObject[] = [ 
    {
        path: "/",
        Component: StickyHeaderLayout,
        children: [
        {
            path: "",
            Component: LandingPage
        },
        ]
    },
]

