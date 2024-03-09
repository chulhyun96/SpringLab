package Lab.StartSpringConf;

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
