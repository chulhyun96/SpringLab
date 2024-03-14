import Lab.AutoAppConfig;
import Lab.StartSpringConf.TestInt;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {


    @Test
    void strategyPatternTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,AllBean.class);
        AllBean bean = ac.getBean(AllBean.class);
        String s = bean.printDynamically("testA");
        System.out.println(s);
        String s1 = bean.printDynamically("testB");
        System.out.println(s1);
    }

    static class AllBean {
        private final Map<String, TestInt> testIntMap;
        private List<TestInt> testIntList;

        public AllBean(Map<String, TestInt> testIntMap, List<TestInt> testIntList) {
            this.testIntMap = testIntMap;
            this.testIntList = testIntList;
            System.out.println("testIntMap = " + testIntMap);
            System.out.println("testIntList = " + testIntList);
        }

        public String printDynamically(String testClassName) {
            TestInt testInt = testIntMap.get(testClassName);
            return testInt.printStatus();
        }
    }
}
