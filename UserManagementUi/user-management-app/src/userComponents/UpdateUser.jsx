import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { getUser, updateUser } from "../services/UserService";
import Swal from "sweetalert2";

const UpdateUser = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const updateUsers = async (e) => {
    e.preventDefault();

    const user = { firstName, lastName, email };
    console.log(user);

    try {
      if (id) {
        const response = await updateUser(id, user);
        console.log(response);
        Swal.fire({
            position: "center",
            icon: "success",
            title: "User has been Updated",
            showConfirmButton: "false",
            timer: 1500,
          });
        navigate("/user");
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        if (id) {
          const response = await getUser(id);
          const user = response.data;
          setFirstName(user.firstName);
          setLastName(user.lastName);
          setEmail(user.email);
        }
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, [id]);

  return (
    <div className="container">
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h2 className="text-center">Update User</h2>
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

              <button
                className="btn btn-success"
                onClick={(e) => updateUsers(e)}
              >
                Update
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UpdateUser;
