import { useEffect, useState } from "react";
import GamuxProject from "@shared/classes/gamux-project/GamuxProject";
import GamuxProjectUpdate from "@shared/classes/gamux-project/GamuxProjectUpdate";
import { useGamuxProject, useGamuxProjectUpdates } from "@shared/hooks/gamux-project";
import GamuxProjectPageInfo from "@shared/classes/gamux-project/GamuxProjectPageInfo";

interface GamuxProjectPageData {
    project: GamuxProject | null,
    projectUpdates: GamuxProjectUpdate[],
    data: GamuxProjectPageInfo
}

export function getGamuxProjectPageData(): GamuxProjectPageData {
    const [data, setData] = useState(new GamuxProjectPageInfo())

    const { project } = useGamuxProject("")
    const { projectUpdates } = useGamuxProjectUpdates(project)

    useEffect(() => {
        if (!project) return
        setData(project.pageInfo)
    }, [project])

    

    return { project, projectUpdates, data }
}
