import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";
import * as EmailValidator from "email-validator";
import PostData from "./MockJSONdata/MockUsers.json";

class RegistrationComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      password: "",
      confirmed_password: "",
      email_address: "",
      first_security_question: "",
      second_security_question: "",
      third_security_question: "",
      showSuccessMessage: false,
      notProvidedUserName: false,
      invalidEmail: false,
      notProvidedEmail: false
    };
    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.registerClicked = this.registerClicked.bind(this);
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

  registerClicked() {
    AuthenticationService.executeJwtAuthenticationService("sept", "dummy").then(
      response => {
        AuthenticationService.registerSuccessfulLoginForJwt(
          "sept",
          response.data.token
        );
      }
    );

    // check if all fields are not empty and both passwords match and email is valid
    if (
      this.state.username.length != 0 &&
      this.state.password.length != 0 &&
      this.state.password.length > 6 &&
      this.state.password === this.state.confirmed_password &&
      this.state.email_address.length != 0 &&
      EmailValidator.validate(this.state.email_address) === true &&
      this.state.first_security_question.length != 0 &&
      this.state.first_security_question.length > 5 &&
      this.state.second_security_question.length != 0 &&
      this.state.second_security_question.length > 5 &&
      this.state.third_security_question.length != 0 &&
      this.state.third_security_question.length > 5
    ) {
      // TodoDataService.createTodo(this.state)
      // .then(() => this.props.history.push('/login'))

      //    AuthenticationService.RegisterAuthenticationService(this.state)
      //    .then(() => this.props.history.push('/login'))
      // redirect ot the main page
      this.props.history.push(`/login/`);
    }

    // check if username length is equal to zero
    if (this.state.username.length == 0) {
      // display error message
      this.setState({ notProvidedUserName: true });
    } else {
      // discard error message
      this.setState({ notProvidedUserName: false });
    }
    // check if email length is equal to zero
    if (this.state.email_address.length === 0) {
      // display error message
      this.setState({ notProvidedEmail: true });
    } else {
      // discard error message
      this.setState({ notProvidedEmail: false });
    }
    // check if username length doesn't equal to zero and its valid
    if (
      this.state.email_address.length != 0 &&
      EmailValidator.validate(this.state.email_address) === false
    ) {
      // display error message
      this.setState({ invalidEmail: true });
    } else {
      // discard error message
      this.setState({ invalidEmail: false });
    }
    // check if password length is less than 6 characters
    if (this.state.password.length <= 6) {
      // display error message
      this.setState({ hasShortPassword: true });
    } else {
      // discard error message
      this.setState({ hasShortPassword: false });
    }
    // check if both password doesn't match
    if (this.state.password != this.state.confirmed_password) {
      // display error message
      this.setState({ unMatchedPassword: true });
    } else {
      // discard error message
      this.setState({ unMatchedPassword: false });
    }
    // check if all security question's answered are less than 5 characters
    if (
      this.state.first_security_question.length <= 5 &&
      this.state.second_security_question.length <= 5 &&
      this.state.third_security_question.length <= 5
    ) {
      // display error message
      this.setState({ invalid_security: true });
    } else {
      // discard error message
      this.setState({ invalid_security: false });
    }
  }

  render() {
    return (
      <div>
        <h1>Registration</h1>
        <div className="container">
          {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}
          {this.state.notProvidedUserName && (
            <div className="alert alert-warning">
              Please enter your username
            </div>
          )}
          {this.state.hasShortPassword && (
            <div className="alert alert-warning">
              Password length must be greater than 6 characters!
            </div>
          )}
          {this.state.unMatchedPassword && (
            <div className="alert alert-warning">
              Please make sure you passwords are matching!
            </div>
          )}
          {this.state.notProvidedEmail && (
            <div className="alert alert-warning">
              Please enter your email address
            </div>
          )}
          {this.state.invalidEmail && (
            <div className="alert alert-warning">
              Please enter a valid email
            </div>
          )}
          {this.state.invalid_security && (
            <div className="alert alert-warning">
              Answer of securtity questions must be of length 6 or more!
            </div>
          )}
          {this.state.showSuccessMessage && <div>Login Sucessful</div>}
          {/*<ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/>*/}
          User Name:{" "}
          <input
            type="text"
            name="username"
            value={this.state.username}
            onChange={this.handleChange}
          />
          <br></br>
          Password:{" "}
          <input
            type="password"
            name="password"
            value={this.state.password}
            onChange={this.handleChange}
          />
          <br></br>
          Confirm Password:{" "}
          <input
            type="password"
            name="confirmed_password"
            value={this.state.confirmed_password}
            onChange={this.handleChange}
          />
          <br></br>
          Email Address:{" "}
          <input
            type="text"
            name="email_address"
            value={this.state.email_address}
            onChange={this.handleChange}
          />
          <br></br>
          <br></br>
          <h5>Security Questions for the Purpose of Recovring your Account</h5>
          <br></br>
          What is your favorite color?{" "}
          <input
            type="text"
            name="first_security_question"
            value={this.state.first_security_question}
            onChange={this.handleChange}
          />
          <br></br>
          What is your father name?{" "}
          <input
            type="text"
            name="second_security_question"
            value={this.state.second_security_question}
            onChange={this.handleChange}
          />
          <br></br>
          What is your mother's middle name?{" "}
          <input
            type="text"
            name="third_security_question"
            value={this.state.third_security_question}
            onChange={this.handleChange}
          />
          <br></br>
          <button className="btn btn-success" onClick={this.registerClicked}>
            Register
          </button>
        </div>
      </div>
    );
  }
}

export default RegistrationComponent;
