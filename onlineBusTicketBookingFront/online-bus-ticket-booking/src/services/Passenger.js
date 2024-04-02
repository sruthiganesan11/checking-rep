import axios from "axios";

const BASE_REST_API_URL = "http://localhost:8081/api/passengers";

export const getAllPassengers = () => axios.get(BASE_REST_API_URL);

export const getpassenger = (id) => axios.get(BASE_REST_API_URL + "/" + id);

export const savepassenger = (passenger) =>
  axios.post(BASE_REST_API_URL, passenger);

export const updatepassenger = (id, passenger) =>
  axios.put(BASE_REST_API_URL + "/" + id, passenger);

export const deletepassenger = (id) =>
  axios.delete(BASE_REST_API_URL + "/" + id);
