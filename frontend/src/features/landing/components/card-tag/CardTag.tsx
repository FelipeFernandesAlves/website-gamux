import { H4 } from "../../../../shared/components/typography/Heading"
import { getTagInfo } from "./ProjectTag.viewModel"

interface TagProps {
    tagName?: string
    className?: string
}

function CardTag({ tagName = "", className = "" }: TagProps) {
    const { icon, color } = getTagInfo(tagName)

    return (
        <div className={`flex gap-2 rounded-[5px] px-2  ${color} ${className}`}>
            {icon}
            <H4>{tagName}</H4>
        </div>
    )
}

export default CardTag