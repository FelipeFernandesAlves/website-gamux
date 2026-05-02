import type GamuxProject from "@shared/classes/gamux-project/GamuxProject";
import Button from "@shared/components/Button";
import Input from "@shared/components/Input";
import { H3 } from "@shared/components/typography/Heading";

import { getCommentWrapperData } from "./CommentWrapper.viewModel";
import CommentCard from "./CommentCard";


interface ProjectCommentWrapperProps {
    project: GamuxProject
}

export function ProjectCommentWrapper({ project }: ProjectCommentWrapperProps) {
    const { comments } = getCommentWrapperData(project)

    return (
        <div className="flex flex-col gap-3.5">
            <H3 className="text-(--h)">Comentários</H3>
            <form className="flex flex-col gap-2">
                <Input className="w-[70%] max-md:w-full" placeholder="Escreva um Comentário legal!" />
                <Button className="w-fit px-4">Enviar</Button>
            </form>

            <div className="flex flex-col gap-4">
                {
                    comments.map((comment, index) => <CommentCard key={index} comment={comment} />)
                }
            </div>
        </div>
    )
}