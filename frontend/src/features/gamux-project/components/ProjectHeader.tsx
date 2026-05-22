import type { GamuxProjectData } from "@/features/gamux-project/types/GamuxProjectData"
import { HeartIcon, ShareIcon } from "@heroicons/react/24/outline"
import { H2, H3 } from "@shared/components/typography/Heading"

interface ProjectHeaderProps {
    project: GamuxProjectData
}

function ProjectHeader({ project }: ProjectHeaderProps) {
    return <div className="flex flex-col p-10 w-full border-b-2 border-b-(--text)/20">
        <div className="flex flex-row w-full items-center gap-2">
            <H2 className="text-(--text)">{project.name}</H2>
            <HeartIcon className="w-8 stroke-(--text)" />
            <ShareIcon className="w-7 stroke-(--text)" />
        </div>
        <H3>{project.lastUpdated}</H3>
        <H3>Por <span className="text-(--h)">{`${project.teamMembers[0].name}`}</span></H3>
    </div>
}

export default ProjectHeader