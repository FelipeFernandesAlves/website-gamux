import type { GamuxProjectMemberData } from "./GamuxProjectMemberData"

export interface GamuxProjectData {
    id: string
    name: string
    slug: string
    desc: string
    logo: string
    tags: string[]
    genres: string[]
    status: string
    type: string
    likes: number
    teamMembers: GamuxProjectMemberData[]
    createdAt: string
    lastUpdated?: string
}