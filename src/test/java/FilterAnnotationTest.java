import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.Filter;

public class FilterAnnotationTest {


    @Test
    void filerAnnotationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(FilterAppConfig.class);
        BeanA beanA = ac.getBean(BeanA.class);
        Assertions.assertThat(beanA).isNotNull();
    }


    @ComponentScan(includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class))
    @Configuration
    static class FilterAppConfig {
    }
}



