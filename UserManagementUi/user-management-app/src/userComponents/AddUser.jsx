import React, { useState } from "react";
import { useNavigate } from "react-router";
import { addUser } from "../services/UserService";
import Swal from "sweetalert2";
import "../css/addUser.css"

const AddUser = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const navigate = useNavigate();

  const saveUser = async (e) => {
    e.preventDefault();
    const user = { firstName, lastName, email };
    console.log(user);

    try {
      const response = await addUser(user);
      console.log(response);
      Swal.fire({
        position: "center",
        icon: "success",
        title: "User has been Saved",
        showConfirmButton: "false",
        timer: 1500,
      });
      navigate("/user");
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div className="containerAdd">
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h2 className="text-center">Add User</h2>
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">First Name:</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter First Name"
                  name="firstName"
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Last Name:</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Last Name"
                  name="lastName"
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Email:</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Email"
                  name="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </div>

              <button className="btn btn-success" onClick={(e) => saveUser(e)}>
                Add
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddUser;
