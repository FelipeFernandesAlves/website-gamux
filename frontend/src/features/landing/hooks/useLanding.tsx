import { useGamuxProjectList } from "@/features/gamux-project/hooks/useGamuxProjectList";
import type { GamuxProjectData } from "@/features/gamux-project/types/GamuxProjectData";
import type GamuxEvent from "@shared/classes/gamux-event/GamuxEvent";
import { useGamuxEvents } from "@shared/hooks/gamux-event";

interface LandingData {
    projects: GamuxProjectData[],
    events: GamuxEvent[]
}

export function useLanding(): LandingData {
    const { projects = [] } = useGamuxProjectList()
    const { events = [] } = useGamuxEvents()

    return { projects, events }
}