import {FaArrowLeftLong} from "react-icons/fa6";
import {Link} from "react-router-dom";

const AuthSidebar = ({isBuyer, customClass = ""}) => {
    const title = isBuyer
        ? "Đăng ký tài khoản người mua"
        : "Đăng ký tài khoản người bán";

    const description = isBuyer
        ? "Hãy đăng ký tài khoản để trải nghiệm các dịch vụ."
        : "Hãy đăng ký tài khoản để đăng các sản phẩm cần bán.";

    return (
        <div className={customClass}>
            <Link to='/' className='inline-flex gap-2 items-center hover:text-blue-700'>
                <span className='px-2.5 py-1 rounded bg-gray-400 text-white'>
                  <FaArrowLeftLong/>
                </span>
                Quay lại trang chủ
            </Link>
            <div className='mt-5'>
                <h2 className='font-bold text-2xl my-2'>{title}</h2>
                <p className='text-gray-500'>{description}</p>
            </div>
        </div>
    )
}

export default AuthSidebar;