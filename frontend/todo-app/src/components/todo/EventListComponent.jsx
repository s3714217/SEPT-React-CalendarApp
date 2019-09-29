import React, { Component } from 'react'
import PostData from './MockJSONdata/MockEvent.json'


class EventList extends Component {
    
     constructor(props) {
        super(props);
        this.width = props.width || "600px";
        this.style = props.style || {};
        this.style.width = this.width; // add this
    }
    
    render() {
    return(
        <div>
            <h style = {this.style}>EVENT LIST</h>
            <table class = 'table'style = {this.style}>
                <tr>
                    <th> Title</th>
                    <th> Description</th>
                    <th> Location</th>
                    <th> Date </th>
                </tr>
            
            {PostData.map((event, index)=>{
                return (
                <tr>
                    <td style = {this.style}>{event.eventTitle}</td>
                    <td style = {this.style}>{event.description}</td>
                    <td style = {this.style}>{event.location}</td>
                    <td style = {this.style}>{event.eventDate}</td>
                </tr>
                
                    
                        )
            })}
                </table>
            
        </div>
    )     
  }
    
}

export default EventList