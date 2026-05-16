import Register from "../pages/Register.jsx";
import DefaultLayout from "../layouts/DefaultLayout.jsx";
import {Route, Routes} from "react-router-dom";
import Login from "../pages/Login.jsx";
import Home from "../pages/Home.jsx";

export const AppRouter = () => {
    return (
        <Routes>
            <Route path={'/'} element={<DefaultLayout/>}>
                <Route index element={<Home/>}/>
            </Route>
            <Route path={'/dang-ky'} element={<Register registerType={"BUYER"}/>}/>
            <Route path={'/dang-ky-nguoi-ban'} element={<Register registerType={"SELLER"}/>}/>
            <Route path={'/dang-nhap'} element={<Login/>}/>
        </Routes>
    )
}