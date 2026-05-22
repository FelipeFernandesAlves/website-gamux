import api from "@/shared/services/api"
import type { GamuxProjectData } from "../types/GamuxProjectData"
import type { AxiosPromise } from "axios"

interface FetchProjectsResponse {
    content: GamuxProjectData[]
}

export const fetchProjectList = async (): AxiosPromise<FetchProjectsResponse> => {
    return await api.get<FetchProjectsResponse>("/public/projects")
}