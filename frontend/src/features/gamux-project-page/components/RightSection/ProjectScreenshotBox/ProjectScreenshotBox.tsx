import type GamuxProject from "@/shared/classes/gamux-project/GamuxProject";

interface ProjectScreenshotBoxProps {
    project: GamuxProject
}

export function ProjectScreenshotBox({ project }: ProjectScreenshotBoxProps) {
    if (!project.screenshots) {
        return
    }

    return (
        <div className="flex flex-col gap-4">
            {
                project.screenshots.map((url: string, i: number) => {
                    return (
                        <img src={url} alt={`screenshot-${i}`} className="object-cover w-full cursor-pointer" />
                    )
                })
            }
        </div>
    )
}