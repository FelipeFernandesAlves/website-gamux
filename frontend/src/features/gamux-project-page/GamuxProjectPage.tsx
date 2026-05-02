
import ProjectHeader from "./components/ProjectHeader"
import { LeftSection } from "./components/LeftSection"
import { RightSection } from "./components/RightSection"
import { getGamuxProjectPageData } from "./GamuxProjectPage.viewModel"
import { formatStringName } from "@lib/utils"

interface GamuxProjectPageProps {

}

function GamuxProjectPage({}: GamuxProjectPageProps) {
    const { project, projectUpdates, data } = getGamuxProjectPageData()

    if (!project) {
        return
    }

    const theme = {
        '--bg': data.bg_color,
        '--bg2': data.bg2_color,
        '--h': data.heading_color,
        '--link': data.link_color,
        '--text': data.text_color
    }

    return (
        <div 
            className="bg-(--bg) w-full h-fit min-h-svh flex flex-col justify-start items-center"
            style={theme as React.CSSProperties}
        >
            <div className="bg-(--bg2) flex flex-col w-[70%] max-md:w-full h-fit min-h-svh border border-black shadow-2xl shadow-primary/30">
                <div className="w-full h-fit">
                    <img src={data.banner} alt={`banner-${formatStringName(project.name)}`} className="w-full object-cover" />
                </div>

                <ProjectHeader project={project} />

                <div className="w-full flex max-md:flex-col-reverse p-10 max-md:p-6 max-md:gap-4">
                    <LeftSection data={data} updates={projectUpdates} project={project} />
                    <RightSection project={project} />
                </div>
            </div>

        </div>
    )
}

export default GamuxProjectPage
