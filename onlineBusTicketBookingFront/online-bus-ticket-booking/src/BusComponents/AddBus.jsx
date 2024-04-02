import React, { useState } from "react";
import { useNavigate } from "react-router";
import { addBus } from "../services/Bus";
import Swal from "sweetalert2";
import "./BusStyle.css";

const AddBus = () => {
  const navigate = useNavigate();
  const [busName, setbusName] = useState("");
  const [departureDate, setDoj] = useState("");
  const [fromLocation, setFrom] = useState("");
  const [toLocation, setTo] = useState("");
  const [price, setPrice] = useState("");
  const [seats, setSeats] = useState("");
  const [availableSeats, setAvailableSeats] = useState("");
  const [error, setError] = useState(false);

  const saveBus = async (e) => {
    e.preventDefault();

    const bus = {
      busName,
      departureDate,
      fromLocation,
      toLocation,
      price,
      seats,
      availableSeats,
    };

    if (busName === "") {
      setError(true);
      console.log(error);
    } else if (!departureDate) {
      setError(true);
      console.log(error);
    } else if (fromLocation === "") {
      setError(true);
      console.log(error);
    } else if (toLocation === "") {
      setError(true);
      console.log(error);
    } else if (price == 0) {
      setError(true);
      console.log(error);
    } else if (availableSeats == 0) {
      setError(true);
      console.log(error);
    } else {
      console.log(bus);
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Bus has been Saved",
        showConfirmButton: "false",
        timer: 1500,
      });
      console.log(bus);
      const response = await addBus(bus);
      console.log(response);
      navigate("/admin");
    }
  };
  return (
    <div className="container">
      <br />
      <br />
      <br />
      <br />
      <br />

      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h2 className="text-center">Add Bus</h2>
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Bus Name</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter the BusName"
                  name="busName1"
                  value={busName}
                  error={!!error}
                  onChange={(e) => setbusName(e.target.value)}
                  required
                />
                {!!error && (
                  <p className="text-danger">Bus Field Cannot Be Empty</p>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Date of Journey</label>
                <input
                  type="date"
                  className="form-control"
                  placeholder="Choose the Date"
                  name="doj"
                  value={departureDate}
                  error={!!error}
                  onChange={(e) => setDoj(e.target.value)}
                  required
                />
                {!!error && (
                  <p className="text-danger">Date field cannot be null</p>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">From</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter From Location"
                  name="from"
                  value={fromLocation}
                  error={!!error}
                  onChange={(e) => setFrom(e.target.value)}
                  required
                />
                {!!error && (
                  <p className="text-danger">From Location cannot be empty</p>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">To</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter To Location"
                  name="to"
                  value={toLocation}
                  error={!!error}
                  onChange={(e) => setTo(e.target.value)}
                  required
                />
                {!!error && (
                  <p className="text-danger">To Location cannot be empty</p>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Price</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter The Price"
                  name="price"
                  value={price}
                  error={!!error}
                  onChange={(e) => setPrice(e.target.value)}
                  required
                />
                {!!error && (
                  <p className="text-danger">price field cannot be null</p>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Total Seats</label>
                <input
                  type="number"
                  className="form-control"
                  placeholder="Enter the total seats"
                  name="seats"
                  value={seats}
                  error={!!error}
                  onChange={(e) => setSeats(e.target.value)}
                  required
                />
                {!!error && (
                  <p className="text-danger">
                    Total Seats field cannot be null
                  </p>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Available Seats</label>
                <input
                  type="number"
                  className="form-control"
                  placeholder="Enter The Available Seats"
                  name="seats"
                  value={availableSeats}
                  error={!!error}
                  onChange={(e) => setAvailableSeats(e.target.value)}
                  required
                />
                {!!error && (
                  <p className="text-danger">
                    Available Seats Field cannot be null
                  </p>
                )}
              </div>
              <div className="text-center">
                <button
                  className="btn btn-success"
                  style={{ marginTop: "10px" }}
                  onClick={(e) => saveBus(e)}
                >
                  Add Bus
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
      {/* </div> */}
    </div>
  );
};

export default AddBus;
