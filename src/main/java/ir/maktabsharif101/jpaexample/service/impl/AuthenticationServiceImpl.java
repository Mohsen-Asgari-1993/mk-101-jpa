package ir.maktabsharif101.jpaexample.service.impl;

import com.google.common.hash.Hashing;
import ir.maktabsharif101.jpaexample.domain.BaseUser;
import ir.maktabsharif101.jpaexample.service.AuthenticationService;
import ir.maktabsharif101.jpaexample.service.UserService;
import ir.maktabsharif101.jpaexample.service.dto.LoginDTO;
import ir.maktabsharif101.jpaexample.util.SecurityContext;
import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    @Override
    public void authenticate(LoginDTO dto) {
        Optional<BaseUser> optionalUser = userService.findByUsername(dto.getUsername());
        if (optionalUser.isPresent()) {
            BaseUser baseUser = optionalUser.get();
            if (baseUser.getPassword().equals(
                    Hashing.sha256()
                            .hashString(dto.getPassword(), StandardCharsets.UTF_8)
                            .toString())
            ) {
                if (baseUser.getIsActive()) {
                    SecurityContext.fillContext(baseUser);
                } else {
                    throw new RuntimeException("user is disable");
                }
            } else {
                throw new RuntimeException("bad credential");
            }
        } else {
            throw new RuntimeException("user not found");
        }
    }
}
