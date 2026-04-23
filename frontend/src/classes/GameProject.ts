/**
 * A project made by a member of Gamux.
 */

class GameProject {
    name: string
    logo: string
    external_link: string

    /**
    * @param {string} name - The projects name.
    * @param {string} logo - The relative path from src/assets/projects to the projects logo.
    * @param {string} external_link - A link to some external webpage with more information about the project.
    */
    constructor(name: string, logo: string, external_link: string) {
        this.name = name
        this.logo = logo
        this.external_link = external_link
    }
}

export default GameProject;