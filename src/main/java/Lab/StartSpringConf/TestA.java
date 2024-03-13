package Lab.StartSpringConf;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class TestA implements TestInt{
    private String name;
    public TestA() {
    }
    public TestA(String name) {
        this.name = name;
    }

    @Override
    public String printStatus() {
        return "TestA" + name;
    }
}
