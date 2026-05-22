import { useEffect, useState } from "react"
import type { GamuxProjectData } from "../types/GamuxProjectData"
import type GamuxProjectUpdateData from "../types/GamuxProjectUpdateData"

interface UseGamuxProjectUpdatesReturn {
    projectUpdates: GamuxProjectUpdateData[],
    setProjectUpdates: React.Dispatch<React.SetStateAction<GamuxProjectUpdateData[]>>
}

export function useGamuxProjectUpdates(project: GamuxProjectData | null): UseGamuxProjectUpdatesReturn {
    const [projectUpdates, setProjectUpdates] = useState<GamuxProjectUpdateData[]>([])

    useEffect(() => {
        if (!project) return

        setProjectUpdates([
            {
                title: "Lançamento na Steam!",
                content: "",
                createdAt: new Date().toDateString()
            }
        ])
    }, [project])

    return { projectUpdates, setProjectUpdates }
}