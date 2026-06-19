import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAll } from "../store/action/action";

function Paginated() {
    const dispatch = useDispatch();

    const data1 = useSelector((state) => state.data);

    const [currentPage, setCurrentPage] = useState(1);
    const [size] = useState(20);
    const [totalPages, setTotalPages] = useState(0);
    const [arry, setArry] = useState([]);

   
    useEffect(() => {
        dispatch(getAll(currentPage));
    }, [currentPage, dispatch]);

    
    useEffect(() => {
        if (data1.reduxdata?.info?.pages) {
            setTotalPages(data1.reduxdata.info.pages);
            setArry(Array.from({ length: data1.reduxdata.info.pages }));
        }
    }, [data1]);

    return (
        <div className="container mt-4">
            <h2 className="mb-4">Paginated Data using redux</h2>

            <table className="table table-bordered ">
                <thead className="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Status</th>
                        <th>Species</th>
                        <th>Origin</th>
                        <th>Location</th>
                    </tr>
                </thead>

                <tbody>
                    {data1.reduxdata?.results?.map((i, index) => (
                        <tr key={i.id}>
                            <td>{index + 1 + (currentPage - 1) * size}</td>
                            <td>{i.name}</td>
                            <td>{i.status}</td>
                            <td>{i.species}</td>
                            <td>{i.origin.name}</td>
                            <td>{i.location.name}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <nav>
                <ul className="pagination justify-content-center">

                  
                    <li className="page-item">
                        <button
                            className="page-link"
                            disabled={currentPage === 1}
                            onClick={() => setCurrentPage(currentPage - 1)}
                        >
                            Previous
                        </button>
                    </li>

                   
                    {arry.map((_, index) => (
                        <li
                            key={index}
                            className={`page-item ${
                                currentPage === index + 1 ? "active" : ""
                            }`}
                        >
                            <button
                                className="page-link"
                                onClick={() => setCurrentPage(index + 1)}
                            >
                                {index + 1}
                            </button>
                        </li>
                    ))}

               
                    <li className="page-item">
                        <button
                            className="page-link"
                            disabled={currentPage === totalPages}
                            onClick={() => setCurrentPage(currentPage + 1)}
                        >
                            Next
                        </button>
                    </li>

                </ul>
            </nav>
        </div>
    );
}

export default Paginated;