import axios from "axios";
import { API_URL, JPA_API_URL } from "../../Constants";

class EventDataService {
  retrieveAllEvent(username) {
    return axios.get(`${API_URL}/${username}/event/`, username);
  }

  deleteEvent(username, id) {
    //console.log('executed service')
    return axios.delete(`${JPA_API_URL}/${username}/event/${id}`);
  }

  updateTodo(username, id, event) {
    //console.log('executed service')
    return axios.put(`${JPA_API_URL}/${username}/event/${id}`, event);
  }

  createEvent(event, username) {
    return axios.post(`${API_URL}/${username}/event/`, event, username);
  }
}

export default new EventDataService();
