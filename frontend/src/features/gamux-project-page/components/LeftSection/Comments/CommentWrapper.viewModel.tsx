import type { GamuxProjectComment } from "@/shared/classes/gamux-project/GamuxProjectComment";
import { useGamuxProjectComments } from "@/shared/hooks/gamux-project";
import type GamuxProject from "@shared/classes/gamux-project/GamuxProject";

interface CommentWrapperData {
    comments: GamuxProjectComment[]
}

export function getCommentWrapperData(project: GamuxProject): CommentWrapperData {
    const { comments } = useGamuxProjectComments(project)
    return { comments }
}