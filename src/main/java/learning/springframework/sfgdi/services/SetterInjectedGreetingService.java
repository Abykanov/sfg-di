package learning.springframework.sfgdi.services;


public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "hello world - Setter";
    }
}
