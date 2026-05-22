import type { GamuxProjectData } from "../../types/GamuxProjectData";
import type { GamuxProjectPageData } from "../../types/GamuxProjectPageData";
import { ProjectDataBox } from "./ProjectDataBox/ProjectDataBox";
import { ProjectScreenshotBox } from "./ProjectScreenshotBox/ProjectScreenshotBox";

interface RightSectionProps {
    project: GamuxProjectData
    pageInfo: GamuxProjectPageData

}

export function RightSection({ project, pageInfo }: RightSectionProps) {
    return (
        <div className="w-[40%] max-md:w-full flex flex-col content-center p-4 gap-8">
            <ProjectDataBox project={project} />
            <ProjectScreenshotBox pageInfo={pageInfo} />
        </div>
    )
}