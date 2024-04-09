import React from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import ListEmployee from "./employeeComponents/ListEmployee";
import ViewEmployee from "./employeeComponents/ViewEmployee";
import AddEmployee from "./employeeComponents/AddEmployee";
import UpdateEmployee from "./employeeComponents/UpdateEmployee";
import NavBar from "./components/NavBar";
import LoginComponent from "./components/LoginComponent";
import Register from "./components/Register";
import { isUserLoggedIn } from "./service/AuthService";

const App = () => {
  function AuthenticatedRoute({ children }) {
    const isAuth = isUserLoggedIn();
    if (isAuth) {
      return children;
    }
    return <Navigate to="/login" />;
  }
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route
            path="/"
            element={
              <AuthenticatedRoute>
                <ListEmployee />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/employee"
            element={
              <AuthenticatedRoute>
                <ListEmployee />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/viewEmployee/:id"
            element={
              <AuthenticatedRoute>
                <ViewEmployee />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/addEmployee"
            element={
              <AuthenticatedRoute>
                <AddEmployee />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/updateEmployee/:id"
            element={
              <AuthenticatedRoute>
                <UpdateEmployee />
              </AuthenticatedRoute>
            }
          />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </BrowserRouter>
    </>
  );
};

export default App;
