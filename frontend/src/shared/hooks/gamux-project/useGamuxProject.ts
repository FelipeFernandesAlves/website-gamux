import { useEffect, useState } from "react";
import GamuxProject from "../../classes/gamux-project/GamuxProject";
import User from "../../classes/user/User";
import GamuxProjectPageInfo from "../../classes/gamux-project/GamuxProjectPageInfo";

interface UseGamuxProjectReturn {
    project: GamuxProject | null,
    setProject: React.Dispatch<React.SetStateAction<GamuxProject | null>>
}

/**
 * Returona as informações de um projeto específico, incluindo suas atualizações. Por enquanto, retorna dados mockados.
 * @param _projectName O nome do projeto para o qual se deseja obter as informações. Por enquanto, esse parâmetro é ignorado, e os dados retornados são mockados. 
 * @returns Um objeto contendo as informações do projeto e suas atualizações. Por enquanto, os dados retornados são mockados.
 */
export function useGamuxProject( _projectName: string): UseGamuxProjectReturn {
    const [project, setProject] = useState<GamuxProject | null>(null)

    useEffect(() => {
        setProject(
            new GamuxProject(
                "No Players Online",
                "https://img.itch.zone/aW1nLzE1NjE4MTE3LmdpZg==/original/pg72%2Bq.gif", 
                ["https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2701800/ss_5409002134724af182e65dc17d99263fa48f0185.1920x1080.jpg?t=1768201898", "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2701800/ss_c5866e19e30ba91a7f096ab1b937777ab07bed46.1920x1080.jpg?t=1768201898"],
                "",
                ["Em Progresso"],
                new User("Adam Pype", "", ""),
                100,
                new Date(),
                new Date(),
                new GamuxProjectPageInfo (
                    "No Players Online é um jogo de terror lançado no Itch.io, um site para jogos independentes, e no Steam. Foi criado pelos desenvolvedores de jogos belgas Adam Pype e Tibau Van den Broeck, e pelo designer de som alemão Viktor Kraus, em novembro de 2025.",
                    "https://img.itch.zone/aW1nLzE1NjE4MTE3LmdpZg==/original/pg72%2Bq.gif",
                    {"Itch.io": "https://papercookies.itch.io/no-players-online"},
                ),
                [new User("Adam Pype", "", ""), new User("Adam Pype", "", ""), new User("Adam Pype", "", "")]
            )
        )
    }, [])

    return { project, setProject }
}
