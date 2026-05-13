import {Link} from "react-router-dom";
import {getToken, removeToken} from "../../storage/store.js";
import './Header.css'
import {useEffect} from "react";

const Header = () => {
    const token = getToken()

    const handleLogout = (e) => {
        e.preventDefault();

        removeToken()

        window.location.href = '/'
    }

    useEffect(() => {
        const avatar = document.querySelector('.avatar')
        const avatarDropDown = document.querySelector('.avatar-dropdown')

        if (!avatar || !avatarDropDown) return;

        const onDocumentClick = (e) => {
            // click ngoài dropdown + ngoài avatar => đóng
            if (
                !avatarDropDown.contains(e.target) &&
                !avatar.contains(e.target)
            ) {
                avatarDropDown.classList.remove('active');
            }
        };

        const onAvatarClick = (e) => {
            e.preventDefault();
            // click lại vào avatar => toggle
            avatarDropDown.classList.toggle('active');
        };

        document.addEventListener('click', onDocumentClick);
        avatar.addEventListener('click', onAvatarClick);

        return () => {
            document.removeEventListener('click', onDocumentClick);
            avatar.removeEventListener('click', onAvatarClick);
        };
    }, [])

    return (
        <header
            className='p-5 md:px-7.5 text-right bg-linear-to-br from-cyan-500 to-blue-500 font-semibold text-white'>
            {!token && (
                <>
                    <Link to='/dang-ky' className='mr-2'>Đăng ký</Link>
                    |
                    <Link to={'/dang-nhap'} className='ml-2'>Đăng nhập</Link>
                    <Link to={'/dang-ky-nguoi-ban'} className='mx-3'>Đăng ký Người bán</Link>

                </>
            )}
            {token && (
                <div className='flex items-center justify-end gap-5'>
                    <span>Le Van Duc</span>
                    <div className='relative'>
                        <img alt='' src='/avarta2.jpg'
                             className='avatar lg:max-w-10 lg:max-h-10 rounded-full cursor-pointer'/>
                        <ul className='avatar-dropdown absolute bg-white text-black font-medium md:min-w-62.5
                        text-left z-10 right-0 shadow-lg top-full'>
                            <li className='hover:bg-blue-50 cursor-pointer hover:font-semibold px-5 py-3'>
                                <Link to={'/'}>Profile</Link>
                            </li>
                            <li className='hover:bg-blue-50 cursor-pointer hover:font-semibold px-5 py-3'>
                                <Link to={'/'}>Đơn hàng của tôi</Link>
                            </li>
                            <li className='hover:bg-blue-50 cursor-pointer hover:font-semibold px-5 py-3'>
                                <Link to={'/'}>Khuyến mãi</Link>
                            </li>
                            <hr className='border-gray-300'/>
                            <li className=' hover:bg-blue-50 cursor-pointer hover:font-semibold px-5 py-3'>
                                <Link to={'/'} onClick={handleLogout}>Đăng xuất</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            )}
        </header>
    )
}

export default Header