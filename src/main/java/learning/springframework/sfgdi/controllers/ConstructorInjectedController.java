package learning.springframework.sfgdi.controllers;

import learning.springframework.sfgdi.services.GreetingService;

public class ConstructorInjectedController {
    private final GreetingService service;

    public ConstructorInjectedController(GreetingService service) {
        this.service = service;
    }

    public String getGreeting() {
        return service.sayGreeting();
    }
}
