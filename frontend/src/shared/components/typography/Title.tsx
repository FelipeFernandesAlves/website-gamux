import type React from "react"
import { cn } from "../../../lib/utils"

interface TitleProps {
    children?: React.ReactNode
    className?: string
}

function Title({ children = "", className = "" }: TitleProps) {
    return (
        <h1 className={cn("text-9xl max-md:text-8xl text-center font-title font-medium text-secondary", className)}>{children}</h1>
    )
}

export default Title