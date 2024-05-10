import React from "react";
import { useNavigate } from "react-router-dom";
import { FaFacebook, FaTwitter, FaInstagram, FaLinkedin } from "react-icons/fa";
import doctor from "../assets/doc1.avif";
import "./patientdashboard.css";

const Dashboard = () => {
  const navigate = useNavigate();
  //when Book Appointmnet button is clicked navugate to BookingNow component
  const bookNow = (e) => {
    e.preventDefault();
    navigate("/bookNow");
  };
  //when view Appointmnet button is clicked navigate to ViewAppointment component
  const handleViewAppointment = (e) => {
    e.preventDefault();
    navigate("/viewAppointment");
  };
  //when view Prescription button is clicked navigate to ViewPrescriptions component
  const handleViewPrescription = (e) => {
    e.preventDefault();
    navigate("/viewPrescription");
  };
  //when view Guidelines button is clicked navigate to ViewGuidelines component
  const handleGuideline = (e) => {
    e.preventDefault();
    navigate("/viewGuidelines");
  };
  return (
    <div>
      <div className="col-sm-6 col-md-4">
        <div className="team-item">
          <img
            src="https://demo.epic-webdesign.com/tf-pacifico/v1/images/team3a.jpg"
            className="team-img"
            alt="pic"
          />
          <h3>ALEXANDRA SMITHS</h3>
          <div className="team-info">
            <p>Partner, Client & Product Solutions</p>
          </div>
          <p>
            "What I really like and enjoy about working at Apollo is that we are
            not complacent. We are constantly seeking new opportunities to
            evolve our business."
          </p>
          <ul className="team-icon">
            <li>
              <a href="#" className="twitter">
                <FaTwitter />
              </a>
            </li>
            <li>
              <a href="#" className="pinterest">
                <FaInstagram />
              </a>
            </li>
            <li>
              <a href="#" className="facebook">
                <FaLinkedin />
              </a>
            </li>
            <li>
              <a href="#" className="dribble">
                <FaFacebook />
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div className="col-sm-6 col-md-4">
        <div className="team-item">
          <img
            src="https://demo.epic-webdesign.com/tf-pacifico/v1/images/team3a.jpg"
            className="team-img"
            alt="pic"
          />
          <h3>ALEXANDRA SMITHS</h3>
          <div className="team-info">
            <p>Partner, Client & Product Solutions</p>
          </div>
          <p>
            "What I really like and enjoy about working at Apollo is that we are
            not complacent. We are constantly seeking new opportunities to
            evolve our business."
          </p>
          <ul className="team-icon">
            <li>
              <a href="#" className="twitter">
                <FaTwitter />
              </a>
            </li>
            <li>
              <a href="#" className="pinterest">
                <FaInstagram />
              </a>
            </li>
            <li>
              <a href="#" className="facebook">
                <FaLinkedin />
              </a>
            </li>
            <li>
              <a href="#" className="dribble">
                <FaFacebook />
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div className="col-sm-6 col-md-4">
        <div className="team-item">
          <img
            src="https://demo.epic-webdesign.com/tf-pacifico/v1/images/team3a.jpg"
            className="team-img"
            alt="pic"
          />
          <h3>ALEXANDRA SMITHS</h3>
          <div className="team-info">
            <p>Partner, Client & Product Solutions</p>
          </div>
          <p>
            "What I really like and enjoy about working at Apollo is that we are
            not complacent. We are constantly seeking new opportunities to
            evolve our business."
          </p>
          <ul className="team-icon">
            <li>
              <a href="#" className="twitter">
                <FaTwitter />
              </a>
            </li>
            <li>
              <a href="#" className="pinterest">
                <FaInstagram />
              </a>
            </li>
            <li>
              <a href="#" className="facebook">
                <FaLinkedin />
              </a>
            </li>
            <li>
              <a href="#" className="dribble">
                <FaFacebook />
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
