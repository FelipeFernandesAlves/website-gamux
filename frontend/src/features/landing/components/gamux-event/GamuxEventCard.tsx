import { CalendarDaysIcon, MapPinIcon, TicketIcon } from "@heroicons/react/16/solid"
import type GamuxEvent from "../../../../shared/classes/gamux-event/GamuxEvent"
import { H3, H4, H5 } from "../../../../shared/components/typography/Heading"
import { BlankButton } from "../../../../shared/components/Button"
import Card from "../Card"

interface GamuxInterfacePreviewProps {
    gamuxEvent: GamuxEvent
}

function GamuxEventCard({ gamuxEvent }: GamuxInterfacePreviewProps) {
    let registerButton = <></>
    if (gamuxEvent.registerLink) {
        // Set a timeout in mobile to animate
        function onRegisterButtonClick(event: React.MouseEvent<HTMLAnchorElement>) {
            if (!window.matchMedia("(max-width: 48rem)").matches)
                return
            
            event.preventDefault()
            const url: string = gamuxEvent.registerLink || ""
            setTimeout(() => {
                window.location.href = url
            }, 450)
        }

        registerButton = (
            <a href={`${gamuxEvent.registerLink}`} onClick={onRegisterButtonClick}>
                <BlankButton className="w-40 h-10 py-1 flex justify-center items-center bg-primary text-secondary overflow-hidden hover:scale-[1]">
                    <div className="w-8 flex justify-center items-center overflow-hidden transition-all duration-300 group-hover:w-full">
                        <TicketIcon className="w-6 fill-secondary" />
                    </div>
                    <H4 className="flex justify-center items-center transition-all duration-300 w-21 group-hover:w-0 group-hover:text-[0px]">Participar</H4>
                </BlankButton>
            </a>
        )
    }

    let location = <span>{gamuxEvent.location}</span>
    if (gamuxEvent.locationLink) {
        location = <a target="_blank" href={`${gamuxEvent.locationLink}`} className="underline">{gamuxEvent.location}</a>
    }

    return(
        <Card imgSrc={gamuxEvent.banner} imgAlt={`banner-${gamuxEvent.name}`}>
            <div className="flex flex-col p-3 gap-1 whitespace-break-spaces">
                <H3>{gamuxEvent.name}</H3>

                <div className="flex gap-1.5 items-center">
                    <CalendarDaysIcon className="w-6 fill-primary" />
                    <H5>{gamuxEvent.startDate.toDateString()} - {gamuxEvent.endDate.toDateString()} • {gamuxEvent.hours}</H5>
                </div>

                <div className="flex gap-1.5 items-center">
                    <MapPinIcon className="w-6 fill-primary" />
                    <H5>{location}</H5>
                </div>

                <div className="pt-2">
                    {registerButton}
                </div>
            </div>
        </Card>
    )
}

export default GamuxEventCard