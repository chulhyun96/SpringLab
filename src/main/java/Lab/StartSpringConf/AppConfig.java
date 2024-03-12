package Lab.StartSpringConf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TestInt createA() {
        return new TestA();
    }
    @Bean
    public TestInt createB() {
        return new TestB();
    }
    @Bean
    public Printer createPrinter() {
        return new Printer();

    }
}
