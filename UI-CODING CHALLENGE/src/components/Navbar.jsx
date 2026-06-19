import { Link } from "react-router-dom"

const Navbar = () => {

    return (
        <div>
            <nav className="navbar navbar-expand-lg bg-body-tertiary">
                <div className="container-fluid">
                    <a className="navbar-brand">ADMIN</a>

                    <div className="collapse navbar-collapse">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <Link to="/user-list" className="nav-link active" >User List</Link>
                            </li>
                        </ul>
                        <form className="d-flex">
                            <Link to="/add-user">
                            <button className="btn btn-outline-success" type="submit" >Add User</button>
                            </Link>
                            
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default Navbar