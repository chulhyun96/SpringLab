import Lab.AutoAppConfig;
import Lab.StartSpringConf.TestInt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Object bean = ac.getBean("testA");
        Assertions.assertThat(bean).isInstanceOf(TestInt.class);
    }
}
