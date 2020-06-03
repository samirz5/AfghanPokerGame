import React, { Component } from "react";
import "./Lobby.css";
import {Button} from "react-bootstrap";
import {Link} from "react-router-dom";


class Lobby extends Component {
  // default State object
  state = {
    rooms: []
  };

  componentDidMount() {
    console.log(localStorage.getItem("token"), "Token");
    const token = localStorage.token 
    console.log(token);
    if(token){
      console.log( fetch('http://localhost:9002/getrooms',{
        method: 'GET',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        })
        
    }).then((result) => {
        console.log(result, "First return")
        return result.json();
    }).then((result) => {
        console.log(result, "Lobby return");
        this.setState({
          rooms: result
        })
        
        console.log(this.state.rooms, "rooms")
    }))
    }
   
  }

  createTable = () => {
    let table = [];
    let roomList = this.state.rooms;
    // Outer loop to create parent
    for (let i = 0; i < roomList.length; i++) {
      console.log(roomList);
        let children = [];
        //Inner loop to create children
        children.push(<td style={{padding: "1rem"}}>{roomList[i].roomId}</td>);
        children.push(<td style={{padding: "1rem"}}>{roomList[i].autoBetValue}</td>);
        children.push(<td style={{padding: "1rem"}}>{roomList[i].maxBetRounds}</td>);
        children.push(<td style={{padding: "1rem"}}>{roomList[i].amountPlayers}/4</td>);
    children.push(<Link to={"/multiplayergame"}><td style={{padding: "1rem"}}>Join {localStorage.setItem("roomid", roomList[i].roomId)}</td> </Link>);
        
        //Create the parent and add the children
        table.push(<tr>{children}</tr>)
    }
    return table
}

createGame= () =>{
  const token = localStorage.token 
    
    if(token){
      console.log( fetch('http://localhost:9002/creategame',{
        method: 'POST',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        })
        
    }).then((result) => {
        return result.json();
    }).then((result) => {
        //Setisloading false na verkeerd pass of username
        console.log(result, "msg rc");
        
    }))
    }
}

render(){
  return (
    <div className="Lobby">
      <div className="lander">
        <h1>Lobby</h1>
        <p>Join the game with your preferences or create a new room</p>
      </div>
      
                    <table>
                    <tr>
                        <th style={{padding: "1rem"}}>Room:</th>
                        <th style={{padding: "1rem"}}>Autobet value:</th>
                        <th style={{padding: "1rem"}}>Bet per round:</th>
                        <th style={{padding: "1rem"}}>Players:</th>
                    </tr>
                    {this.state && this.state.rooms && this.createTable()}
                </table>

                <div><Button onClick={this.createGame}>Create Game</Button></div>
    </div>
    
  );
}}

export default Lobby;