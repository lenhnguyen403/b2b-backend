import {api} from "../utils/api.js";

export const register = async (formData) => {
    return api.post('/auth/register', formData)
}

export const login = async (formData) => {
    return api.post('/auth/login', formData)
}

export const logout = async () => {
    return api.post('/auth/logout')
}