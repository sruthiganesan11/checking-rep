import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
// import Dropdown from "react-bootstrap/Dropdown";
// import DropdownButton from "react-bootstrap/DropdownButton";

const BusDesitination = () => {
  const nav = useNavigate();
  const BASE_URL = "http://localhost:8081/api/buses";

  const [buses, setBuses] = useState([]);
  const [fromAndTo, setFromAndTo] = useState({
    from: "",
    to: "",
  });

  useEffect(() => {
    axios
      .get(BASE_URL)
      .then((response) => {
        setBuses(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const handleFilter = (value) => {
    setFromAndTo(value);
  };

  const filteredBuses = buses.filter((bus) => bus.f);
  return (
    <div className="container">
      <h1 className="text-center">Choose Your Destination</h1>
      <form>
        <div className="colilg-6">
          <div className="form-group">
            <label>
              From<span className="errmsg">*</span>
            </label>
            <select
              type="text"
              className="form-control"
              onChange={(e) =>
                handleFilter({ ...fromAndTo, from: e.target.value })
              }
            >
              <option value="Chennai">Chennai</option>
              <option value="Coimbatore">Coimbatore</option>
              <option value="Madurai">Madurai</option>
              <option value="Trichy">Trichy</option>
              <option value="Salem">Salem</option>
              <option value="Tirunelveli">Tirunelveli</option>
              <option value="Erode">Erode</option>
              <option value="Vellore">Vellore</option>
              <option value="Thoothukudi(Tuticorin)">Thoothukudi </option>
              <option value="Thanjavur">Thanjavur</option>
              <option value="Dindigul">Dindigul</option>
              <option value="Cuddalore">Cuddalore</option>
              <option value="Kanchipuram">Kanchipuram</option>
              <option value="Karaikudi">Karaikudi</option>
              <option value="Neyveli">Neyveli</option>
              <option value="Kumbakonam">Kumbakonam</option>
              <option value="Pollachi">Pollachi</option>
              <option value="Theni">Theni</option>
              <option value="pondicherry">pondicherry</option>
            </select>

            <label>
              To<span className="errmsg">*</span>
            </label>
            <select
              type="text"
              className="form-control"
              onChange={(e) =>
                handleFilter({ ...fromAndTo, to: e.target.value })
              }
            >
              <option value="Coimbatore">Coimbatore</option>
              <option value="Madurai">Madurai</option>
              <option value="Trichy">Trichy</option>
              <option value="Salem">Salem</option>
              <option value="Tirunelveli">Tirunelveli</option>
              <option value="Erode">Erode</option>
              <option value="Vellore">Vellore</option>
              <option value="Thoothukudi(Tuticorin)">Thoothukudi </option>
              <option value="Thanjavur">Thanjavur</option>
              <option value="Dindigul">Dindigul</option>
              <option value="Cuddalore">Cuddalore</option>
              <option value="Kanchipuram">Kanchipuram</option>
              <option value="Karaikudi">Karaikudi</option>
              <option value="Neyveli">Neyveli</option>
              <option value="Kumbakonam">Kumbakonam</option>
              <option value="Pollachi">Pollachi</option>
              <option value="Theni">Theni</option>
              <option value="pondicherry">pondicherry</option>
              <option value="Chennai">Chennai</option>
            </select>
          </div>
        </div>
        <br />
        <br />
        <br />

        <button type="submit" className="btn btn-primary">
          Search
        </button>
      </form>
    </div>
  );
};

export default BusDesitination;
