import { useGamuxProjectComments } from "@/features/gamux-project/hooks/useGamuxProjectComments";
import type { GamuxProjectCommentData } from "@/features/gamux-project/types/GamuxProjectCommentData";
import type { GamuxProjectData } from "@/features/gamux-project/types/GamuxProjectData";

interface CommentWrapperData {
    comments: GamuxProjectCommentData[]
}

export function getCommentWrapperData(project: GamuxProjectData): CommentWrapperData {
    const { comments } = useGamuxProjectComments(project)
    return { comments }
}