import type GamuxEvent from "@shared/classes/gamux-event/GamuxEvent";
import type GamuxProject from "@shared/classes/gamux-project/GamuxProject";
import { useGamuxEvents } from "@shared/hooks/gamux-event";
import { useGamuxProjects } from "@shared/hooks/gamux-project";

interface LandingData {
    projects: GamuxProject[],
    events: GamuxEvent[]
}

export function getLandingData(): LandingData {
    const { projects = [] } = useGamuxProjects()
    const { events = [] } = useGamuxEvents()

    return { projects, events }
}