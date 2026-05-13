import {Logo} from "./Logo.jsx";
import './Footer.css'

const Footer = () => {
    return (
        <footer className='text-center text-lg p-5 md:px-7.5 bg-gray-200'>
            <div className='mb-5 grid grid-cols-4'>
                <div className='text-left'>
                    <Logo className={"md:max-w-50 md:max-h-15 cursor-pointer"}/>
                    <ul>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                    </ul>
                </div>
                <div className='text-left'>
                    <h2 className='relative footer-heading font-bold uppercase'>Heading</h2>
                    <ul>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                    </ul>
                </div>
                <div className='text-left'>
                    <h2 className='relative footer-heading font-bold uppercase'>Heading</h2>
                    <ul>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                    </ul>
                </div>
                <div className='text-left'>
                    <h2 className='relative footer-heading font-bold uppercase'>Heading</h2>
                    <ul>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                        <li>Subheading</li>
                    </ul>
                </div>
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