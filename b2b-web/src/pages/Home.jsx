import {Link} from "react-router-dom";
import {FaArrowRight} from "react-icons/fa6";

const Home = () => {

    return (
        <>
            <section>
                <div className='flex flex-wrap gap-5'>
                    <div className='max-w-max bg-white p-4'>
                        <ul className=''>
                            <li>
                                <Link className='hover:bg-gray-200 flex items-center justify-between gap-4'
                                      to={'/'}>
                                    Category Category
                                    <span><FaArrowRight/></span>
                                </Link>
                            </li>
                            <li>
                                <Link className='hover:bg-gray-200 flex items-center justify-between gap-4'
                                      to={'/'}>
                                    Category
                                    <span><FaArrowRight/></span>
                                </Link>
                            </li>
                        </ul>
                    </div>
                    <div className='flex-1'>
                        <img src='https://www.capgemini.com/wp-content/uploads/2025/02/B2B-in-Telco-web-banner.jpg'
                             alt=''/>
                    </div>
                    <div className='max-w-[350px] flex flex-col gap-5'>
                        <div>
                            <img
                                src='https://sika.scene7.com/is/image/sikacs/glo-search-fast-order-delivery-b2b-eshop-banner-01551568:16-9?wid=1248&hei=702&fit=crop%2C1'
                                alt=''/>
                        </div>
                        <div>
                            <img src='https://www.payoneer.com/wp-content/uploads/ebay-guide-banner.png.webp'
                                 alt=''/>
                        </div>
                    </div>
                </div>
            </section>

            <section className='my-7.5'>
                <div className='flex items-center justify-between'>
                    <h2 className='text-2xl uppercase font-semibold'>Category</h2>
                    <hr className='border border-gray-400 w-[70%]'/>
                    <Link to={'/'}
                          className='bg-transparent hover:bg-linear-to-br to-blue-200 from-gray-300 px-3 py-1.5 rounded-4xl'>Xem
                        thêm</Link>
                </div>
            </section>

            <section className='my-7.5'>
                <div className='flex items-center justify-between'>
                    <h2 className='text-2xl uppercase font-semibold'>Category</h2>
                    <hr className='border border-gray-400 w-[70%]'/>
                    <Link to={'/'}
                          className='bg-transparent hover:bg-linear-to-br to-blue-200 from-gray-300 px-3 py-1.5 rounded-4xl'>Xem
                        thêm</Link>
                </div>
            </section>
        </>
    )
}

export default Home