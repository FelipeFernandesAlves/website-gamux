import type React from "react"
import { cn } from "../../../lib/utils"

interface HeadingProps {
    children?: React.ReactNode
    className?: string
}

export function H1({ children = "", className = "" }: HeadingProps) {
    return (
        <h1 className={cn("font-title text-secondary text-5xl font-semibold", className)}>{children}</h1>
    )
}

export function H2({ children = "", className = "" }: HeadingProps) {
    return(
        <h2 className={cn("font-title text-secondary text-3xl font-semibold", className)}>{children}</h2>
    )
}

export function H3({ children = "", className = "" }: HeadingProps) {
    return(
        <h3 className={cn("font-title text-secondary text-xl font-semibold", className)}>{children}</h3>
    )
}

export function H4({ children = "", className = "" }: HeadingProps) {
    return(
        <h3 className={cn("font-title text-secondary text-lg font-semibold", className)}>{children}</h3>
    )
}

export function H5({ children = "", className = "" }: HeadingProps) {
    return(
        <h3 className={cn("font-title text-secondary text-sm font-medium", className)}>{children}</h3>
    )
}
