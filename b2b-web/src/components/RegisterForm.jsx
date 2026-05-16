import FloatingInput from "./FloatingInput.jsx";
import {Link} from "react-router-dom";

const RegisterForm = ({
                          formData,
                          handleChange,
                          handleRegister,
                          loading,
                          isFormValid,
                      }) => {

    return (
        <form onSubmit={handleRegister}>
            <FloatingInput
                id="fullName"
                type="text"
                name='fullName'
                label="Họ và tên"
                value={formData.fullName}
                onChange={handleChange}
            />

            <FloatingInput
                type="text"
                id='email'
                name='email'
                label='Email'
                value={formData.email}
                onChange={handleChange}
            />

            <FloatingInput
                type='password'
                id='password'
                name='password'
                label='Mật khẩu'
                value={formData.password}
                onChange={handleChange}
            />

            <FloatingInput
                type='password'
                id='confirmPassword'
                name='confirmPassword'
                label='Xác nhận mật khẩu'
                value={formData.confirmPassword}
                onChange={handleChange}
            />

            <button
                className='w-full bg-blue-600 p-3 rounded-lg my-5
                cursor-pointer font-semibold text-white
                hover:bg-blue-700
                disabled:bg-gray-400
                disabled:cursor-not-allowed'
                type="submit"
                disabled={loading || !isFormValid}
            >
                Đăng ký
            </button>

            <p className='text-center'>
                Bạn đã có tài khoản?
                <Link
                    to='/dang-nhap'
                    className='font-semibold text-blue-600 ml-1'
                >
                    Đăng nhập
                </Link>
            </p>
        </form>
    )
}

export default RegisterForm