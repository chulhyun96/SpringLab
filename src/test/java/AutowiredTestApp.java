import Lab.SpringLab.HelloData;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

public class AutowiredTestApp {


    @Test
    void autowiredTestBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }


    @Configuration
    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(HelloData data) {
            System.out.println("setNoBean1 = " + data);
        }
        //null 호출
        @Autowired
        public void setNoBean2(@Nullable HelloData data) {
            System.out.println("setNoBean2 = " + data);
        }
        //Optional.empty 호출
        @Autowired(required = false)
        public void setNoBean3(Optional<HelloData> data) {
            System.out.println("setNoBean3  = " + data);
        }
    }
}
