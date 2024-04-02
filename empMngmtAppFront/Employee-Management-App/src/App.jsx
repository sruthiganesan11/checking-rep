import React from "react";
import "./App.css";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import { BrowserRouter, Route, Routes } from "react-router-dom";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path="/"></Route>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  );
};

export default App;
