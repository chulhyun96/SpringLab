import Lab.StartSpringConf.AppConfig;
import Lab.StartSpringConf.TestInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CGLIBTest {
    @Test
    @DisplayName("@Configuration을 없앰")
    public void testConfiguration() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("beanClass = " + bean.getClass());
    }
    @Test
    @DisplayName("@Configuration을 없앤 후 Bean 메서드 호출")
    void testSingleToneWithoutConfiguration() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Object bean1 = ac.getBean("createA");
        Object bean2 = ac.getBean("createA");

        System.out.println(bean1);
        System.out.println(bean2);

        AppConfig config = new AppConfig();
        TestInt a = config.createA();
        TestInt b = config.createA();

        System.out.println(a);
        System.out.println(b);
    }
}
