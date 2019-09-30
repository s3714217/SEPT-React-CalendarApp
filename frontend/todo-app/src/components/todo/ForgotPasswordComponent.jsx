import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService.js'

class ForgotPasswordComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            first_security_question : '',
            second_security_question: '',
            third_security_question: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        this.handleUsernameChange = this.handleUsernameChange.bind(this)
        this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.recoverPasswordClicked = this.recoverPasswordClicked.bind(this)
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

    recoverPasswordClicked() {

        if (this.state.first_security_question.length != 0 &&
            this.state.second_security_question.length != 0 &&
            this.state.third_security_question.length != 0) {
            // for now, let's try and redirect only.
            this.props.history.push(`/recoverpaasword/${this.state.username}`)
            this.setState({showSuccessMessage:true})
            this.setState({hasLoginFailed:false})
        }
        else {
            this.setState({showSuccessMessage:false})
            this.setState({hasLoginFailed:true})
        }

    }


    render() {
        return (
            <div>
                <h1>Recover Password</h1>
                <div className="container">
                    {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Please make sure not to leave any field empty</div>}
                    {this.state.showSuccessMessage && <div>Login Sucessful</div>}
                    {/*<ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/>*/}
                    <h5>Please Answer these Security Questions for the Purpose of Recovring your Account</h5>
                    <br></br>
                    What is your favorite color? <input type="text" name="first_security_question" value={this.state.first_security_question} onChange={this.handleChange} />
                    <br></br>
                    What is your father name? <input type="text" name="second_security_question" value={this.state.second_security_question} onChange={this.handleChange} />
                    <br></br>
                    What is your mother's middle name? <input type="text" name="third_security_question" value={this.state.third_security_question} onChange={this.handleChange} />
                    <br></br> 
                    <button className="btn btn-success" onClick={this.recoverPasswordClicked}>Recover Password</button>
                </div>
            </div>
        )
    }
}

export default ForgotPasswordComponent