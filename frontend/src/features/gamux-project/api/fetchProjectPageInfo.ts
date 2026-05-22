import api from "@/shared/services/api"
import type { QueryFunctionContext } from "@tanstack/react-query"
import type { AxiosPromise } from "axios"
import type GamuxProjectPageData from "../types/GamuxProjectPageData"


export const fetchProjectPageInfo = async ({ queryKey }: QueryFunctionContext<readonly [string, string]>): AxiosPromise<GamuxProjectPageData> => {
    const [_key, id] = queryKey
    return await api.get(`/public/projects/page/${id}`)   
}
