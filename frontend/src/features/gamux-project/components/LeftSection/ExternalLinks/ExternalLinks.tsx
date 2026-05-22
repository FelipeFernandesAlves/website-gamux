import { H3, H4 } from "@shared/components/typography/Heading"

export function ExternalLinks({ external_links }: { external_links: Record<string, string> }) {
    if (!external_links) {
        return
    }

    return(
        <div>
            <H3 className="text-(--h)">Links Externos</H3>
            <div>
                {external_links && Object.entries(external_links).map(([urlName, url]) => {
                    return (
                        <H4 key={urlName}>- <a href={url} className="text-(--link) hover:underline">{urlName}</a></H4>
                    )
                })}
            </div>
        </div>
    )
}