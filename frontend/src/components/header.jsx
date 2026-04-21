import "./header.css"

function Header() {
    return (
        <div id='header'>
            <img id='header_logo' src='./img/header_logo.png'></img>
            <div className='nav_links'>
                <a href='#about'>Sobre</a>
                <a href='#projects'>Projetos</a>
                <a href='#wiki'>Wiki</a>
                <a href='#media'>Notícias</a>
            </div>
        </div>
    )
}

export default Header