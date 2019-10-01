import axios from 'axios'
import { API_URL, JPA_API_URL } from '../../Constants'

class TodoDataService {

    retrieveUser(name) {
        //console.log('executed service')
        return axios.get(`https://localhost:4200/welcome/${name}`);
    }

  //  deleteTodo(id) {
  //      //console.log('executed service')
  //      return axios.delete(`${JPA_API_URL}/todos/${id}`);
  //  }

  //  updateTodo(name, id, todo) {
  //      //console.log('executed service')
  //      return axios.put(`${JPA_API_URL}/users/${name}/todos/${id}`, todo);
  //  }

    createUser(user) {
       
        return axios.post(`https://localhost:4200/register`, user);
    }

}

export default new TodoDataService()