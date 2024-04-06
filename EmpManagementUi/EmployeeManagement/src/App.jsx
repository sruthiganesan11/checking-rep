import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ListEmployee from "./employeeComponents/ListEmployee";
import ViewEmployee from "./employeeComponents/ViewEmployee";
import AddEmployee from "./employeeComponents/AddEmployee";
import UpdateEmployee from "./employeeComponents/UpdateEmployee";
import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import LoginComponent from "./components/LoginComponent";
import Register from "./components/Register";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/" element={<ListEmployee />} />
          <Route path="/employee" element={<ListEmployee />} />
          <Route path="/viewEmployee/:id" element={<ViewEmployee />} />
          <Route path="/addEmployee" element={<AddEmployee />} />
          <Route path="/updateEmployee/:id" element={<UpdateEmployee />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/register" element={<Register />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
};

export default App;
