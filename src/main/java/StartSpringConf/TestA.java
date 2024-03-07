package StartSpringConf;

import lombok.Setter;

@Setter
public class TestA implements TestInt{
    private String name;

    public TestA() {
    }

    public TestA(String name) {
        this.name = name;
    }

    @Override
    public void printStatus() {
        System.out.println("TestA = " + name);
    }
}
