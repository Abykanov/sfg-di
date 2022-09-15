package learning.springframework.sfgdi.services;


public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "hello from the primary service";
    }
}
