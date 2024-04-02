import React from "react";
import "./style.css";
import AddBus from "../BusComponents/AddBus"

const HomeStyle = () => {
  return (
    <div className="style">
      <img
        alt="bus-bg"
        src="https://media.istockphoto.com/id/614316294/photo/white-bus-driving-along-the-asphalt-road-at-sunset.jpg?s=2048x2048&w=is&k=20&c=BthQy1K5adD6P895I6XImpi2ETf3V_nyhWVt0HtswmA="
      ></img>
      <div className="style-text">
        <h1>Your Journey Your Story</h1>
        <p>Choose Your Favorite Destination</p>
        <a href="/">Travel Plan</a>
      </div>

      <div className="bus-search dropdown">
        <div className="dropdown-btn"></div>
        <AddBus/>
      </div>
    </div>
  );
};

export default HomeStyle;
