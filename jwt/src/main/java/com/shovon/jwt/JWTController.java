package com.shovon.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class JWTController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("myUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtTokenUtil;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> getAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(
                authenticationRequest.getUsername()
        );

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
