import { useRoutes, type RouteObject } from "react-router-dom"

const modules = import.meta.glob('./features/**/routes.ts', { eager: true })
const routes: RouteObject[] = []

Object.values(modules).forEach((module: any) => {
    Object.values(module).forEach((val) => {
    if (Array.isArray(val)) {
        routes.push(...val);
    }
    })
})

export const AppRouter = (() => {
    return useRoutes(routes)
})