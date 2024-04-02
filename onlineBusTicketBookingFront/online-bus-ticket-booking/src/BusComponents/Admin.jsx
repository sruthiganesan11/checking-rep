import React from "react";
import "./AddBus";
import { addBus } from "../services/Bus";
import { useNavigate } from "react-router";

const Admin = () => {
  function savedBus(e) {
    e.preventDefault();

    const navigate = useNavigate();

    const bus = {
      busName,
      departureDate,
      fromLocation,
      toLocation,
      price,
      seats,
      availableSeats,
    };
    console.log(bus);

    addBus(bus).then((response) => {
      console.log(response.data);
      navigate("/listbus");
    });
  }
  <br />;

  return (
    <div>
      <br />
      <br />
      <br />
      <br />
      <br />
      <h1>Admin</h1>
    </div>
  );
};

export default Admin;
