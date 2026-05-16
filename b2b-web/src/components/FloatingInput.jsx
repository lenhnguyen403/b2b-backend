const FloatingInput = ({
                           type,
                           id,
                           value,
                           onChange,
                           label
                       }) => {

    return (
        <div className="form-group mb-5">
            <div className='relative border border-gray-300 bg-gray-100 rounded-md
                            transition-all focus:border-blue-400 focus:bg-white'>
                <input
                    className='peer w-full p-2.5 pt-4 outline-none focus:placeholder:text-xs'
                    type={type}
                    id={id}
                    name={id}
                    value={value}
                    onChange={onChange}
                    placeholder=" "
                    required
                />

                <label
                    htmlFor={id}
                    className='absolute left-2.5 top-1/2 -translate-y-1/2
                    text-gray-500 transition-all duration-250 pointer-events-none
                    peer-focus:top-3 peer-focus:text-xs
                    peer-valid:top-3 peer-valid:text-xs'
                >
                    {label}
                </label>
            </div>
        </div>
    )
}

export default FloatingInput