import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { getAllUsers, getUser, deleteUser } from "../services/UserService";

const ListUser = () => {
  const [users, setUsers] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listUsers();
  }, []);

  const listUsers = async () => {
    try {
      const response = await getAllUsers();
      setUsers(response.data);
      console.log(users);
    } catch (error) {
      console.log(error);
    }
  };

  const addNewUser = async () => {
    navigate("/addUser");
  };

  const updateUser = async (id) => {
    navigate(`/updateUser/${id}`);
  };

  const removeUser = async (id) => {
    try {
      const response = await deleteUser(id);
      listUsers();
    } catch (error) {
      console.log(error);
    }
  };

  const viewUser = async (id) => {
    try {
      const response = await getUser(id);
      navigate(`/viewUser/${id}`);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div>
      <div className="offset-lg-3 col-lg-6">
        <div className="container">
          <div className="card">
            <div className="card-title">
              <h2 className="text-center">List Of Users</h2>
            </div>
            <div className="card-body">
              <button className="btn btn-primary mb-2" onClick={addNewUser}>
                Add User
              </button>

              <div>
                <table className="table table-bordered table-hover shadow">
                  <thead className="table-head">
                    <tr>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Email</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {users.map((user) => (
                      <tr key={user.id}>
                        <td>{user.firstName}</td>
                        <td>{user.lastName}</td>
                        <td>{user.email}</td>
                        <td>
                          <button
                            className="btn btn-info"
                            onClick={() => viewUser(user.id)}
                          >
                            View
                          </button>
                          <button
                            className="btn btn-danger"
                            style={{ marginLeft: "10px" }}
                            onClick={() => removeUser(user.id)}
                          >
                            Delete
                          </button>
                          <button
                            className="btn btn-info"
                            style={{ marginLeft: "10px" }}
                            onClick={() => updateUser(user.id)}
                          >
                            Update
                          </button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ListUser;
