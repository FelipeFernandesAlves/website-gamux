import type GamuxProject from "@/shared/classes/gamux-project/GamuxProject";
import { ProjectDataBox } from "./ProjectDataBox/ProjectDataBox";
import { ProjectScreenshotBox } from "./ProjectScreenshotBox/ProjectScreenshotBox";

interface RightSectionProps {
    project: GamuxProject
}

export function RightSection({ project }: RightSectionProps) {
    return (
        <div className="w-[40%] max-md:w-full flex flex-col content-center p-4 gap-8">
            <ProjectDataBox project={project} />
            <ProjectScreenshotBox project={project} />
        </div>
    )
}