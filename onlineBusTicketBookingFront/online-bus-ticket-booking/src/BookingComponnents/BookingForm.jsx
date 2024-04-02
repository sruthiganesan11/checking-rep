import React, { useState } from "react";
import axios from "axios";


const BookingForm = () => {
  const [passengerId, setPassengerId] = useState("");

  const handleBooking = () => {
    if (!passengerId) {
      alert("Please select both a bus and a passenger.");
    }

    const bookingData = {
      passengerId: parseInt(passengerId), // Assuming passengerId is numeric
    };

    axios
      .post("http://localhost:8081/api/bookings", bookingData)
      .then((response) => {
        console.log("Booking successful:", response.data);
        // Optionally, reset form state after successful booking
        setPassengerId("");
      })
      .catch((error) => {
        console.error("Error booking bus:", error);
        alert("Error booking bus. Please try again later.");
      });
  };

  fetch("http://localhost:8081/api/passengers")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
    })
    .catch((error) => {
      console.error("Error fetching passenger: ", error);
    });
  return (
    <div>
      <select
        value={passengerId}
        onChange={(e) => setPassengerId(e.target.value)}
      >
        <option value="">Select Passenger</option>
        {/* map over fetched passenger data to generate options */}
      </select>
      <button onClick={handleBooking}>Book Bus</button>
    </div>
  );
};

export default BookingForm;
