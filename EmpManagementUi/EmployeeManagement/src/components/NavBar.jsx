import React from "react";
import { Link } from "react-router-dom";
import "./style.css";
import { isUserLoggedIn, logout } from "../service/AuthService";
import { useNavigate } from "react-router-dom";

const NavBar = () => {
  const URL = "http://localhost:3000";

  const isAuth = isUserLoggedIn();

  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };
  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <a href={URL} className="navbar-brand">
            Employee Management
          </a>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav">
              {!isAuth && (
                <li className="nav-item">
                  <Link to="/login" className="nav-link">
                    Login
                  </Link>
                </li>
              )}
              {!isAuth && (
                <li className="nav-item">
                  <Link to="/register" className="nav-link">
                    Register
                  </Link>
                </li>
              )}
              {isAuth && (
                <li className="nav-item">
                  <Link to="/login" className="nav-link" onClick={handleLogout}>
                    Logout
                  </Link>
                </li>
              )}
            </ul>
          </div>
        </nav>
      </header>
    </div>
  );
};

export default NavBar;
