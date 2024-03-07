package StartSpringConf;

import lombok.Setter;

@Setter
public class TestB implements TestInt{
    private String name;

    public TestB() {
    }

    public TestB(String name) {
        this.name = name;
    }

    @Override
    public void printStatus() {
        System.out.println("TestB = " + name);
    }
}
