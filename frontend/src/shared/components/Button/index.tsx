import type React from "react"
import { cn } from "../../../lib/utils"
import type { MouseEventHandler } from "react"

interface ButtonProps {
    children?: React.ReactNode
    className?: string
    onClick?: MouseEventHandler<HTMLButtonElement> | undefined
}

function Button({ children="", className="", onClick = undefined }: ButtonProps) {
    return(
        <button type="button" onClick={onClick} className={cn("bg-secondary rounded-sm font-title font-medium text-[1.3rem] max-md:text-[1.2rem] cursor-pointer group transition-all transform duration-200 active:scale-[0.95] hover:scale-[1.05]", className)}>
            {children}
        </button>
    )
}

export function WhiteStrokeButton({ children="", className="", onClick = undefined }: ButtonProps) {
    return(
        <Button onClick={onClick} className={cn("border border-secondary bg-none}", className)}>
            {children}
        </Button>
    )
}

export function BlankButton({ children="", className="", onClick = undefined }: ButtonProps) {
    return(
        <Button onClick={onClick} className={cn("bg-background/0", className)}>
            {children}
        </Button>
    )
}

export default Button