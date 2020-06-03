
import React, {  } from "react";
import {FormGroup, FormControl, ControlLabel } from "react-bootstrap";
import LoaderButton from "../components/LoaderButton";
import { useFormFields } from "../libs/hooksLib";
import "./CreateRoom";

export default function CreateRoom(props) {
    //const [isLoading, setIsLoading] = useState(false);
    const [fields, handleFieldChange] = useFormFields({
        username: "",
        password: ""
      });
  // default State object


  function createRoom(params) {
      
  }
  function validateForm() {
    return fields.username.length > 0 && fields.password.length > 0;
  }

    return (
        <div className="CreateRoom">
        <form onSubmit={createRoom}>
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
   // isLoading={isLoading}
    disabled={!validateForm()}
    
  >
    Login
  </LoaderButton>
        </form>
      </div>
    );
  }
  
