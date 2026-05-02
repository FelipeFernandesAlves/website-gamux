import GamuxProjectPageInfo from "./GamuxProjectPageInfo"
import type User from "../user/User"

/**
 * Um projeto feito por um membro da Gamux.
 */
class GamuxProject {
    name: string
    logo: string
    screenshots?: string[]
    description: string
    tags: string[]
    teamLider: User
    teamMembers: User[]
    status: string
    genres: string[]
    type: string
    created_at: Date
    pageInfo: GamuxProjectPageInfo
    last_updated?: Date
    likes?: number    

    /**
    * @param {string} name - O nome do projeto.
    * @param {string} logo - O url do logo do projeto.
    * @param {string[]} screenshots - Uma lista de urls de imagens de captura de tela do projeto.
    * @param {string} description - Uma descrição curta do projeto.
    * @param {string[]} tags - Uma lista de tags relacionadas ao projeto.
    * @param {number} likes - O número de curtidas que o projeto tem.
    * @param {Date} created_at - A data de criação do projeto.
    * @param {Date} last_updated - A data da última atualização do projeto.
    * @param {GamuxProjectPageInfo} pageInfo - Informações específicas da página do projeto.
    */
    constructor(name: string, logo: string, screenshots: string[] | undefined, description: string, tags: string[], teamLider: User, likes: number = 0, created_at: Date, last_updated?: Date, pageInfo: GamuxProjectPageInfo = new GamuxProjectPageInfo(), teamMembers: User[] = [], status: string = "Em desenvolvimento", genres: string[] = [], type: string = "Jogo") {
        this.name = name
        this.logo = logo
        this.screenshots = screenshots
        this.description = description
        this.tags = tags
        this.likes = likes
        this.created_at = created_at
        this.last_updated = last_updated
        this.pageInfo = pageInfo
        this.teamLider = teamLider
        this.teamMembers = teamMembers
        this.status = status
        this.genres = genres
        this.type = type
    }
}

export default GamuxProject;