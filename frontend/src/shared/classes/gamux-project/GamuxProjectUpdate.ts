import type GamuxProject from "./GamuxProject"

class GamuxProjectUpdate {
    title: string
    gamux_project: GamuxProject
    description: string
    created_at: Date

    constructor(title: string, gamux_project: GamuxProject, description: string, created_at: Date) {
        this.title = title
        this.gamux_project = gamux_project
        this.description = description
        this.created_at = created_at
    }
}

export default GamuxProjectUpdate;