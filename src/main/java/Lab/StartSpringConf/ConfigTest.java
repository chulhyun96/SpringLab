package Lab.StartSpringConf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        /* 빈 꺼내오기*/
        TestA testA = ac.getBean("createA", TestA.class);
        Printer printer = ac.getBean("createPrinter", Printer.class);
        testA.setName("testA");
        printer.print(testA);


        /*TestB 빈 꺼내오기*/
        TestB testB = ac.getBean("createB", TestB.class);
        testB.setName("testB");
        printer.print(testB);
    }
}
