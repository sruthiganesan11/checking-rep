import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Header from "./NavBar/Header";
import SignUp from "./Register/SignUp";
import Contact from "./routes/Contact";
import About from "./routes/About";
import Home from "./routes/Home";
import Admin from "./BusComponents/Admin";
import AddBus from "./BusComponents/AddBus";
import ListBusComponent from "./BusComponents/ListBusComponent";
function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/signup" element={<SignUp />}></Route>
          <Route path="/contact" element={<Contact />}></Route>
          <Route path="/about" element={<About />}></Route>
          <Route path="/admin" element={<Admin />} />
          <Route path="/add" element={<AddBus />} />
          <Route path="/listbus" element={<ListBusComponent />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
