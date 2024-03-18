import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeScopeTest {

    @Test
    void prototypeBeanScopeTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrototypeScope.class);

        PrototypeScope bean1 = context.getBean(PrototypeScope.class);
        PrototypeScope bean2 = context.getBean(PrototypeScope.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        context.close();
        assertThat(bean1).isNotSameAs(bean2);
    }

    @Scope("prototype")
    static class PrototypeScope {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeScope.init");
        }
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeScope.destroy");
        }
    }
}
