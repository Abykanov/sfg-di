package learning.springframework.sfgdi.controllers;

import learning.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService service;

    @Autowired
    public MyController(GreetingService greetingService) {
        this.service = greetingService;
    }

    public String sayHello() {
        return service.sayGreeting();
    }
}
