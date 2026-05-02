import type GamuxProjectPageInfo from "@shared/classes/gamux-project/GamuxProjectPageInfo"
import GamuxProjectUpdate from "@shared/classes/gamux-project/GamuxProjectUpdate"
import Paragraph from "@shared/components/typography/Paragraph"
import { ExternalLinks } from "./ExternalLinks/ExternalLinks"
import { ProjectCommentWrapper } from "./Comments/CommentWrapper"
import { Updates } from "./Updates/Updates"
import type GamuxProject from "@shared/classes/gamux-project/GamuxProject"

interface LeftSectionProps {
    project: GamuxProject
    data: GamuxProjectPageInfo
    updates: GamuxProjectUpdate[]
}

export function LeftSection({ project, data, updates }: LeftSectionProps) {
    return (
        <div className="w-[70%] max-md:w-full h-fit flex flex-col gap-5">
            <Paragraph className="text-left text-(--text)">{data.description}</Paragraph>
            <ExternalLinks external_links={data.external_links} />
            <Updates updates={updates} />
            <ProjectCommentWrapper project={project} />
        </div>
    )
}