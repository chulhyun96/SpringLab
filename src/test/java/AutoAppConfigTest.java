import Lab.StartSpringConf.TestA;
import Lab.StartSpringConf.TestInt;
import Lab.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Object bean = ac.getBean(TestA.class);
        Assertions.assertThat(bean).isInstanceOf(TestInt.class);
    }
}
