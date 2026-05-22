import type { GamuxProjectPageData } from "@/features/gamux-project/types/GamuxProjectPageData"

interface ProjectScreenshotBoxProps {
    pageInfo: GamuxProjectPageData
}

export function ProjectScreenshotBox({ pageInfo }: ProjectScreenshotBoxProps) {
    if (!pageInfo.screenshots) {
        return
    }

    return (
        <div className="flex flex-col gap-4">
            {
                pageInfo.screenshots.map((url: string, i: number) => {
                    return (
                        <img src={url} alt={`screenshot-${i}`} className="object-cover w-full cursor-pointer" />
                    )
                })
            }
        </div>
    )
}