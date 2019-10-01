import React, { Component } from 'react'
import moment from 'moment'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import EventDataService from '../../api/todo/EventDataService.js'
import AuthenticationService from './AuthenticationService.js'
import fs from 'fs'

class EventComponent extends Component {

    username = AuthenticationService.getLoggedInUserName()
    constructor(props) {
        super(props)

        this.state = {
        
            description: '',
            targetDate: moment(new Date()).format('YYYY-MM-DD'),
            title: ' ',
            location: ' ',

        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)

    }

    componentDidMount() {


       

    //    TodoDataService.retrieveTodo(username, this.state.id)
    //        .then(response => this.setState({
    //            description: response.data.description,
    //            targetDate: moment(response.data.targetDate).format('YYYY-MM-DD')
    //        }))
    }

    validate(values) {
        let errors = {}
        
        if (!values.title) {
            errors.title = 'Enter a Title'
        } else if (values.title.length < 5) {
            errors.title = 'Enter at least 3 Characters in Title'
        }
        
        if (!values.description) {
            errors.description = 'Enter a Description'
        } else if (values.description.length < 5) {
            errors.description = 'Enter at least 5 Characters in Description'
        }
        
        if (!values.location) {
            errors.location = 'Enter a location of the event'
        } else if (values.location.length < 5) {
            errors.location= 'Enter at least 5 Characters in Location'
        }
    

        if (!moment(values.targetDate).isValid()) {
            errors.targetDate = 'Enter a valid Target Date'
        }

        return errors

    }

    onSubmit(values) {
        let username = AuthenticationService.getLoggedInUserName()

        let todo = {

            title: values.title,
            description: values.description,
            targetDate: values.targetDate,
            location: values.location,

        }

        EventDataService.createEvent(todo, this.username).then(Response => this.props.history.push('/calendar'))

        
    }

    render() {

        let {description, targetDate, location, title} = this.state
        //let targetDate = this.state.targetDate

        return (
            <div>
                <h1>Add Event</h1>
                <div className="container">
                    <Formik
                        initialValues={{ title, description, targetDate, location}}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="description" component="div"
                                        className="alert alert-warning" />
                                    <ErrorMessage name="targetDate" component="div"
                                        className="alert alert-warning" />
                                    <ErrorMessage name="location" component="div"
                                        className="alert alert-warning" />
                                    <ErrorMessage name="title" component="div"
                                        className="alert alert-warning" />
                                    
                                    
                                    <fieldset className="form-group">
                                        <label>Title</label>
                                        <Field className="form-control" type="text" name="title" values = {this.state.title}/>
                                    </fieldset>
                                    
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" values = {this.state.description}/>
                                    </fieldset>
                                    
                                    <fieldset className="form-group">
                                        <label>Target Date</label>
                                        <Field className="form-control" type="date" name="targetDate" values = {this.state.targetDate}/>
                                    </fieldset>
                                    
                                    <fieldset className="form-group">
                                        <label>Location</label>
                                        <Field className="form-control" type="text" name="location" values = {this.state.location}/>
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Add</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }
}

export default EventComponent
