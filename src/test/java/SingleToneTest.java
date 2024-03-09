import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class SingleToneTest {
    private static final SingleToneTest instance = new SingleToneTest();
    private SingleToneTest () {
    }
    public static SingleToneTest getInstance() {
        return instance;
    }
    public void login() {
        System.out.println("singletone test");
    }

    @Test
    @DisplayName("싱글톤 패턴 사용하여 객체 확인하기")
    void singleToneInstance() {
        SingleToneTest instance1 = SingleToneTest.getInstance();
        SingleToneTest instance2 = SingleToneTest.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        Assertions.assertThat(instance1).isSameAs(instance2);

    }

}
