import type User from "@/shared/classes/user/User";

export interface GamuxProjectCommentData {
    user: User
    content: string
    createdAt: string
}