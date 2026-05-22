import { useQuery } from "@tanstack/react-query";
import type { GamuxProjectData } from "../types/GamuxProjectData";
import { fetchProjectDetails } from "../api/fetchProjectDetails";

interface UseGamuxProjectReturn {
    project: GamuxProjectData | undefined
}

/**
 * Returona as informações de um projeto específico, incluindo suas atualizações.
 * @param projectId O id do projeto para o qual se deseja obter as informações.
 * @returns Um objeto contendo as informações do projeto e suas atualizações.
 */
export function useGamuxProjectDetails( projectId: string ): UseGamuxProjectReturn {
    if (!projectId)
        return {project: undefined}

    const query = useQuery({
        queryKey: ['fetchProject', projectId],
        queryFn: fetchProjectDetails
    })

    return {
        ... query,
        project: query.data?.data
    }
}
