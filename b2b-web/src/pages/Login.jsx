import {useAuthForm} from "../hooks/useAuthForm.jsx";
import {login} from "../services/auth.service.js";
import ToastMessage from "../messages/ToastMessage.jsx";
import {saveToken} from "../storage/store.js";
import {Link} from "react-router-dom";

const Login = () => {
    const {
        formData,
        handleChange,
        resetForm, loading,
        setLoading,
        navigate
    } = useAuthForm({
        initialValues: {
            email: '',
            password: '',
        }
    })

    const isFormValid =
        formData.email.trim() !== '' &&
        formData.password.trim() !== ''

    const handleLogin = async (e) => {
        e.preventDefault();

        const request = {
            ...formData,
        }

        try {
            setLoading(true)

            const response = await login(request)

            // console.log(response)

            if (response.status === 200) {
                ToastMessage.success("Đăng nhập thành công!")
                saveToken(response.data.accessToken, response.data.refreshToken)
                navigate("/")
            } else {
                console.log("Error login")
            }
        } catch (error) {
            console.log(error.response)
            ToastMessage.error(error)
        } finally {
            setLoading(false)
        }
    }

    return (
        <div className='login-page register-bg-image min-h-screen relative'>
            <div className='overlay fixed inset-0'>
                <div className='bg-white absolute top-1/2 left-1/2 -translate-1/2 rounded-md p-5 z-10 min-w-100'>
                    <h2 className={'text-center font-bold text-blue-800 uppercase mb-5'}>Đăng nhập</h2>
                    <form onSubmit={handleLogin}>
                        <div className="form-group mb-5 ">
                            <div className='relative border border-gray-300 bg-gray-100 rounded-md
                            transition-all focus:border-blue-400 focus:bg-white'>
                                <input
                                    className='peer w-full p-2.5 pt-4 outline-none focus:placeholder:text-xs'
                                    type="text" id="email" name="email"
                                    value={formData.email}
                                    onChange={handleChange}
                                    // placeholder="Email"
                                    required/>
                                <label className='absolute left-2.5 top-1/2 -translate-y-1/2 text-gray-500 transition-all duration-250 pointer-events-none
                                peer-focus:top-3 peer-focus:text-xs peer-valid:top-3 peer-valid:text-xs'
                                       htmlFor="email">Email</label>
                            </div>
                        </div>
                        <div className="form-group mb-5 ">
                            <div className='relative border border-gray-300 bg-gray-100 rounded-md
                            transition-all focus:border-blue-400 focus:bg-white'>
                                <input className='peer w-full p-2.5 pt-4 outline-none focus:placeholder:text-xs'
                                       type="password" id="password" name="password"
                                       value={formData.password}
                                       onChange={handleChange}
                                    // placeholder="Mật khẩu"
                                       required/>
                                <label className='absolute left-2.5 top-1/2 -translate-y-1/2 text-gray-500 transition-all duration-250 pointer-events-none
                                peer-focus:top-3 peer-focus:text-xs peer-valid:top-3 peer-valid:text-xs'
                                       htmlFor="password">Mật
                                    khẩu</label>
                            </div>
                        </div>
                        <div className='flex justify-between'>
                            <label htmlFor='remember'>
                                <input id='remember' type='checkbox'/> Ghi nhớ mật khẩu
                            </label>
                            <Link to={'/quen-mat-khau'} className='text-blue-700'>Quên mật khẩu?</Link>
                        </div>
                        <button
                            className='w-full bg-blue-600 p-3 rounded-lg my-5 cursor-pointer font-semibold text-white hover:bg-blue-700
                            disabled:bg-gray-400 disabled:cursor-not-allowed disabled:hover:bg-gray-400'
                            type='submit'
                            disabled={loading || !isFormValid}>
                            Đăng nhập
                        </button>

                        <p className='text-center'>Bạn chưa có tài khoản? <a href={'/dang-ky'}
                                                                             className='font-semibold text-blue-600'>Đăng
                            ký ngay</a></p>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default Login