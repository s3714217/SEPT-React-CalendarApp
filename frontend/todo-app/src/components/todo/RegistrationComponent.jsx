import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService.js'

 

class RegistrationComponent extends Component {

    
    

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            confirmed_password: '',
            email_address: '',
            first_security_question: '',
            second_security_question: '',
            third_security_question: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        this.handleUsernameChange = this.handleUsernameChange.bind(this)
        this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.registerClicked = this.registerClicked.bind(this)
    }

    handleChange(event) {
        console.log(this.state);
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
    }

    handleUsernameChange(event) {
        console.log(event.target.name);
        this.setState(
            {
                [event.target.name]
                  :event.target.value
            }
        )
    }

    handlePasswordChange(event) {
        console.log(event.target.value);
        this.setState({password:event.target.value})
    }


    registerClicked() {

        AuthenticationService.executeJwtAuthenticationService('sept', 'dummy')
    .then(response => {
        AuthenticationService.registerSuccessfulLoginForJwt
        (
        'sept',
        response.data.token
        )
    });

        if (this.state.username.length != 0 &&
            this.state.password.length != 0 &&
            this.state.password.length > 6 &&
            this.state.password === this.state.confirmed_password &&
            this.state.email_address.length != 0 &&
            this.state.first_security_question.length != 0 &&
            this.state.first_security_question.length > 5 &&
            this.state.second_security_question.length != 0 &&
            this.state.second_security_question.length > 5 &&
            this.state.third_security_question.length != 0 &&
            this.state.third_security_question.length > 5
            
        )
         
        {
           // TodoDataService.createTodo(this.state)
           // .then(() => this.props.history.push('/login'))


        //    AuthenticationService.RegisterAuthenticationService(this.state)
        //    .then(() => this.props.history.push('/login'))
           this.props.history.push(`/login/`)
        }
        else if (this.state.password.length <= 6){
            this.setState({hasShortPassword:true})
        }

        else if (this.state.password != this.state.confirmed_password) {
            this.setState({unMatchedPassword:true})
        }
        else if (this.state.first_security_question.length <= 5
            && this.state.second_security_question.length <= 5
            && this.state.third_security_question.length <= 5){
            this.setState({invalid_security:true})
        }
        
        else {
            this.setState({showSuccessMessage:false})
            this.setState({hasLoginFailed:true})
        }
    }

    render() {
        return (
            <div>
                <h1>Registration</h1>
                <div className="container">
                    {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Please make sure not to leave any field empty AND email is valid!</div>}
                    {this.state.hasShortPassword && <div className="alert alert-warning">Password length must be greater than 6 characters!</div>}
                    {this.state.invalid_security && <div className="alert alert-warning">Answer of securtity questions must be of length 6 or more!</div>}
                    {this.state.unMatchedPassword && <div className="alert alert-warning">Please make sure you passwords are matching!</div>}

                    {this.state.showSuccessMessage && <div>Login Sucessful</div>}
                    {/*<ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/>*/}
                    User Name: <input type="text" name="username" value={this.state.username} onChange={this.handleChange} />
                    <br></br>
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <br></br>
                    Confirm Password: <input type="password" name="confirmed_password" value={this.state.confirmed_password} onChange={this.handleChange} />
                    <br></br>
                    Email Address: <input type="text" name="email_address" value={this.state.email_address} onChange={this.handleChange} />
                    <br></br>
                    <br></br>
                    <h5>Security Questions for the Purpose of Recovring your Account</h5>
                    <br></br>
                    What is your favorite color? <input type="text" name="first_security_question" value={this.state.first_security_question}  onChange={this.handleChange} />
                    <br></br>
                    What is your father name? <input type="text" name="second_security_question" value={this.state.second_security_question} onChange={this.handleChange} />
                    <br></br>
                    What is your mother's middle name? <input type="text" name="third_security_question" value={this.state.third_security_question} onChange={this.handleChange} />
                    <br></br>
                    <button className="btn btn-success" onClick={this.registerClicked}>Register</button>
                    
                </div>
            </div>
        )
    }
}

export default RegistrationComponent