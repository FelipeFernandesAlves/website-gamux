
import { useQuery } from "@tanstack/react-query";
import type GamuxProjectPageData from "../types/GamuxProjectPageData";
import { fetchProjectPageInfo } from "../api/fetchProjectPageInfo";

interface UseGamuxProjectPageInfoReturn {
    pageInfo: GamuxProjectPageData | undefined
}

export function useGamuxProjectPageInfo( projectId: string ): UseGamuxProjectPageInfoReturn {
    if (!projectId)
        return {pageInfo: undefined}

    const query = useQuery({
        queryKey: ['fetchProjectPage', projectId],
        queryFn: fetchProjectPageInfo
    })

    return {
        ... query,
        pageInfo: query.data?.data
    }
}
