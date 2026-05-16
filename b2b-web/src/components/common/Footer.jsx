import {Logo} from "./Logo.jsx";
import './Footer.css'
import {Link} from "react-router-dom";
import {FaPhoneAlt} from "react-icons/fa";
import {IoIosMail} from "react-icons/io";
import {FaLocationDot} from "react-icons/fa6";
import {footerData} from "../../data/index.js";

const Footer = () => {
    return (
        <footer className='text-center text-lg p-5 md:px-7.5 bg-linear-to-b from-gray-100 to-gray-300'>
            <div className='mb-5 grid grid-cols-4'>
                <div className='text-left'>
                    <Link to={'/'}>
                        <Logo className={"md:max-w-50 md:max-h-15"}/>
                    </Link>
                    <ul className='mt-2'>
                        <li>
                            <Link to={'/'} className='text-sm inline-flex items-center gap-2 hover:text-blue-700'>
                                <IoIosMail/>
                                b2badmin@gmail.com
                            </Link>
                        </li>
                        <li>
                            <Link to={'/'} className='text-sm inline-flex items-center gap-2 hover:text-blue-700'>
                                <FaPhoneAlt/>
                                +84368248952
                            </Link>
                        </li>
                        <li>
                            <Link to={'/'} className='text-sm inline-flex items-center gap-2 hover:text-blue-700'>
                                <FaLocationDot/>
                                Cau Giay, Hanoi, Vietnam
                            </Link>
                        </li>
                    </ul>
                </div>

                {footerData.map((item, index) => (
                    <div key={index} className='text-left'>
                        <h2 className='relative footer-heading font-bold uppercase'>{item.heading}</h2>
                        <ul>
                            {item.subHeading.map((subItem, subIndex) => (
                                <li key={subIndex}>
                                    <Link to={`/${subItem.linkTo}`}
                                          className='text-sm hover:ml-1 transition-all hover:text-blue-800'>
                                        {subItem.title}
                                    </Link>
                                </li>
                            ))}
                        </ul>
                    </div>
                ))}
            </div>
            <hr className='border-gray-400'/>
            <div className='mt-5'>© 2026 Bản quyền thuộc về
                <a href='https://gitlab.com/lenhnguyen403/backend-b2b' target={'_blank'}
                   className='font-semibold italic'> lenhnguyen403</a>
            </div>
        </footer>
    )
}

export default Footer