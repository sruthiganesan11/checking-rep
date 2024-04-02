import React, { Component } from "react";
import { Link } from "react-router-dom";
import { MenuItems } from "../Passengercomponents/MenuItem";
import "./NavBar.css";

const URL = "http://localhost:3000";

class Header extends Component {
  state = { clicked: false };

  handleClick = () => {
    this.setState({ clicked: !this.state.clicked });
  };
  render() {
    return (
      <div>
        <nav className="NavbarItems">
          <h1 className="navbar-logo">JOYFUL JOURNEY</h1>

          <div className="menu-icons" onClick={this.handleClick}>
            <i
              className={this.state.clicked ? "fas fa-times" : "fa fa-bars"}
            ></i>
          </div>

          <ul className={this.state.clicked ? "nav-menu active" : "nav-menu"}>
            {MenuItems.map((item, index) => {
              return (
                <li key={index}>
                  <Link className={item.cName} to={item.url}>
                    <i className={item.icon}></i>
                    {item.title}
                  </Link>
                </li>
              );
            })}
          </ul>
        </nav>
      </div>
    );
  }
}

export default Header;
