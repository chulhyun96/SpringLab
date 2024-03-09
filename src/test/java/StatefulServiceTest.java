import Lab.Singtone.StatefulService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulServiceTestInnerClass.class);

    @Test
    @DisplayName("stateful 정보 확인, 싱글톤 컨테이너 사용시 주의점")
    void statefulMethod() {
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        // Thread A
        bean1.order("userA", 1000);

        // Thread B
        bean2.order("userB", 2000);


        // 예상 값 = 1000, 결과값 = 2000
        /*        int price = bean1.getPrice();*/
        /*System.out.println("결과 값" + price);*/
    }

    @Test
    @DisplayName("stateful 정보 확인, 싱글톤 컨테이너 사용시 주의점")
    void statelessMethod() {
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        // Thread A
        int userA = bean1.order("userA", 1000);
        // Thread B
        int userB = bean2.order("userB", 2000);

        System.out.println("userA = " + userA);
        System.out.println("userB = " + userB);
    }

    static class StatefulServiceTestInnerClass {
        @Bean
        StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
