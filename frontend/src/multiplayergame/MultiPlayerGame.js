import React, { Component } from "react";
import * as Stomp from "@stomp/stompjs";
import SockJS from "sockjs-client";
import { Link } from "react-router-dom";
import "./MultiPlayerGame.css";
import D1 from "../images/2D.jpg"


let stompClient = null;
class MultiPlayerGame extends Component{
    state = {
        begin: false,
        player: "",
        player1: "",
        player2: "",
        player3: "",
        playerBalance: "",
        player1Balance: "",
        player2Balance: "",
        player3Balance: "",
        players: [],
        playerHand: [],
        cardGrade:[],
        cardNumber: []
    
    }

    componentDidMount(){
        this.connectToWebSocket();
        console.log(this.state.playerHand, "PLAYERHAND ALTIJD")
        
    }
    
    connectToWebSocket(){
        let _this = this;
        const socket = new SockJS('http://localhost:9002/ws');
        stompClient = Stomp.Stomp.over(socket);

        stompClient.connect({}, function (frame) {

            stompClient.subscribe('/topic/game/' + localStorage.getItem("roomid"), (messageOutput) => {                
                _this.handleMessage(messageOutput);
            });
            stompClient.subscribe('/topic/game/' + localStorage.getItem("username"), (messageOutput) => {                
                _this.handleUserMessage(messageOutput);
            });
            const msg = {
                roomId: localStorage.getItem("roomid"),
                userName:localStorage.getItem("username"), //localstorage.getItem("username")
                balance: 100 //vanuit backend halen
            }          
           _this.sendMessage('/app/joingame', msg)
        });
        
    };

    setReady(){
        const message = {
            roomId: localStorage.getItem("roomid"),
            userName: localStorage.getItem("username"),
            balance: 123.0
        };
        console.log(message)
        stompClient.send('/app/setready', {}, JSON.stringify(message));
    }

    sendMessage(endPoint, msg){
        stompClient.send(endPoint, {}, JSON.stringify(msg));
        console.log(JSON.stringify(msg), 'msg send');
    };

    handleMessage(messageOutput){
        let message = (JSON.parse(messageOutput.body))
        console.log(messageOutput);
        console.log(message, "Message received");
        
        
    };

    handleUserMessage(messageOutput){
        let message = (JSON.parse(messageOutput.body))
        console.log(messageOutput);
        console.log(message, "Message received");

        switch(message.content){
            case "JOINED":
                this.setState({
                    players: message.players
                })
                console.log(this.state.players, "PLAYERS")
                for (let index = 0; index < this.state.players.length; index++) {
                    console.log(this.state.players[index].userName,"TEST PLAYERS")
                    if(index === 0){
                        console.log("kom erin")
                        this.setState({
                            player: this.state.players[index].userName,
                            playerBalance: this.state.players[index].balance
                        });
                        console.log(this.state.players, "PLAYER")
                        console.log(this.state.player, "PLAYER2")
                    }
                    if(index === 1){
                        this.setState({
                            player1: this.state.players[index].userName,
                            player1Balance: this.state.players[index].balance
                        });
                        console.log(this.state.player1, "PLAYER1")
                    }
                    if(index === 2){
                        this.setState({
                            player2: this.state.players[index].userName,
                            player2Balance: this.state.players[index].balance
                        });
                    }
                    if(index === 3){
                        this.setState({
                            player3: this.state.players[index].userName,
                            player3Balance: this.state.players[index].balance
                        });
                    }           
                }
                break;
            case "READY":
                    this.setState({
                        playerHand: message.hand
                    })
                    console.log(this.state.playerHand, "PLAYERHAND")

                    break;
            default:

        }
      
    }

    showCards(){
        if(this.state.playerHand){
            if(this.state.playerHand.length !== 0){
                for (let index = 0; index < this.state.playerHand.length; index++) {
                    if(this.state.playerHand[index].cardGrade === 1){
                        this.state.playerHand[index].cardGrade = "D";
                    }
                    if(this.state.playerHand[index].cardGrade === 2){
                        this.state.playerHand[index].cardGrade = "C";
                    }
                    if(this.state.playerHand[index].cardGrade === 3){
                        this.state.playerHand[index].cardGrade = "H";
                    }
                    if(this.state.playerHand[index].cardGrade === 4){
                        this.state.playerHand[index].cardGrade = "S";
                    }
                    }
                    console.log(this.state.playerHand, "PLAYERHAND AFTER FOR")
                    return(
                        <div>
                        <div class="card-small">
                        <img width="55" src={require(`../images/`+ (this.state.playerHand[0].cardNumber +1) + this.state.playerHand[0].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[1].cardNumber +1)+ this.state.playerHand[1].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[2].cardNumber +1)+ this.state.playerHand[2].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[3].cardNumber +1) + this.state.playerHand[3].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[4].cardNumber +1)+ this.state.playerHand[4].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[5].cardNumber +1)+ this.state.playerHand[5].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[6].cardNumber +1)+ this.state.playerHand[6].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[7].cardNumber +1)+ this.state.playerHand[7].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[8].cardNumber +1)+ this.state.playerHand[8].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[9].cardNumber +1)+ this.state.playerHand[9].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[10].cardNumber +1)+ this.state.playerHand[10].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[11].cardNumber +1)+ this.state.playerHand[11].cardGrade + `.jpg`)} />
                  </div>
                  <div class="card-small">
                  <img width="55" src={require(`../images/`+ (this.state.playerHand[12].cardNumber +1)+ this.state.playerHand[12].cardGrade + `.jpg`)} />
                  </div></div>         
                    )
            }
        }
        
            
        
        
        
        
    }

    render(){
        return(
            <div className="Home">
     
        <div class="">
        <div class="player1">{this.state.player2}
        <div>                  
            </div>€{this.state.player2Balance}  </div>
  <div class="table">
      <div class="player2">{this.state.player1}
      <div>
      €{this.state.player1Balance}
      </div>
      </div>
      <div class="player3">{this.state.player3}
      <div>
      €{this.state.player3Balance}
      </div>
      </div>
    <div class="board">
      {this.showCards()}      
    </div>
  </div>
  <div class="player"> {this.state.player}
                        <div>€{this.state.playerBalance}</div>
  </div>
</div>



      <Link className="link" onClick={this.setReady}>
      READY
      </Link>
      </div>
        );
    }

}

export default MultiPlayerGame;