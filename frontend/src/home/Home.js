import React from "react";
import "./Home.css";
import {Form} from "react-bootstrap";
import {Link} from "react-router-dom";

export default function Home(props) {



  return (
    <div className="Home">
      <div className="lander">
        <h1>Afghan Poker</h1>
        <p>A simple afghan poker game</p>
      </div>
      <Form>
                    Welkom 
                    <div className="btnLogin">
                        <Link to={"/singleplayer"} className="btn btn-default">
                            
                            <div className="txtLogin">
                                SinglePlayer
                            </div>
                        </Link>
                    </div>

                    <div className="btnLogin">
                    <Link to={"/lobby"} className="btn btn-default">
                            
                            <div className="txtLogin">
                                MultiPlayer
                            </div>
                        </Link>
                    </div>
                    </Form>
    </div>
  );
}