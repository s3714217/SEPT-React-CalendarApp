import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService.js'

class RecoverPasswordComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            password : '',
            confirmed_password: '',
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

        // check if both passwords match
        if(this.state.password === this.state.confirmed_password && this.state.password.length != 0){
            this.setState({hasShortPassword:false})
            this.props.history.push(`/login/`)
        }

        else if (this.state.password.length <= 6){
            this.setState({hasShortPassword:true})
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
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Your entered passwords do not match</div>}
                    {this.state.showSuccessMessage && <div>Login Sucessful</div>}
                    {this.state.hasShortPassword && <div className="alert alert-warning">Password length must be greater than 6 characters!</div>}

                    {/*<ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/>*/}
                    <h5>Please enter your desired new password</h5>
                    <br></br>
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <br></br>
                    Confirm Password: <input type="password" name="confirmed_password" value={this.state.confirmed_password} onChange={this.handleChange} />
                    <br></br>
                    <button className="btn btn-success" onClick={this.recoverPasswordClicked}>Recover Password</button>

                </div>
            </div>
        )
    }
}

export default RecoverPasswordComponent