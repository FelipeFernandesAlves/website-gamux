import { H2, H3 } from "../../../shared/components/typography/Heading"

interface LandingSectionProps {
    icon: React.ElementType
    title: string
    description: string
    children?: React.ReactNode
}

function LandingSection({ icon: Icon, title, description, children="" }: LandingSectionProps) {
    return(
        <div>
            <div className="w-full px-15 max-md:p-5 flex flex-col gap-1">
                <div>
                    <div className="flex items-center gap-2">
                        <Icon className="w-9 max-md:w-8 stroke-1 stroke-primary fill-primary" />
                        <H2>{title}</H2>
                    </div>
                    <H3><span className="text-secondary/75">{description}</span></H3>
                </div>
                {children}
            </div>
        </div>
    )
}

export default LandingSection