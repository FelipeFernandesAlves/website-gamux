import { Link } from "react-router-dom"
import CardTag from "./card-tag/CardTag"

interface PreviewProps {
    imgSrc: string
    imgAlt: string
    url?: string
    children?: React.ReactNode
    tags?: Array<string>
}

function Preview({ imgSrc, imgAlt, url, tags = [], children = "" }: PreviewProps) {
    return (
        <div className="
            w-115 max-md:w-80 h-fit rounded-[10px] shadow-lg shadow-primary/25 flex-none -bg-linear-90 from-primary/25 to-hero-from/25 border-2 border-primary/50 cursor-pointer overflow-hidden
            transition delay-75 duration-250 ease-in-out hover:-translate-y-2 hover:scale-[1.01] hover:shadow-primary/50
            ">
            <Link to={url || "#"}>
                <div className="w-full h-55 max-md:h-37 relative overflow-hidden">
                    {/* Tag Wrapper */}
                    <div className="flex absolute top-0 left-0 p-2 overflow-x-auto">
                        {
                            tags.map((tag) => {
                                return <CardTag tagName={tag} />
                            })
                        }
                    </div>

                    <img className="w-full h-full object-cover" src={imgSrc} alt={imgAlt} />
                </div>

                {children}
            </Link>
        </div>
    )
}

export default Preview