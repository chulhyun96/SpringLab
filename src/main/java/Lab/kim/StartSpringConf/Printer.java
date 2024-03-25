package Lab.kim.StartSpringConf;

import org.springframework.stereotype.Component;

@Component
public class Printer {
    private TestInt testInt;

    public Printer() {
    }

    public Printer(TestInt testInt) {
        this.testInt = testInt;
    }
    public void print(TestInt testInt) {
        testInt.printStatus();
    }

}
