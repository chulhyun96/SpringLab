package Lab.StartSpringConf;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
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
