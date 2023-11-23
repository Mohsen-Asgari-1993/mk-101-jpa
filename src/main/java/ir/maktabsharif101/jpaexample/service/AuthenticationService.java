package ir.maktabsharif101.jpaexample.service;

import ir.maktabsharif101.jpaexample.service.dto.LoginDTO;

public interface AuthenticationService {

    void authenticate(LoginDTO dto);
}
