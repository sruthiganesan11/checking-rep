import React from "react";
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { Link } from "react-router-dom";

const schema = yup.object().shape({
  firstname: yup.string().required("Firstname is required"),
  lastname: yup.string().required("Lastname is required"),
  email: yup
    .string()
    .email("Please enter valid email")
    .required("Email is required"),
  password: yup
    .string()
    .required("Password is required")
    .min(4, "Minimum 4 chars required")
    .max(15, "Enter upto 15 chars only"),
  confirmPassword: yup
    .string()
    .required("Confirm Password is required")
    .oneOf([yup.ref("password"), null]),
});

const SignUp = () => {
  const {
    register,
    handleSubmit,
    formState: { errors, isValid, isDirty },
  } = useForm({
    resolver: yupResolver(schema),
    mode: "onChange",
  });

  // function handleSubmit(data){
  // from backend fetch// }

  return (
    <div className="form-bg">
      <form
        className="form-box"
        onSubmit={handleSubmit((data) => console.log(data))}
      >
        <h3>Sign Up</h3>
        <div className="form-group">
          <input
            {...register("firstname")}
            type="text"
            className="form-control"
            placeholder="First Name"
          />
          <span className="form-errors">{errors.firstname?.message}</span>
        </div>
        <div className="form-group">
          <input
            {...register("lastname")}
            type="text"
            className="form-control"
            placeholder="Last Name"
          />
          <span className="form-errors">{errors.lastname?.message}</span>
        </div>
        <div className="form-group">
          <input
            {...register("email")}
            type="email"
            className="form-control"
            placeholder="Email"
          />
          <span className="form-errors">{errors.email?.message}</span>
        </div>
        <div className="form-group">
          <input
            {...register("password")}
            type="password"
            className="form-control"
            placeholder="Password"
          />
          <span className="form-errors">{errors.password?.message}</span>
        </div>
        <div className="form-group">
          <input
            {...register("confirmPassword")}
            type="password"
            className="form-control"
            placeholder="Confirm Password"
          />
          <span className="form-errors">{errors.confirmPassword?.message}</span>

          <div className="terms">
            <input type="checkbox" id="checkbox" />
            <label htmlFor="checkbox" />I agree to the{" "}
            <Link to="/termsAndConditions">Terms and Conditions</Link>
          </div>
          <button className="btn">SignUp</button>
        </div>
      </form>

      <div>
        <div className="member">
          Already have an account? <Link to="/login">Login</Link>
        </div>
      </div>
    </div>
  );
};

export default SignUp;
