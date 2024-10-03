package pe.mongo.db.appmongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.mongo.db.appmongo.dto.JwtAuthenticationResponse;
import pe.mongo.db.appmongo.dto.SignInRequest;
import pe.mongo.db.appmongo.dto.SignUpRequest;
import pe.mongo.db.appmongo.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signUp(
            @RequestBody SignUpRequest signUpRequest
    ){
        return ResponseEntity.ok(null);
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> sigIn(
            @RequestBody SignInRequest signInRequest
    ){
        return ResponseEntity.ok(null);
    }
}
