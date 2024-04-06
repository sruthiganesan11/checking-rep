import React from 'react'
import { Link } from 'react-router-dom';
import "./style.css"

const NavBar = () => {
    const URL = "http://localhost:3000";
    return (
      <div>
        <header>
          <nav className="navbar navbar-expand-md navbar-dark bg-dark">
            <a href={URL} className="navbar-brand">
              Employee Management
            </a>
            <div>
                <button><Link className='login' to={"/login"}>Login</Link></button>
            </div>
            <div>
                <button><Link className='register' to={"/register"}>Register</Link></button>
            </div>
          </nav>
        </header>
      
      </div>
  )
}

export default NavBar