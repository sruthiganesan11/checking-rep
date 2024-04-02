import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { getAllPassengers } from "../services/Passenger";

const ListPassengerComponent = () => {
  const [passengers, setPassenger] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listPassengers();
  }, []);

  const listPassengers = () => {
    try {
      const response = getAllPassengers();
      setPassenger(response.data);
      setPassenger(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const addNewPassenger = async();
  return <div>ListPassengerComponent</div>;
};

export default ListPassengerComponent;
