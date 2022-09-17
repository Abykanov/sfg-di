package learning.springframework.sfgdi;

import learning.springframework.sfgdi.controllers.*;
import learning.springframework.sfgdi.datasource.FakeDataSource;
import learning.springframework.sfgdi.services.PrototypeBean;
import learning.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"learning.springframework.sfgdi", "learning.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = applicationContext.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());


		I18nController i18nController = applicationContext.getBean("i18nController", I18nController.class);

		System.out.println(i18nController.getGreeting());

		MyController myController = (MyController) applicationContext.getBean("myController");

		System.out.println("----------- Primary");

		System.out.println(myController.sayHello());

		System.out.println("-------------- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) applicationContext.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-------------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) applicationContext.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------------- Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) applicationContext.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());


		System.out.println("--------------- Bean Scopes --------------");

		SingletonBean singletonBean1 = applicationContext.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBean1.getScope());
		SingletonBean singletonBean2 = applicationContext.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBean2.getScope());

		PrototypeBean prototypeBean1 = applicationContext.getBean("prototypeBean", PrototypeBean.class);
		System.out.println(prototypeBean1.getScope());
		PrototypeBean prototypeBean2 = applicationContext.getBean("prototypeBean", PrototypeBean.class);
		System.out.println(prototypeBean2.getScope());

		System.out.println("--------------------- datasource.properties ----------------------");

		FakeDataSource fakeDataSource = applicationContext.getBean("fakeDataSource", FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());
	}

}
