import React from "react";

const NavBar = () => {
    const URL = "http://localhost:3000";
  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <a href={URL} className="navbar-brand">
            User Management
          </a>
          <div></div>
        </nav>
      </header>
    
    </div>
  );
};

export default NavBar;
