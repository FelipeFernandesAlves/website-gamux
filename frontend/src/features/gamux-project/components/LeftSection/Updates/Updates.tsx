import Button from "@shared/components/Button"
import { H3, H4, H5 } from "@shared/components/typography/Heading"
import { formatStringName } from "@/lib/utils"
import type GamuxProjectUpdateData from "@/features/gamux-project/types/GamuxProjectUpdateData"

export function Updates({ updates }: { updates: GamuxProjectUpdateData[] }) {
    if (updates.length <= 0)
        return

    return(
        <div>
            <H3 className="text-(--h)">Atualizações</H3>
            <div className="flex flex-col gap-4">
                <div className="flex flex-col gap-2">
                    {
                        updates.map((update) => {
                            return (
                                <div className="flex items-center gap-2">
                                    <H4 key={formatStringName(update.title)}>- <a href="#" className="text-(--link) hover:underline">{update.title}</a> <H5>{new Date(update.createdAt).toDateString()}</H5></H4>
                                </div>
                            )
                        })
                    }
                </div>
                <Button className="w-30 text-lg">Ver Mais</Button>
            </div>
        </div>
    )
}