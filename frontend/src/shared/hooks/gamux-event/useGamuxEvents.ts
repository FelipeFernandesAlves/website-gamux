import { useEffect, useState } from "react";
import GamuxEvent from "../../classes/gamux-event/GamuxEvent";

export function useGamuxEvents(_quantity: number = 5) {
    const [events, setEvents] = useState<GamuxEvent[]>([])

    useEffect(() => {
        setEvents([
            new GamuxEvent(
                "Intensivão Gamedev",
                "Venha aprender a criar seu jogo!",
                new Date(),
                new Date(),
                "14:00 - 21:00",
                "Sala 352 - IC3",
                "https://i.ibb.co/QFnQgcph/image-1776290591975-jpg.jpg",
                "public",
                "https://maps.app.goo.gl/PRfcxB5wf5vEf6Bm8",
                "#"
            ),
            new GamuxEvent(
                "Intensivão Gamedev",
                "Venha aprender a criar seu jogo!",
                new Date(),
                new Date(),
                "14:00 - 21:00",
                "Sala 352 - IC3",
                "https://i.ibb.co/QFnQgcph/image-1776290591975-jpg.jpg",
                "public"
            ),
        ])
    }, [])

    return {events, setEvents}
}