package learning.springframework.sfgdi;

import learning.springframework.sfgdi.controllers.ConstructorInjectedController;
import learning.springframework.sfgdi.controllers.MyController;
import learning.springframework.sfgdi.controllers.PropertyInjectedController;
import learning.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) applicationContext.getBean("myController");

		String greeting = myController.sayHello();

		System.out.println(greeting);

		System.out.println("-------------- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) applicationContext.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-------------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) applicationContext.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------------- Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) applicationContext.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
