import { CheckBadgeIcon, SparklesIcon } from "@heroicons/react/24/solid"
import type { JSX } from "react"

interface TagInfoResponse {
    icon: JSX.Element
    color: string
}

export function getTagInfo(tagName: string): TagInfoResponse {
    const tagInfos: Record<string, TagInfoResponse> = {
        "Em Progresso": { icon: <SparklesIcon className="w-5 fill-secondary" />, color: "bg-green-500" },
        "Finalizado": { icon: <CheckBadgeIcon className="w-5 fill-secondary" />, color: "bg-gray-700" },
    }

    const info = tagInfos[tagName]
    if (info == undefined) {
        return { icon: <></>, color: "bg-background" }
    }

    return info
}