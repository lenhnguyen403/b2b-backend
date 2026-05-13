import ToastMessage from "../messages/ToastMessage.jsx";
import {register} from "../services/auth.service.js";
import {useAuthForm} from "../hooks/useAuthForm.jsx";

const Register = ({registerType}) => {
    const {formData, handleChange, resetForm, loading, setLoading, navigate} = useAuthForm({
        initialValues: {
            fullName: '',
            email: '',
            password: '',
            confirmPassword: ''
        }
    })

    const handleRegister = async (e) => {
        e.preventDefault()

        const request = {
            ...formData,
            registerType
        }

        try {
            setLoading(true)

            const response = await register(request)

            // console.log(response)

            if (response.status === 201) {
                ToastMessage.success("Đăng ký thành công!")
                navigate("/dang-nhap")
            } else {
                console.log("Error registering user")
            }
        } catch (error) {
            console.log(error.response)
            ToastMessage.error(error)
        } finally {
            setLoading(false)
        }
    }

    return (
        <div className='register-page'>
            <form onSubmit={handleRegister}>
                <div className="form-group">
                    <label htmlFor="fullName">Họ và tên</label>
                    <input type="text" id="fullName" name="fullName"
                           value={formData.fullName}
                           onChange={handleChange}
                        // placeholder="Họ và tên"
                           required/>
                </div>
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
                <div className="form-group">
                    <label htmlFor="confirmPassword">Xác nhận mật khẩu</label>
                    <input type="password" id="confirmPassword" name="confirmPassword"
                           value={formData.confirmPassword}
                           onChange={handleChange}
                        // placeholder="Xác nhận mật khẩu"
                           required/>
                </div>

                <button type="submit" disabled={loading}>Đăng ký</button>
            </form>
        </div>
    )
}

export default Register