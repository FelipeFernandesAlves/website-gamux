import { useEffect, useState } from "react";
import type GamuxProject from "../../classes/gamux-project/GamuxProject";
import { GamuxProjectComment } from "../../classes/gamux-project/GamuxProjectComment";
import User from "../../classes/user/User";

interface UseGamuxProjectCommentsReturn {
    comments: GamuxProjectComment[],
    setComments: React.Dispatch<React.SetStateAction<GamuxProjectComment[]>>
}

export function useGamuxProjectComments(project: GamuxProject): UseGamuxProjectCommentsReturn {
    const [comments, setComments] = useState<GamuxProjectComment[]>([])   

    useEffect(() => {
        if (!project) return

        setComments([
            new GamuxProjectComment(new User("Usuário 1", "", ""), "Comentário 1", new Date()),
            new GamuxProjectComment(new User("Usuário 2", "", ""), "Comentário 2", new Date()),
            new GamuxProjectComment(new User("Usuário 3", "", ""), "Comentário 3", new Date())
        ])
    }, [project])

    return { comments, setComments }
}