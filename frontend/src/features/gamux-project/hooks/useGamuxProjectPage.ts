import type { GamuxProjectData } from "../types/GamuxProjectData";
import type GamuxProjectPageData from "../types/GamuxProjectPageData";
import type GamuxProjectUpdateData from "../types/GamuxProjectUpdateData";
import { useGamuxProjectDetails } from "./useGamuxProjectDetails";
import { useGamuxProjectPageInfo } from "./useGamuxProjectPageInfo";

interface UseGamuxProjectPageReturn {
    project: GamuxProjectData | undefined,
    projectUpdates: GamuxProjectUpdateData[],
    pageInfo: GamuxProjectPageData | undefined
}

export function useGamuxProjectPage(projectId: string | undefined): UseGamuxProjectPageReturn {
    if (!projectId)
        return {project: undefined, projectUpdates: [], pageInfo: undefined}

    const { project } = useGamuxProjectDetails(projectId)
    const { pageInfo } = useGamuxProjectPageInfo(projectId)

    return {
        project: project,
        pageInfo: pageInfo,
        projectUpdates: []
    }
}
