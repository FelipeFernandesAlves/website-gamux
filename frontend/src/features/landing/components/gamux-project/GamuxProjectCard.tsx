import { HeartIcon } from "@heroicons/react/24/outline"
import type Project from "../../../../shared/classes/gamux-project/GamuxProject"
import { BlankButton } from "../../../../shared/components/Button"
import { H4, H5 } from "../../../../shared/components/typography/Heading"
import Card from "../Card"

interface ProjectPreviewProps {
    project: Project
}

function GameProjectCard({ project }: ProjectPreviewProps) {
    let lastUpdated = <H5>Criado em em: {project.created_at.toDateString()}</H5>
    if (project.last_updated) {
        lastUpdated = <H5>Atualizado em: {project.last_updated.toDateString()}</H5>
    }

    return(
        <Card imgSrc={project.logo} imgAlt={`logo-${project.name}`} tags={project.tags} url={`project/${project.name.toLocaleLowerCase().replace(" ", "-")}`}>
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