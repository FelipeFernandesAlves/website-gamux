import type User from "../user/User";

export class GamuxProjectComment {
    user: User
    content: string
    createdAt: Date

    constructor(user: User, content: string, createdAt: Date) {
        this.user = user
        this.content = content
        this.createdAt = createdAt
    }
}