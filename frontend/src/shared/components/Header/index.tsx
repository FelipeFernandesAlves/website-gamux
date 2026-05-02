import { Bars3Icon } from '@heroicons/react/24/solid'
import WhiteLogo from "../../../assets/WhiteLogo.svg?react"
import Button from '../Button'
import { cn } from '../../../lib/utils'
import { Link } from 'react-router-dom'

interface HeaderProps {
    fixedHeader: boolean
}

function Header({ fixedHeader }: HeaderProps) {
    let headerPosition = ""
    if (fixedHeader) {
        headerPosition = "fixed"
    }

    return (
        <header className={cn('w-full h-fit flex flex-row justify-between items-center px-[1em] z-50 backdrop-blur-sm', headerPosition)}>
            <div className='flex flex-row gap-[1em]'>
                <Bars3Icon className='w-10 max-md:w-8 fill-secondary' />
                <Link to={"/"}><WhiteLogo className="w-[3em] max-md:w-[2.2em]" /></Link>
            </div>
            <Button className='w-33.75 max-md:w-20 h-[1.8em] max-md:h-[1.7em]'>Entrar</Button>
        </header>
    )
}

export default Header