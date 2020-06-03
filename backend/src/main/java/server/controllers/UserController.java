//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.controllers;

import DOA.context.UserContext;
import DOA.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.config.PasswordHashSha512;
import server.models.UserMessage;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:9002")
@RequestMapping({"/user"})
public class UserController {

    private UserContext userContext = new UserContext();
    private PasswordHashSha512 hash = new PasswordHashSha512();
    private byte[] salt = hash.getSalt();


    //todo salt in database opslaan per username en dan weer ophalen
    public UserController() throws NoSuchAlgorithmException {
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
        public ResponseEntity register(@RequestBody UserMessage user) throws SQLException, JsonProcessingException {
        String response = "User created";
        userContext.createTable();

        if (containsName(userContext.getAllUserNames(), user.getUserName())){
            response = "User exists";
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(response));
        }

        UserEntity userEntity = new UserEntity(
                user.getUserName(),
                hash.getHashedPassword(user.getPassword()),
                user.getBalance(),
                user.getEmail());
        userContext.add(userEntity);

        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(response));
    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    public ResponseEntity login(@RequestBody UserMessage user) throws JsonProcessingException {

        String error = "USERNAME";
        if (userContext.getUserPasswordByUsername(user.getUserName()) != null){
            error = "PASSWORD";

            if (!userContext.getUserPasswordByUsername(user.getUserName()).getPassword()
                    .equals(hash.getHashedPassword(user.getPassword())))
                return ResponseEntity.ok(new ObjectMapper().writeValueAsString(error));

            String token = this.getJwtToken(user);
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(token));
        }
        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(error));
    }

    private String getJwtToken(UserMessage user) {
        Map<String, Object> auth = new HashMap();
        auth.put("authorities", new ArrayList<String>() {
            {
                this.add("user");
            }
        });
        return Jwts.builder()
                .setSubject(user.getUserName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000L))
                .addClaims(auth).signWith(SignatureAlgorithm.HS512, "test".getBytes()).compact();
    }

    private boolean containsName(final List<UserEntity> list, final String name){
        return list.stream().anyMatch(o -> o.getUserName().equals(name));
        //return list.stream().filter(o -> o.getUserName().equals(name)).findFirst().isPresent();
    }
}
