import api from "@/shared/services/api"
import type { QueryFunctionContext } from "@tanstack/react-query"
import type { AxiosPromise } from "axios"
import type { GamuxProjectData } from "../types/GamuxProjectData"


export const fetchProjectDetails = async ({ queryKey }: QueryFunctionContext<readonly [string, string]>): AxiosPromise<GamuxProjectData> => {
    const [_key, id] = queryKey
    return await api.get(`/public/projects/${id}/teste`)   
}