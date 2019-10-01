import axios from 'axios'
import { API_URL, JPA_API_URL } from '../../Constants'

class TodoDataService {

    retrieveAllTodos(name) {
        //console.log('executed service')
        return axios.get(`${JPA_API_URL}/users/${name}/todos`);
    }

    retrieveTodo(name) {
        //console.log('executed service')
        return axios.get(`https://localhost:4200/users/${name}`);
    }

    deleteTodo(id) {
        //console.log('executed service')
        return axios.delete(`${JPA_API_URL}/todos/${id}`);
    }

    updateTodo(name, id, todo) {
        //console.log('executed service')
        return axios.put(`${JPA_API_URL}/users/${name}/todos/${id}`, todo);
    }

    createTodo(state) {
       
        return axios.post(`https://localhost:4200/users/`, state);
    }

}

export default new TodoDataService()