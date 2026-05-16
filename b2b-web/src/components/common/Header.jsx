import {Link} from "react-router-dom";
import {getToken, removeToken} from "../../storage/store.js";
import './Header.css'
import {useEffect} from "react";
import {Logo} from "./Logo.jsx";
import {FiSearch} from "react-icons/fi";
import {FaCartShopping, FaRegHeart} from "react-icons/fa6";
import {TbNotes} from "react-icons/tb";

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
        <header className='fixed left-0 right-0 top-0 z-50'>
            <div
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
                                <li className='hover:bg-blue-50 cursor-pointer hover:font-semibold hover:text-blue-400 px-5 py-3'>
                                    <Link to={'/'}>Profile</Link>
                                </li>
                                <li className='hover:bg-blue-50 cursor-pointer hover:font-semibold hover:text-blue-400 px-5 py-3'>
                                    <Link to={'/'}>Đơn hàng của tôi</Link>
                                </li>
                                <li className='hover:bg-blue-50 cursor-pointer hover:font-semibold hover:text-blue-400 px-5 py-3'>
                                    <Link to={'/'}>Khuyến mãi</Link>
                                </li>
                                <hr className='border-gray-300'/>
                                <li className=' hover:bg-blue-50 cursor-pointer hover:font-semibold hover:text-blue-400 px-5 py-3'>
                                    <Link to={'/'} onClick={handleLogout}>Đăng xuất</Link>
                                </li>
                            </ul>
                        </div>
                    </div>
                )}
            </div>
            <nav className='bg-white flex items-center justify-between p-5 md:px-7.5 shadow-md'>
                <div className='logo'>
                    <Link to={'/'}>
                        <Logo className={"md:max-w-50 md:max-h-12.5"}/>
                    </Link>
                </div>
                <div className='search-form relative min-w-187.5'>
                    <input id='search' className='w-full h-full border border-gray-300 p-2 rounded-lg outline-none'
                           type='text'
                           placeholder='Tim kiếm sản phẩm...'/>
                    <span
                        className='absolute right-0 text-lg h-full w-10 bg-gray-200 hover:bg-gray-300
                    rounded-r-lg transition-all
                    inline-flex items-center justify-center cursor-pointer'>
                    <FiSearch/>
                </span>
                </div>
                <div className='cart-and-order inline-flex items-center gap-6'>
                    <Link to={'/yeu-thich'} className='inline-flex items-center gap-1 hover:text-blue-600'>
                        <FaRegHeart/>
                        Yêu thích
                    </Link>
                    <Link to={'/quan-li-don-hang'} className='inline-flex items-center gap-1 hover:text-blue-600'>
                        <TbNotes/>
                        Quản lý đơn hàng
                    </Link>
                    <Link to={'/gio-hang'} className='inline-flex items-center gap-1 hover:text-blue-600'>
                        <FaCartShopping/>
                        Giỏ hàng
                    </Link>
                </div>
            </nav>
        </header>
    )
}

export default Header