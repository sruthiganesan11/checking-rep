import axios from "axios";

const BASE_REST_API_URL = "http://localhost:8081/api/user";

export const getAllUsers = () => axios.get(BASE_REST_API_URL);

export const getUser = (id) => axios.get(BASE_REST_API_URL + "/" + id);

export const addUser = (user) => axios.post(BASE_REST_API_URL, user);

export const updateUser = (id, user) =>
  axios.put(BASE_REST_API_URL + "/" + id , user);

export const deleteUser = (id) => axios.delete(BASE_REST_API_URL + "/" + id);