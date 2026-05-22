import { useEffect, useState } from "react";
import User from "../../../shared/classes/user/User";
import type { GamuxProjectData } from "../types/GamuxProjectData";
import type { GamuxProjectCommentData } from "../types/GamuxProjectCommentData";

interface UseGamuxProjectCommentsReturn {
    comments: GamuxProjectCommentData[],
    setComments: React.Dispatch<React.SetStateAction<GamuxProjectCommentData[]>>
}

export function useGamuxProjectComments(project: GamuxProjectData): UseGamuxProjectCommentsReturn {
    const [comments, setComments] = useState<GamuxProjectCommentData[]>([])   

    useEffect(() => {
        if (!project) return

        setComments([
            {
                user: new User("Usuário 1", "", ""), 
                content: "Comentário 1", 
                createdAt: new Date().toDateString()
            },
        ])
    }, [project])

    return { comments, setComments }
}