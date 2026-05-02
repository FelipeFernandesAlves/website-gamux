class GamuxProjectPageInfo {
    description: string
    banner: string
    external_links: Record<string, string>

    bg_color?: string
    bg2_color?: string
    text_color?: string
    link_color?: string
    heading_color?: string

    constructor(description: string = "", banner: string = "", external_links: Record<string, string> = {}, bg_color: string = "#000", bg2_color: string = "#000", text_color: string = "#f8f0fb", link_color: string = "#FBD87F", heading_color: string = "#A411CD") {
        this.description = description
        this.banner = banner
        this.external_links = external_links
        this.bg_color = bg_color
        this.bg2_color = bg2_color
        this.text_color = text_color
        this.link_color = link_color
        this.heading_color = heading_color
    }
}

export default GamuxProjectPageInfo;