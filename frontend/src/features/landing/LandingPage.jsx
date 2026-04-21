import "./landing-page.css";
import GameProject from "../../classes/GameProject";
import ProjectPreview from "./components/ProjectPreview";
import Footer from "../../components/Footer";
import Header from "../../components/header";

const projects = [
    new GameProject("Gamutoware", "gamutoware.png", "https://moraguma.itch.io/gamutoware"),
    new GameProject("Candle Prick", "candle-prick.png", "https://moraguma.itch.io/candle-prick"),
    new GameProject("Jumongo", "jumongo.jpg", "https://www.facebook.com/play.jumongo")
]
function LandingPage() {

    return (
        <>
            <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=chevron_right" />

            <div id='fb-root'></div>
            {/* <video autoPlay loop id='bg_video'>
                <source src='img/content/cover_video.mp4' type='video/mp4'></source>
            </video> */}

            <div>
                <img src="img/gamux-bg.png" alt="purple background" id="bg_video" />
            </div>

            {
                <Header/>
            }

            <div id='cover'>
                <img src='./img/content/cover_logo.png' className='cover_logo'></img>
            </div>

            <div id='about'>
                <div className='whitespace'></div>

                <div id="about_text">
                    <h2><span className='title'>Mais que apenas programação</span></h2>

                    <p>O Gamux é um grupo de pesquisa e desenvolvimento de jogos organizado por estudantes, com sede na Unicamp. Nosso objetivo é prover suporte à comunidade de desenvolvedores e à cultura de jogos nas universidades da região de Campinas, participando de projetos, realizando pesquisas e sediando eventos relacionadas à área, como Game Jams. </p>
                </div>

                <div className='whitespace'></div>

                <div id="about_items">
                    <div>
                        <figure><img src='img/about/projetos.png'></img> </figure>
                        <h3>PROJETOS</h3>
                        <p>Realização de projetos relacionados ao desenvolvimento de jogos digitais.</p>
                    </div>

                    <div>
                        <figure><img src='img/about/pesquisas.png'></img> </figure>
                        <h3>PESQUISAS</h3>
                        <p>Relacionando novas tecnologias aplicadas a jogos e suas possíveis implicações para a sociedade.</p>
                    </div>

                    <div>
                        <figure><img src='img/about/eventos.png'></img></figure>
                        <h3>EVENTOS</h3>
                        <p>Organização de Game Jams, palestras e workshops relacionados ao desenvolvimento de jogos.</p>
                    </div>
                </div>
            </div>

            <div id='projects'>
                <div className='whitespace'></div>

                <h2>PROJETOS</h2>

                <div className='flex_container'>
                    {
                        projects.map(p => {
                            return <ProjectPreview project={p} />
                        })
                    }
                </div>

                <a href='https://gamux.itch.io/' target='_blank'>
                    <button className="dark">Lista Completa <span class="material-symbols-outlined">chevron_right</span></button>
                </a>
                <div className='whitespace'></div>
            </div>

            <div id='wiki' className="info_panel">
                <div className="info_item">
                    <h1>Já pensou em criar seu próprio jogo?</h1>
                    <p>Na nossa Wiki, temos vários tutorias para aqueles interessados no desenvolvimento de jogos!</p>
                    <p>Ah, e não é necessário saber programar!</p>

                    <a href='https://github.com/GamuxUnicamp/Gamux-Wiki/wiki' target='_blank'>
                        <button>Conheça a wiki</button>
                    </a>
                </div>

                <div>
                    <img src='img/content/processor.png' height='300px'></img>
                </div>
            </div>

            <div id='calendar' className="info_panel">
                <div>
                    <img src='img/content/controller.png' height='300px'></img>
                </div>

                <div className="info_item">
                    <h1>Quer se tornar um desenvolvedor?</h1>
                    <p>Então converse conosco!</p>
                    <p>Na Unicamp, temos reuniões todas as terça-feiras as 18h no Instituto de Computação.</p>
                </div>
            </div>

            <div id='media' className="info_panel">
                <div className="info_item">
                    <h1>Está interessado?</h1>
                    <p>Acompanhe nossas redes sociais!</p>
                    <p>Fique por dentro de palestras, eventos, game jams e muito mais.</p>
                    <a href='https://www.instagram.com/gamux.unicamp' target="_blank"><button>Gamux</button></a>
                </div>
                
                <div>
                    <img src="img/social/instagram-white-icon.svg" alt="instagram logo" width='250px' />
                </div>
            </div>
            <Footer />
        </>
    )
}

export default LandingPage