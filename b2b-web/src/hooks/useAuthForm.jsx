import {useState} from "react";
import {useNavigate} from "react-router-dom";

export const useAuthForm = ({initialValues}) => {
    const navigate = useNavigate()
    const [formData, setFormData] = useState(initialValues);
    const [loading, setLoading] = useState(false)
    const [error, setError] = useState("");

    const handleChange = (e) => {
        const {name, value} = e.target;

        setFormData((prev) => ({
            ...prev,
            [name]: value
        }));
    }

    const resetForm = () => {
        setFormData(initialValues)
    }

    return {
        formData, setFormData,
        loading, setLoading,
        error,
        handleChange,
        resetForm,
        navigate
    }
}