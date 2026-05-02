import { useEffect, useState } from "react";
import GamuxProject from "../../classes/gamux-project/GamuxProject";
import User from "../../classes/user/User";

interface UseGamuxProjectsReturn {
    projects: GamuxProject[],
    setProjects: React.Dispatch<React.SetStateAction<GamuxProject[]>>
}

export function useGamuxProjects(_quantity: number = 5): UseGamuxProjectsReturn {
    const [projects, setProjects] = useState<GamuxProject[]>([])
    // TODO: Buscar os projetos da API, por enquanto, retorna dados mockados

    useEffect(() => {
        setProjects([
            new GamuxProject (
                "Soul Chain",
                "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/3383610/e78435f8104a2587b7210ff889cdb1ed66cfac52/header.jpg?t=1774803639", 
                undefined,
                "",
                ["Em Progresso"],
                new User("Moraguma", "", ""),
                100,
                new Date(),
            ),
        ])
    }, [])

    return { projects, setProjects }
}