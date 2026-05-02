import { getLandingData } from "./LandingPage.viewModel.tsx";
import {H1, H2 } from "@shared/components/typography/Heading.tsx";
import Title from "@shared/components/typography/Title.tsx";
import Paragraph from "@shared/components/typography/Paragraph.tsx";
import Button from "@shared/components/Button/index.tsx";
import LandingSection from "./components/LandingSection.tsx";
import ProjectCard from "./components/gamux-project/GamuxProjectCard.tsx";
import GamuxEventCard from "./components/gamux-event/GamuxEventCard.tsx";

import { CodeBracketIcon, StarIcon } from "@heroicons/react/24/solid";
import Gamuto from "@assets/GamutoHero.svg?react";
import Gamermuto from "@assets/Gamermuto.svg?react";

function LandingPage() {
    const { events, projects } = getLandingData()

    return (
        <div className="flex flex-col">
            {/* Hero */}
            <div className="-bg-linear-120 max-md:-bg-linear-0 from-primary via-hero-from to-hero-to h-svh w-svw overflow-hidden flex flex-col justify-center items-center relative">
                <div className="flex flex-col justify-center items-center w-full gap-5 z-10 pb-[10em]">
                    <div className="flex flex-col justify-center items-center w-full">
                        <Title>GAMUX</Title>
                        <H2>Gamedev</H2>
                    </div>
                    <a href="https://linktr.ee/gamuxunicamp"><Button className="w-36 h-13">Linktree</Button></a>
                </div>
                <Gamuto className="absolute bottom-0 h-[23em]" />
            </div>

            {/* Sobre nós */}
            <div className="text-secondary flex items-center justify-center gap-10 p-15 max-md:px-5">
                <Gamermuto className="max-md:hidden" />
                <div className="flex flex-col max-md:items-center gap-7">
                    <div className="flex flex-col justify-start w-180 max-md:w-full gap-2">
                        <H1 className="text-left max-md:text-center">Quem <span className="text-primary">Somos</span></H1>
                        <Paragraph className="text-left max-md:text-center">
                            O Gamux é um grupo de pesquisa e desenvolvimento de jogos organizado por estudantes, com sede na Unicamp. Nosso objetivo é prover suporte à  comunidade de desenvolvedores e à cultura de jogos nas universidades da  região de Campinas, participando de projetos, realizando pesquisas e  sediando eventos relacionadas à área, como Game Jams.
                        </Paragraph>
                    </div>

                    <Button className="text-background w-35 h-11">Contato</Button>
                </div>
            </div>

            <div className="flex flex-col gap-15 max-md:gap-2 pb-10">
                {/* Eventos */}
                <div>
                    <LandingSection title="Eventos" icon={StarIcon} description="Últimos eventos organizados pela Gamux">
                        <div className="flex flex-row gap-3 overflow-x-auto whitespace-nowrap px-1 py-3">
                            {
                                events.map((event, i) => {
                                    return (
                                        <GamuxEventCard gamuxEvent={event} key={i} />
                                    )
                                })
                            }
                        </div>    
                    </LandingSection>
                </div>

                {/* Projetos */}
                <div>
                    <LandingSection title="Projetos" icon={CodeBracketIcon} description="Projetos desenvolvidos pelos membros da Gamux">
                        <div className="flex flex-row gap-3 overflow-x-auto whitespace-nowrap px-1 py-3">
                            {
                                projects.map((project, i) => {
                                    return (
                                        <ProjectCard project={project} key={i*2} />
                                    )
                                })
                            }
                        </div>
                    </LandingSection>
                </div>
            </div>
        </div>
    )
}

export default LandingPage