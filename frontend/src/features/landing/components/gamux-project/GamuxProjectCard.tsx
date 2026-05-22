import { HeartIcon } from "@heroicons/react/24/outline"
import { BlankButton } from "../../../../shared/components/Button"
import { H4, H5 } from "../../../../shared/components/typography/Heading"
import Card from "../Card"
import { imgUrl } from "@/shared/services/api"
import type { GamuxProjectData } from "@/features/gamux-project/types/GamuxProjectData"

interface ProjectPreviewProps {
    project: GamuxProjectData
}

function GameProjectCard({ project }: ProjectPreviewProps) {
    let lastUpdated = <H5>Criado em: {project.createdAt}</H5>
    if (project.lastUpdated) {
        lastUpdated = <H5>Atualizado em: {project.lastUpdated ? new Date(project.lastUpdated).toDateString() : ""}</H5>
    }

    return(
        <Card imgSrc={`${imgUrl}/${project.logo}`} imgAlt={`logo-${project.name}`} tags={project.tags} url={`project/${project.id}/${project.slug}`}>
            <div className="w-full flex flex-row justify-between items-center p-3">
                <div className="w-full flex flex-col">
                    <H4>{project.name}</H4>
                    {lastUpdated}
                </div>

                <div className="flex flex-col gap-1">
                    <BlankButton>
                        <HeartIcon className="stroke-secondary w-8" />
                    </BlankButton>
                </div>
            </div>
        </Card>
    )
}

export default GameProjectCard