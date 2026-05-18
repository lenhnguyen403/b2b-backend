import {useRef, useState} from "react";

const Otp = () => {
    const OTP_LENGTH = 6;
    const [otp, setOtp] = useState(new Array(OTP_LENGTH).fill(""));
    const inputRefs = useRef()

    const handleVerifyOtp = () => {

    }

    return (
        <div className='bg-blue-100 flex justify-center items-center h-screen'>
            <div className='bg-white text-center max-w-[400px] rounded-lg p-7 shadow-2xl'>
                {/* Icon */}
                <div className="flex justify-center mb-5">
                    <div className="w-24 h-24 rounded-full border-4 border-blue-500 flex items-center justify-center relative">
                        <div className="w-16 h-16 rounded-full border-4 border-blue-400 flex items-center justify-center">
                            <span className="text-blue-500 font-bold text-sm">
                                OTP
                            </span>
                        </div>
                    </div>
                </div>

                {/* Title */}
                <h2 className='font-bold text-lg mb-3'>Verify OTP</h2>

                <p className="text-sm text-gray-500 mb-6">
                    Hãy nhập mã gồm 6 ký tự được gửi tới
                    <br />
                    <span className="font-semibold text-gray-700">
                        user@email.com
                    </span>
                </p>

                {/* OTP Inputs */}
                <form>
                    <div className='form-group grid grid-cols-6 gap-4'>
                        <input type="text" maxLength='1' className='p-2.5 border border-gray-300 focus:border-blue-300 outline-none rounded text-center text-xl font-bold transition-all' />
                        <input type="text" maxLength='1' className='p-2.5 border border-gray-300 focus:border-blue-300 outline-none rounded text-center text-xl font-bold transition-all' />
                        <input type="text" maxLength='1' className='p-2.5 border border-gray-300 focus:border-blue-300 outline-none rounded text-center text-xl font-bold transition-all' />
                        <input type="text" maxLength='1' className='p-2.5 border border-gray-300 focus:border-blue-300 outline-none rounded text-center text-xl font-bold transition-all' />
                        <input type="text" maxLength='1' className='p-2.5 border border-gray-300 focus:border-blue-300 outline-none rounded text-center text-xl font-bold transition-all' />
                        <input type="text" maxLength='1' className='p-2.5 border border-gray-300 focus:border-blue-300 outline-none rounded text-center text-xl font-bold transition-all' />
                    </div>
                </form>
                <p className='text-sm text-gray-500 my-4'>
                    Không nhận được mã?{" "}
                    <button className='text-blue-500 font-semibold hover:underline'>
                        Resend OTP
                    </button>
                </p>
                <button type='submit'
                        className='text-white text-sm bg-blue-600 hover:bg-blue-700 cursor-pointer transition-all p-3 rounded-lg w-full'
                        disabled=''
                        onClick={handleVerifyOtp}>
                    Verify OTP
                </button>
            </div>
        </div>
    )
}

export default Otp