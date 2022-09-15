package learning.springframework.sfgdi.services;

public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "hello world - Constructor";
    }
}
