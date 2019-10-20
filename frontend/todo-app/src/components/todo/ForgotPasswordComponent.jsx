import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";
import PostData from "./MockJSONdata/MockUsers.json";

class ForgotPasswordComponent extends Component {
  constructor(props) {
    super(props);

    // initalize variables
    this.state = {
      username: "",
      first_security_question: "",
      second_security_question: "",
      third_security_question: "",
      hasLoginFailed: false,
      showSuccessMessage: false,
      usernameDoesNotExistMessage: false,
      notEnteredUsername: false,
      usernameDoesNotExist: false,
      securityQuestionAreAnswered: false,
      securityQuestionAreAnsweredWrong: false
    };
    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.recoverPasswordClicked = this.recoverPasswordClicked.bind(this);
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

  // rcover password function, triggered when user clicks on recover password button
  recoverPasswordClicked() {
    // check if username field is empty
    if (this.state.username.length === 0) {
      // display message if username field is empty
      this.setState({ notEnteredUsername: true });
    } else {
      // discard the error message
      this.setState({ notEnteredUsername: false });
      // check if username exists in our database, we have mock value for now
      if (this.state.usernameDoesNotExist === true) {
        // discard error message
        this.setState({ usernameDoesNotExistMessage: false });
        // check if all security questions are answered
        if (
          this.state.first_security_question.length != 0 &&
          this.state.second_security_question.length != 0 &&
          this.state.third_security_question.length != 0
        ) {
          // cehck if all security questions are answered correct
          if (this.state.securityQuestionAreAnswered === true) {
            // for now, let's try and redirect only.
            this.setState({ showSuccessMessage: true });
            this.setState({ hasLoginFailed: false });
            this.props.history.push(`/recoverpaasword/${this.state.username}`);
            this.setState({ showSuccessMessage: true });
            this.setState({ hasLoginFailed: false });
          } else {
            // if one or more security questions is answered incorrect, then display error message
            this.setState({ hasLoginFailed: false });
            this.setState({ securityQuestionAreAnsweredWrong: true });
          }
        } else {
          // if security questions aren't answered, display error message
          this.setState({ showSuccessMessage: false });
          this.setState({ hasLoginFailed: true });
        }
      } else {
        // if username doesn't exist, display error message
        this.setState({ usernameDoesNotExistMessage: true });
      }
    }
  }

  render() {
    return (
      <div>
        <h1>Recover Password</h1>
        <div className="container">
          {PostData.map((users, index) => {
            if (this.state.username === users.userName) {
              return (this.state.usernameDoesNotExist = true);
            }
          })}
          {PostData.map((users, index) => {
            if (
              this.state.first_security_question === users.favoriteColor &&
              this.state.second_security_question === users.fatherName &&
              this.state.third_security_question === users.motherMiddleName
            ) {
              return (this.state.securityQuestionAreAnswered = true);
            }
          })}
          {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>p*/}
          {this.state.notEnteredUsername && (
            <div className="alert alert-warning">Enter your username</div>
          )}
          {this.state.usernameDoesNotExistMessage && (
            <div className="alert alert-warning">
              Username doesn't exist in our database
            </div>
          )}
          {this.state.hasLoginFailed && (
            <div className="alert alert-warning">
              Please make sure not to leave any field empty
            </div>
          )}
          {this.state.securityQuestionAreAnsweredWrong && (
            <div className="alert alert-warning">
              One or more of your answers are incoreect
            </div>
          )}
          {this.state.showSuccessMessage && <div>Login Sucessful</div>}
          {/*<ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/>*/}
          <h5>
            Please Answer these Security Questions for the Purpose of Recovring
            your Account
          </h5>
          <br></br>
          Enter your username?{" "}
          <input
            type="text"
            name="username"
            value={this.state.username}
            onChange={this.handleChange}
          />
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
          <button
            className="btn btn-success"
            onClick={this.recoverPasswordClicked}
          >
            Recover Password
          </button>
        </div>
      </div>
    );
  }
}

export default ForgotPasswordComponent;
