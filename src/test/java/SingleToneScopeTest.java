import jakarta.annotation.PostConstruct;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingleToneScopeTest {

    @Test
    void singleToneBeanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleToneBeanTest.class);
        SingleToneBeanTest bean1 = ac.getBean(SingleToneBeanTest.class);
        SingleToneBeanTest bean2 = ac.getBean(SingleToneBeanTest.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        Assertions.assertThat(bean1).isSameAs(bean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingleToneBeanTest {

        @PostConstruct
        public void init() {
            System.out.println("SingToneBeanTest.init");
        }
    }
}
