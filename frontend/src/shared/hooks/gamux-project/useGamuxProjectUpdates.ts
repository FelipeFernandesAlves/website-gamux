import { useEffect, useState } from "react"
import GamuxProjectUpdate from "../../classes/gamux-project/GamuxProjectUpdate"
import type GamuxProject from "../../classes/gamux-project/GamuxProject"

interface UseGamuxProjectUpdatesReturn {
    projectUpdates: GamuxProjectUpdate[],
    setProjectUpdates: React.Dispatch<React.SetStateAction<GamuxProjectUpdate[]>>
}

export function useGamuxProjectUpdates(project: GamuxProject | null): UseGamuxProjectUpdatesReturn {
    const [projectUpdates, setProjectUpdates] = useState<GamuxProjectUpdate[]>([])

    useEffect(() => {
        if (!project) return

        setProjectUpdates([
            new GamuxProjectUpdate(
                "Lançamento na steam!",
                project,
                "",
                new Date()
            ),
            new GamuxProjectUpdate(
                "Lançamento da demo",
                project,
                "",
                new Date()
            )
        ])
    }, [project])

    return { projectUpdates, setProjectUpdates }
}