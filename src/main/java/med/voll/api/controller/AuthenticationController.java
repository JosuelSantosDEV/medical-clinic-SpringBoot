package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.AuthenticationData;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.JWTTokenData;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity loginAction(@RequestBody @Valid AuthenticationData auth){
        var authenticationToken = new UsernamePasswordAuthenticationToken(auth.login(), auth.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.tokenGenerate((User) authentication.getPrincipal());
        return ResponseEntity.ok(new JWTTokenData(tokenJWT));
    }
}
