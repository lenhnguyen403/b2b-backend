import ToastMessage from "../messages/ToastMessage.jsx";
import {register} from "../services/auth.service.js";
import {useAuthForm} from "../hooks/useAuthForm.jsx";
import {Link} from "react-router-dom";
import {FaArrowRight} from "react-icons/fa6";
import RegisterForm from "../components/RegisterForm.jsx";
import AuthSidebar from "../components/AuthSidebar.jsx";

const Register = ({registerType}) => {

    const {formData, handleChange, loading, setLoading, navigate} = useAuthForm({
        initialValues: {
            fullName: '',
            email: '',
            password: '',
            confirmPassword: ''
        }
    })

    const isBuyer = registerType === 'BUYER'

    // Kiểm tra form valid
    const isFormValid = formData.fullName &&
        formData.email &&
        formData.password &&
        formData.confirmPassword
    // && formData.password === formData.confirmPassword;

    const handleRegister = async (e) => {
        e.preventDefault()

        const request = {
            ...formData,
            registerType
        }

        try {
            setLoading(true)

            const response = await register(request)
            navigate("/verify-otp")

            // console.log(response)

            if (response.status === 201) {
                ToastMessage.success()
            } else {
                console.log("Có lỗi xảy ra khi đăng ký tài khoản")
            }
        } catch (error) {
            console.log(error.response)
            ToastMessage.error(error)
        } finally {
            setLoading(false)
        }
    }

    return (
        <>
            {isBuyer ? (
                // Nguoi mua
                <div className='min-h-screen grid grid-cols-2'>
                    <AuthSidebar isBuyer={true} customClass='register-bg-image p-10 bg-no-repeat bg-cover bg-center'/>
                    <div className='p-5 relative bg-gray-100'>
                        <p className='float-right inline-flex items-center gap-1.5'>
                            <FaArrowRight/>
                            <span>
                                Trở thành<Link
                                className='font-semibold text-blue-800'
                                to={'/dang-ky-nguoi-ban'}> người bán</Link>?
                            </span>
                        </p>
                        <div
                            className='register-page absolute top-1/2 left-1/2 -translate-1/2
                    min-w-100 bg-white shadow-lg p-4 rounded-lg '>
                            <h2 className='text-center uppercase font-bold text-blue-800 text-lg mb-5'>
                                Đăng ký
                            </h2>
                            <RegisterForm
                                formData={formData}
                                handleChange={handleChange}
                                handleRegister={handleRegister}
                                loading={loading}
                                isFormValid={isFormValid}
                            />
                        </div>
                    </div>
                </div>
            ) : (
                // Nguoi ban
                <div className='min-h-screen bg-gray-100 relative'>
                    <div
                        className='absolute top-1/2 left-1/2 -translate-1/2 min-w-[70%] bg-white p-5 rounded-lg shadow-lg grid grid-cols-2'>
                        <AuthSidebar isBuyer={false}
                                     customClass='relative register-bg-image bg-no-repeat bg-center rounded-lg bg-cover p-5 text-wrap'/>

                        <div className='px-7.5 py-3 flex-1'>
                            <h2 className='text-center uppercase font-bold text-blue-800 text-lg mb-5'>
                                Đăng ký
                            </h2>
                            <RegisterForm
                                formData={formData}
                                handleChange={handleChange}
                                handleRegister={handleRegister}
                                loading={loading}
                                isFormValid={isFormValid}
                            />
                        </div>
                    </div>
                </div>
            )}
        </>
    )
}

export default Register