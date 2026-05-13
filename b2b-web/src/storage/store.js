// Save Token
const saveToken = (accessToken, refreshToken) => {
    localStorage.setItem('accessToken', accessToken)

    if (refreshToken) {
        localStorage.setItem('refreshToken', refreshToken)
    }
}

// Remove Token
const removeToken = () => {
    localStorage.removeItem('accessToken')
    localStorage.removeItem('refreshToken')
}

// Get Token
const getToken = () => {
    return localStorage.getItem('accessToken')
}

export {saveToken, removeToken, getToken}