import React, { useState } from "react";
import {FormGroup, FormControl, ControlLabel } from "react-bootstrap";
import LoaderButton from "../components/LoaderButton";
import { useFormFields } from "../libs/hooksLib";
import "./Login.css";

export default function Login(props) {
  const [isLoading, setIsLoading] = useState(false);
  const [fields, handleFieldChange] = useFormFields({
    username: "",
    password: ""
  });

  async function login(event){
    event.preventDefault();
    localStorage.setItem("username", fields.username)
    console.log(fields.username, fields.password);
    setIsLoading(true);
    fetch('http://localhost:9002/user/login',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userName: fields.username,
            password: fields.password
        })
    }).then((result) => {
      if(result.status === 404){
        alert("Wrong username / password");
      }

      if(result.status === 200){
        return result.json();
      }
      else{
        alert("Something is wrong with the server try again later");

      }
        
    }).then((result) => {
        //Setisloading false na verkeerd pass of username
        console.log(result);
        localStorage.setItem("token", result);
        props.userHasAuthenticated(true);
        
    })
}

function validateForm() {
  return fields.username.length > 0 && fields.password.length > 0;
}

  return (
    <div className="Login">
      <form onSubmit={login}>
        <FormGroup controlId="username" bsSize="large">
          <ControlLabel>Username</ControlLabel>
          <FormControl
            autoFocus
            type="username"
            value={fields.username}
            onChange={handleFieldChange}
          />
        </FormGroup>
        <FormGroup controlId="password" bsSize="large">
          <ControlLabel>Password</ControlLabel>
          <FormControl
            value={fields.password}
            onChange={handleFieldChange}
            type="password"
          />
        </FormGroup>        
        <LoaderButton
  block
  type="submit"
  bsSize="large"
  isLoading={isLoading}
  disabled={!validateForm()}
  
>
  Login
</LoaderButton>
      </form>
    </div>
  );
}