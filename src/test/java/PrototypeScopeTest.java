import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

public class PrototypeScopeTest {

    @Test
    void prototypeBeanScopeTest() {

    }

    @Scope("prototype")
    static class PrototypeScope {

    }
}
