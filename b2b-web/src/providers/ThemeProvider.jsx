import {ThemeContext} from "../contexts/ThemeContext.jsx";
import {useEffect, useState} from "react";

const ThemeProvider = ({children}) => {
    const [theme, setTheme] = useState(
        () => {
            const savedTheme = localStorage.getItem("theme");
            return savedTheme || 'dark';
        }
    );

    const toggleTheme = () => {
        setTheme(prev => prev === 'dark' ? 'light' : 'dark');
    }

    useEffect(() => {
        localStorage.setItem("theme", theme);
        document.documentElement.classList.toggle('light', theme === 'light');
    }, [theme])

    return (
        <ThemeContext.Provider value={{theme, toggleTheme}}>
            {children}
        </ThemeContext.Provider>
    )
}

export default ThemeProvider;