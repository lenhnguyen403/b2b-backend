import axios from "axios";
import {getToken} from "../storage/store.js";

export const api = axios.create({
    baseURL: import.meta.env.VITE_BACKEND_URL,
    headers: {
        'Content-Type': 'application/json',
    }
})

api.interceptors.request.use(config => {
    const token = getToken()
    if (token) {
        config.headers.Authorization = `Bearer ${token}`
    }

    return config;
})

api.interceptors.response.use(
    (res) => res,
    (err) => {
        if (err.response?.status === 401) {
            localStorage.removeItem('accessToken')
            localStorage.removeItem('refreshToken');
            localStorage.removeItem('user');
            window.location.href = '/login';
        }

        return Promise.reject(err)
    })