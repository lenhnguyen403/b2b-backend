import {FiSearch} from "react-icons/fi";
import {FaCartShopping} from "react-icons/fa6";
import {TbNotes} from "react-icons/tb";
import {Link} from "react-router-dom";
import {Logo} from "./Logo.jsx";

const Navbar = () => {
    return (
        <nav className='flex items-center justify-between p-5 md:px-7.5'>
            <div className='logo'>
                <Logo className={"md:max-w-50 md:max-h-12.5 cursor-pointer"}/>
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
                <Link to={'/quan-li-don-hang'} className='inline-flex items-center gap-1'>
                    <TbNotes/>
                    Quản lý đơn hàng
                </Link>
                <Link to={'/gio-hang'} className='inline-flex items-center gap-1'>
                    <FaCartShopping/>
                    Giỏ hàng
                </Link>
            </div>
        </nav>
    )
}

export default Navbar