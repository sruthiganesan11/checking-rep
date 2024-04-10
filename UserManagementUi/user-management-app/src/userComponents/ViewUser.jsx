import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getUser } from "../services/UserService";
import "../css/viewUser.css"

const ViewUser = () => {

  const { id } = useParams();
  const navigate = useNavigate();

  const navBack = () => {
    navigate("/user");
  }

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const viewUsers = async (e) => {
    e.preventDefault();

    const user = { firstName, lastName, email };
    console.log(user);
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
    <div className="containerView">
      <div className="heading">
        <h1 className="heading1">User Details</h1>
      </div>
      <div class="main-content">
        <div class="user-details">
          <h5>The user id is : {id}</h5>
          <h5>
            The user Name is : {firstName} {lastName}
          </h5>
          <h5>The user Email is : {email}</h5>
        </div>

        <div className="btn">
          <button type="submit" id="btnHome" onClick={navBack}>
            Back Home
          </button>
        </div>
      </div>
    </div>
  );
};

export default ViewUser;
