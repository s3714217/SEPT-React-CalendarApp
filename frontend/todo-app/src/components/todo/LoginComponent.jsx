import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";
import PostData from "./MockJSONdata/MockUsers.json";

class LoginComponent extends Component {
  constructor(props) {
    super(props);

    // initalize variables
    this.state = {
      username: "",
      password: "",
      hasLoginFailed: false,
      showSuccessMessage: false,
      fileUserNames: [],
      filePasswords: [],
      validLogin: false
    };

    const fileUserNames = [];
    const filePasswords = [];

    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.loginClicked = this.loginClicked.bind(this);
    this.registrationClicked = this.registrationClicked.bind(this);
    this.forgotPasswordClicked = this.forgotPasswordClicked.bind(this);
  }

  handleChange(event) {
    console.log(this.state);
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleUsernameChange(event) {
    console.log(event.target.name);
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handlePasswordChange(event) {
    console.log(event.target.value);
    this.setState({ password: event.target.value });
  }

  appendToArray(username, passsword) {
    // if(this.fileUserName.length != 0 && this.filePasswords.length != 0) {
    this.fileUserName.push(username);
    this.filePasswords.push(passsword);
    // }
  }

  // validateUser(userName, passwrd) {
  //     if(this.state.username===userName && this.state.password===passwrd){
  //         return true
  //     }
  // }

  loginClicked() {
    // check if username and password exists in our database
    if (this.state.validLogin === true) {
      AuthenticationService.registerSuccessfulLogin(
        this.state.username,
        this.state.password
      );
      this.props.history.push(`/welcome/${this.state.username}`);
      this.setState({ showSuccessMessage: true });
      this.setState({ hasLoginFailed: false });
    } else {
      // else, display error message
      this.setState({ showSuccessMessage: false });
      this.setState({ hasLoginFailed: true });
    }

    AuthenticationService.executeBasicAuthenticationService(
      this.state.username,
      this.state.password
    )
      .then(() => {
        AuthenticationService.registerSuccessfulLogin(
          this.state.username,
          this.state.password
        );
        this.props.history.push(`/welcome/${this.state.username}`);
      })
      .catch(() => {
        this.setState({ showSuccessMessage: false });
        this.setState({ hasLoginFailed: true });
      });
    AuthenticationService.executeJwtAuthenticationService(
      this.state.username,
      this.state.password
    )
      .then(response => {
        AuthenticationService.registerSuccessfulLoginForJwt(
          this.state.username,
          response.data.token
        );
        this.props.history.push(`/welcome/${this.state.username}`);
      })
      .catch(() => {
        this.setState({ showSuccessMessage: false });
        this.setState({ hasLoginFailed: true });
      });
  }

  // if user clicks on registration button, then switch to registration page
  registrationClicked() {
    this.props.history.push(`/register/`);
  }

  // if user clicks on forgotPassword button, then switch to forgotPassword page
  forgotPasswordClicked() {
    this.props.history.push(`/forgotpassword/`);
  }

  render() {
    return (
      <div>
        {PostData.map((users, index) => {
          if (
            this.state.username === users.userName &&
            this.state.password === users.password
          ) {
            return (this.state.validLogin = true);
          }
        })}
        {/* read json file and compare user inputs with the data in the json file */}
        <h1>Login</h1>
        <div className="container">
          {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}
          {this.state.hasLoginFailed && (
            <div className="alert alert-warning">
              Invalid Credentials or something is wrong
            </div>
          )}
          {this.state.showSuccessMessage && <div>Login Sucessful</div>}
          {/* <ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/> */}
          User Name:{" "}
          <input
            type="text"
            name="username"
            value={this.state.username}
            onChange={this.handleChange}
          />
          Password:{" "}
          <input
            type="password"
            name="password"
            value={this.state.password}
            onChange={this.handleChange}
          />
          <button className="btn btn-success" onClick={this.loginClicked}>
            Login
          </button>
          <br></br>
          <button
            className="btn btn-register"
            onClick={this.registrationClicked}
          >
            Registration
          </button>
          <br></br>
          <button
            className="btn btn-register"
            onClick={this.forgotPasswordClicked}
          >
            Forgot Password
          </button>
        </div>
      </div>
    );
  }
}

export default LoginComponent;
