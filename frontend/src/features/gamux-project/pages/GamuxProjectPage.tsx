
import ProjectHeader from "../components/ProjectHeader"
import { LeftSection } from "../components/LeftSection"
import { RightSection } from "../components/RightSection"
import { formatStringName } from "@lib/utils"
import { Navigate, useParams } from "react-router-dom"
import { useGamuxProjectPage } from "../hooks/useGamuxProjectPage"

interface GamuxProjectPageProps {

}

function GamuxProjectPage({}: GamuxProjectPageProps) {
    const { projectId, projectSlug } = useParams<{projectId: string, projectSlug: string}>()
    const { project, projectUpdates, pageInfo } = useGamuxProjectPage(projectId)
    
    if (!project || !pageInfo)
        return

    if (project.slug != projectSlug)
        return <Navigate to={`/project/${project.id}/${project.slug}`} />

    const theme = {
        '--bg': pageInfo.bgColor,
        '--bg2': pageInfo.bg2Color,
        '--h': pageInfo.headingColor,
        '--link': pageInfo.linkColor,
        '--text': pageInfo.textColor
    }

    return (
        <div 
            className="bg-(--bg) w-full h-fit min-h-svh flex flex-col justify-start items-center"
            style={theme as React.CSSProperties}
        >
            <div className="bg-(--bg2) flex flex-col w-[70%] max-md:w-full h-fit min-h-svh border border-black shadow-2xl shadow-primary/30">
                <div className="w-full h-fit">
                    <img src={pageInfo.banner} alt={`banner-${formatStringName(project.name)}`} className="w-full object-cover" />
                </div>

                <ProjectHeader project={project} />

                <div className="w-full flex max-md:flex-col-reverse p-10 max-md:p-6 max-md:gap-4">
                    <LeftSection data={pageInfo} updates={projectUpdates} project={project} />
                    <RightSection project={project} pageInfo={pageInfo} />
                </div>
            </div>

        </div>
    )
}

export default GamuxProjectPage
