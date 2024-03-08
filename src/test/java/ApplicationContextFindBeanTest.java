import StartSpringConf.AppConfig;
import StartSpringConf.TestInt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextFindBeanTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findBeanByName() {
        TestInt createA = ac.getBean("createA", TestInt.class);
        Assertions.assertThat(createA).isInstanceOf(TestInt.class);
    }
}
