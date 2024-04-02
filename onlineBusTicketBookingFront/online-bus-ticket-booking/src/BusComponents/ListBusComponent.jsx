import React, { useEffect, useState } from "react";
import { getAllBuses } from "../services/Bus";

const ListBusComponent = () => {
  const [buses, setBuses] = useState([]);

  useEffect(() => {
    listBuses();
  }, []);

  const listBuses = async () => {
    try {
      const response = await getAllBuses();
      console.log(buses);
      setBuses(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="container">
      <h2 className="text-center">List of Buses</h2>
      <button className="btn btn-primary mb-2">Add Booking</button>
      <div>
        <table className="table table-bordered table-striped">
          <thead>
            <tr>
              <th>busName</th>
              <th>departureDate</th>
              <th>fromLocation</th>
              <th>toLocation</th>
              <th>price</th>
              <th>seats</th>
              <th>availableSeats</th>
            </tr>
          </thead>
          <tbody>
            {buses.map((bus) => (
              <tr key={bus.id}>
                <td>{bus.busName}</td>
                <td>{bus.departureDate}</td>
                <td>{bus.fromLocation}</td>
                <td>{bus.toLocation}</td>
                <td>{bus.price}</td>
                <td>{bus.seats}</td>
                <td>{bus.availableSeats}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListBusComponent;
