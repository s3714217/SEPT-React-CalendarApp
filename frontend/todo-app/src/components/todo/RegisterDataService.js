import axios from 'axios'
import { API_URL } from '../../Constants'


class RegisterDataService {

    
    registerUser(username, password) {
        return axios.post(`${API_URL}/user`, {
            username,
            password
        })
    }



}

export default new RegisterDataService()