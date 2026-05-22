import type { GamuxProjectData } from "@/features/gamux-project/types/GamuxProjectData";
import { H4 } from "@/shared/components/typography/Heading";

interface ProjectDataBoxProps {
    project: GamuxProjectData
}

export function ProjectDataBox({ project }: ProjectDataBoxProps) {
    const headingCn = "text-(--h) text-right capitalize"
    const infoCn = "text-(--text) h-full flex items-center flex-wrap gap-x-2 font-medium capitalize"

    const data = {
        "tipo": project.type.toLocaleLowerCase(),
        "status": project.status.toLocaleLowerCase().replace("_", " "),
        "equipe": project.teamMembers.map((member) => { return (<a href="#" className="text-(--link)">{member.name}</a>) }),
        "tags": project.tags.join(", "),
        "gêneros": project.genres.join(", ")
    }

    return (
        <div className="grid grid-cols-[1fr_2fr] w-full gap-2">
            {
                Object.entries(data).map(([key, value]) => {
                    if (!value || value == "") {
                        return
                    }

                    return (
                        <>
                            <H4 className={headingCn}>{key}:</H4>
                            <H4 className={infoCn}>{ value }</H4>
                        </>
                    )
                })
            }
        </div>
    )
}