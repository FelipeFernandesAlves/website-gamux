import type React from "react"
import { cn } from "../../../lib/utils"

interface ParagraphProps {
    children?: React.ReactNode
    className?: string
}

function Paragraph({children = "", className = ""}: ParagraphProps) {
    return(
        <p className={cn("font-text text-secondary text-[1.2em]", className)}>{children}</p>
    )
}

export default Paragraph