import axios from 'axios'
import { API_URL, JPA_API_URL } from '../../Constants'

class EventDataService {

    retrieveAllEvent(username) {
        //console.log('executed service')
        return axios.get(`https://localhost:4200/calendar/`, username);
    }

  //  deleteTodo(id) {
  //      //console.log('executed service')
  //      return axios.delete(`${JPA_API_URL}/todos/${id}`);
  //  }

  //  updateTodo(name, id, todo) {
  //      //console.log('executed service')
  //      return axios.put(`${JPA_API_URL}/users/${name}/todos/${id}`, todo);
  //  }

    createEvent(event, username) {
       
        return axios.post(`https://localhost:4200/calendar/event`, event,username);
    }

}

export default new EventDataService()