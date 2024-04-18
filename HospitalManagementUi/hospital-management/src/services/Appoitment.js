import axios from 'axios'
const Base_URL= "http://localhost:8081/api/Appointment";

export const getAllAppointments=()=>axios.get(Base_URL);

 export const getAppointment=(id)=>axios.get(Base_URL+ "/" + id);

 export const saveAppointment=()=>axios.post(Base_URL);

 export const deleteAppointment=(id)=>axios.delete(Base_URL+"/"+id);

 export const updateAppointment=(id,appointment)=>axios.put(Base_URL+"/"+appointment,id);
 export const cancelAppointment=(id)=>axios.put(Base_URL+"/cancelAppointment/"+id)