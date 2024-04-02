import axios from "axios";

const BASE_REST_API_URL = "http://localhost:8081/api/booking";

export const getAllBookings = () => axios.get(BASE_REST_API_URL);

export const getBooking = (id) => axios.get(BASE_REST_API_URL + "/" + id);

export const saveBooking = (booking) => axios.post(BASE_REST_API_URL, booking);

export const updateBooking = (id, booking) =>
  axios.put(BASE_REST_API_URL + "/" + id, booking);

export const deleteBooking = (id) => axios.delete(BASE_REST_API_URL + "/" + id);
