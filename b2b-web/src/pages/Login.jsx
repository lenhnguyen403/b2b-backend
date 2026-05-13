import {useAuthForm} from "../hooks/useAuthForm.jsx";
import {login} from "../services/auth.service.js";
import ToastMessage from "../messages/ToastMessage.jsx";
import {saveToken} from "../storage/store.js";

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

    const handleLogin = async (e) => {
        e.preventDefault();

        const request = {
            ...formData,
        }

        try {
            setLoading(true)

            const response = await login(request)

            console.log(response)

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
        <div className='login-page'>
            <form onSubmit={handleLogin}>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input type="text" id="email" name="email"
                           value={formData.email}
                           onChange={handleChange}
                        // placeholder="Email"
                           required/>
                </div>
                <div className="form-group">
                    <label htmlFor="password">Mật khẩu</label>
                    <input type="password" id="password" name="password"
                           value={formData.password}
                           onChange={handleChange}
                        // placeholder="Mật khẩu"
                           required/>
                </div>
                <button type='submit' disabled={loading}>Đăng nhập</button>
            </form>
        </div>
    )
}

export default Login