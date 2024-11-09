package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloAPIController {

    @GetMapping
    public String helloWorld(){
        return  "<h1>API with Spring Boot running!!!</h1>";
    }

}
