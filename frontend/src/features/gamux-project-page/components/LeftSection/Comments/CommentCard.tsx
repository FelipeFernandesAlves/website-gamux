import { formatStringName } from "@/lib/utils";
import { BlankButton } from "@/shared/components/Button";
import Paragraph from "@/shared/components/typography/Paragraph";
import type { GamuxProjectComment } from "@shared/classes/gamux-project/GamuxProjectComment";
import { H3 } from "@shared/components/typography/Heading";

interface CommentCardProps {
    comment: GamuxProjectComment
}

function CommentCard({ comment }: CommentCardProps) {

    return (
        <div className="flex flex-col p-2">
            <div className="flex items-center gap-1.5">
                <div className="overflow-hidden w-6 h-6 rounded-lg">
                    <img className="w-100% object-cover" src="https://profiles.auckland.ac.nz/k-falloon/thumbnail" alt={`foto-de-perfil-${formatStringName(comment.user.name)}`} />
                </div>
                <H3 className="text-(--link)">{comment.user.name}</H3>
            </div>

            <div>
                <Paragraph className="text-left">{comment.content}</Paragraph>
            </div>

            <div className="flex gap-3">
                <BlankButton className="text-secondary text-sm underline">Responder</BlankButton>
                <BlankButton className="text-secondary text-sm underline">Reportar</BlankButton>
            </div>
        </div>
    )
}

export default CommentCard