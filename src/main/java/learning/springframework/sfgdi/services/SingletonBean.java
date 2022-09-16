package learning.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("Singleton is created");
    }

    public String getScope() {
        return "i'm singleton";
    }
}
