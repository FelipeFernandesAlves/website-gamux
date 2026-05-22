export default interface GamuxProjectPageData {
    description: string
    banner: string
    external_links: Record<string, string>
    screenshots: string[]

    bg_color?: string
    bg2_color?: string
    text_color?: string
    link_color?: string
    heading_color?: string
}