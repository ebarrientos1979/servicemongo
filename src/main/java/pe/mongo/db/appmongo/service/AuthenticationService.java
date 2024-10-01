package pe.mongo.db.appmongo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.mongo.db.appmongo.dto.JwtAuthenticationResponse;
import pe.mongo.db.appmongo.dto.SignUpRequest;

@Service
public class AuthenticationService implements IAuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            PasswordEncoder passwordEncoder,
            IJwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        return null;
    }

    @Override
    public JwtAuthenticationResponse signin(SignUpRequest request) {
        return null;
    }
}
