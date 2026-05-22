import { useQuery } from "@tanstack/react-query";
import type { GamuxProjectData } from "../types/GamuxProjectData";
import { fetchProjectList } from "../api/fetchProjectList";

interface UseGamuxProjectsReturn {
    projects: GamuxProjectData[] | undefined,
}

export function useGamuxProjectList(_quantity: number = 5): UseGamuxProjectsReturn {
    const query = useQuery({
        queryKey: ["projectsData"],
        queryFn: fetchProjectList
    })
    
    return {
        ... query,
        projects: query?.data?.data.content
    }
}