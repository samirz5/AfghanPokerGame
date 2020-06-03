import React from "react";
import { Route, Switch } from "react-router-dom";
import Home from "./home/Home";
import Login from "./login/Login";
import Register from "./register/Register";
import NotFound from "./notfound/NotFound";
import AuthenticatedRoute from "./components/AuthenticatedRoute";
import UnauthenticatedRoute from "./components/UnAuthenticatedRoute";
import Lobby from "./lobby/Lobby";
import MultiPlayerGame from "./multiplayergame/MultiPlayerGame";
import CreateRoom from "./createroom/CreateRoom";


export default function Routes({ appProps }) {
    return (
      <Switch>
        <AuthenticatedRoute path="/" exact component={Home} appProps={appProps} />
        <UnauthenticatedRoute path="/register" exact component={Register} appProps={appProps} />
        <UnauthenticatedRoute path="/login" exact component={Login} appProps={appProps} />
        <AuthenticatedRoute path="/lobby" exact component={Lobby} appProps={appProps} />
        <AuthenticatedRoute path="/createroom" exact component={CreateRoom} appProps={appProps} />
        <AuthenticatedRoute path="/multiplayergame" exact component={MultiPlayerGame} appProps={appProps} />
        { /* Finally, catch all unmatched routes */ }
        <Route component={NotFound} />
      </Switch>
    );
  }
