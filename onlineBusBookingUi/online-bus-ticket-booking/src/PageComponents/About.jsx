import React from "react";
import Hero from "./Hero";
import AboutImg from "../assets/about2.avif";
import Aboutus from "../PageDetails/Aboutus";

const About = () => {
  return (
    <>
      <Hero cName="hero-mid" heroImg={AboutImg} title="About" btnClass="none" />
      <Aboutus />
    </>
  );
};

export default About;
