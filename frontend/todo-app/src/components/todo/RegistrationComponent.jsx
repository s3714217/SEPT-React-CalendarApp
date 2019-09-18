import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService.js'
import * as EmailValidator from 'email-validator';
 

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

        if (this.state.username.length != 0 &&
            this.state.password.length != 0 &&
            this.state.password === this.state.confirmed_password &&
            this.state.email_address.length != 0 &&
            this.state.first_security_question.length != 0 &&
            this.state.second_security_question.length != 0 &&
            this.state.third_security_question.length != 0 &&
            EmailValidator.validate(this.state.email_address))
        {
            this.props.history.push(`/login/`)
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
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Please make sure not to leave any field empty AND both your passwords have to match AND email is valid!</div>}
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