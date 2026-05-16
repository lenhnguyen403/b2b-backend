import './Main.css'
import {Outlet} from "react-router-dom";

const Main = () => {

    return (
        <main className='mt-38 p-8'>
            <Outlet/>
        </main>
    )
}

export default Main