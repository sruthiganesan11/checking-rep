import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ListUser from "./userComponents/ListUser";
import ViewUser from "./userComponents/ViewUser";
import AddUser from "./userComponents/AddUser";
import UpdateUser from "./userComponents/UpdateUser";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ListUser />} />
          <Route path="/user" element={<ListUser />} />
          <Route path="/viewUser/:id" element={<ViewUser />} />
          <Route path="/addUser" element={<AddUser />} />
          <Route path="/updateUser/:id" element={<UpdateUser />} />

        </Routes>
      </BrowserRouter>
    </>
  );
};

export default App;
