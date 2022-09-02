package learning.springframework.sfgdi.controllers;

import learning.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private final GreetingService service;

    @Autowired
    public ConstructorInjectedController(GreetingService service) {
        this.service = service;
    }

    public String getGreeting() {
        return service.sayGreeting();
    }
}
