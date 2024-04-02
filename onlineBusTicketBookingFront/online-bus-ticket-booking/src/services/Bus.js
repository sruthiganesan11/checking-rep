import axios from "axios";

const BASE_REST_API_URL = "http://localhost:8081/api/buses";

export const getAllBuses = () => axios.get(BASE_REST_API_URL);

export const getbus = (id) => axios.get(BASE_REST_API_URL + "/" + id);

export const addBus = (bus) => axios.post(BASE_REST_API_URL, bus);

export const updatebus = (id, bus) =>
  axios.put(BASE_REST_API_URL + "/" + id, bus);

export const deletebus = (id) => axios.delete(BASE_REST_API_URL + "/" + id);

