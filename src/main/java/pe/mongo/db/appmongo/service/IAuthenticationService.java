package pe.mongo.db.appmongo.service;

import pe.mongo.db.appmongo.dto.JwtAuthenticationResponse;
import pe.mongo.db.appmongo.dto.SignUpRequest;

public interface IAuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignUpRequest request);
}
