package learning.springframework.sfgdi.config;

import learning.springframework.pets.PetService;
import learning.springframework.pets.PetServiceFactory;
import learning.springframework.sfgdi.datasource.FakeDataSource;
import learning.springframework.sfgdi.repositories.EnglishGreetingRepository;
import learning.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import learning.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
public class GreetingServiceConfig {
    @Bean
    FakeDataSource fakeDataSource(@Value("${learning.username}") String username,
                                  @Value("${learning.password}") String password,
                                  @Value("${learning.jdbcurl}") String jdbcUrl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"ES"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }
    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

//    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }
}
