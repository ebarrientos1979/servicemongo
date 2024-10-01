package pe.mongo.db.appmongo.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.mongo.db.appmongo.dto.JwtAuthenticationResponse;
import pe.mongo.db.appmongo.dto.SignInRequest;
import pe.mongo.db.appmongo.dto.SignUpRequest;

import java.util.Collection;
import java.util.List;

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
        //Grabar en la base de datos MongoDB los datos del usuario
        UsuarioDetail usuarioDetail = new UsuarioDetail();
        usuarioDetail.setUserName(request.getEmail());
        usuarioDetail.setPassword(passwordEncoder.encode(request.getPassword()));

        String jwt = jwtService.generateToken(usuarioDetail);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        return jwtAuthenticationResponse;

    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UsuarioDetail usuarioDetail = new UsuarioDetail();
        usuarioDetail.setUserName(request.getEmail());
        usuarioDetail.setPassword(passwordEncoder.encode(request.getPassword()));

        var jwt = jwtService.generateToken(usuarioDetail);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        return jwtAuthenticationResponse;
    }
}

@Data
@AllArgsConstructor
class UsuarioDetail implements UserDetails{
    private String email;
    private String password;

    public void setUserName(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
