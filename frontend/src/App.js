import React, { useState, useEffect } from "react";
import { Link, withRouter } from "react-router-dom";
import { Nav, Navbar, NavItem } from "react-bootstrap";
import "./App.css";
import Routes from "./Routes";
import { LinkContainer } from "react-router-bootstrap";
import {Helmet} from "react-helmet"


function App(props) {
  const [isAuthenticated, userHasAuthenticated] = useState(false);
  const [isAuthenticating, setIsAuthenticating] = useState(true);
  useEffect(() => {
    onLoad();
  }, []);
  
  async function onLoad() {
    try {
      if(localStorage.getItem("token")!= null)
      {userHasAuthenticated(true);}      
    }
    catch(e) {
      if (e !== 'No current user') {
        alert(e);
      }
    }  
    setIsAuthenticating(false);
  }
  function handleLogout() {
    userHasAuthenticated(false);
    localStorage.removeItem("token");
    props.history.push("/login");
  }


  return (
    !isAuthenticating &&
    <div className="App container">
      <Helmet>
                <style>{'body { background-color: green; }'}</style>
            </Helmet>
      <Navbar fluid collapseOnSelect>
        <Navbar.Header>
          <Navbar.Brand>
            <Link to="/">Afghan Poker</Link>
          </Navbar.Brand>
          <Navbar.Toggle />
        </Navbar.Header>
        <Navbar.Collapse>
          <Nav pullRight>
            {isAuthenticated
              ? <NavItem onClick={handleLogout}>Logout</NavItem>
              : <>
                  <LinkContainer to="/register">
                    <NavItem>Signup</NavItem>
                  </LinkContainer>
                  <LinkContainer to="/login">
                    <NavItem>Login</NavItem>
                  </LinkContainer>
                </>
            }
          </Nav>
        </Navbar.Collapse>
      </Navbar>
      <Routes appProps={{ isAuthenticated, userHasAuthenticated }} />
    </div>
  );
}

export default withRouter(App);
