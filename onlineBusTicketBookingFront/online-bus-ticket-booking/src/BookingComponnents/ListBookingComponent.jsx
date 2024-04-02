import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { getAllBookings } from "../services/Booking";

const ListBookingComponent = () => {
  const [bookings, setBookings] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listBookings();
  }, []);

  const listBookings = async () => {
    try {
      const response = await getAllBookings();
      console.log(bookings);
      setBookings(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="container">
      <h2 className="text-center">List of Bookings</h2>
      <button className="btn btn-primary mb-2">Add Booking</button>
      <div>
        <table className="table table-bordered table-striped">
          <thead>
            <tr>
              <th>BookingId</th>
              <th>Booking Date</th>
              <th>Bus Name</th>
              <th>Fee</th>
              <th>departureDate</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {bookings.map((booking) => (
              <tr key={booking.id}>
                <td>{booking.bookingId}</td>
                <td>{booking.bookingDate}</td>
                <td>{booking.busName}</td>
                <td>{booking.fee}</td>
                <td>{booking.departureDate}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListBookingComponent;
