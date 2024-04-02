import React, { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import "../assets/style.css"

const Bookings = () => {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    fetchBookings();
  }, []);

  const fetchBookings = async () => {
    try {
      const response = await axios.get("http://localhost:8081/api/booking");
      const bookingsWithPassenger = await Promise.all(
        response.data.map(async (booking) => {
          const passengerResponse = await axios.get(
            "http://localhost:8081/api/passengers"
          );
          const passengerData = passengerResponse.data;
          console.log(passengerData + "passenger")
          return {...booking, passenger: passengerData };
        })
      );

      setBookings(bookingsWithPassenger);
      console.log("passenger 2")
    } catch (error) {
      console.error("Error fetching bookings:", error);
    }
  };

  return (
    <div className="container">
      <h2>Bookings</h2>
      <table className="table table-bordered table-striped">
        <thead>
          <tr>
            <th>BookingId</th>
            <th>Booking Date</th>
            <th>Bus Name</th>
            <th>Passenger Name</th>
            {/* Add more columns as needed */}
          </tr>
        </thead>
        <tbody>
          {bookings.map((booking) => (
            <tr key={booking.id}>
              <td>{booking.bookingId}</td>
              <td>{booking.bookingDate}</td>
              <td>{booking.busName}</td>
              <td>{booking.passenger.firstName}</td>
              {/* Add more cells for additional data */}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Bookings;
