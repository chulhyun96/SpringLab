import Lab.SpringLab.HelloData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


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

    @Test
    void testList() {
        List<HelloData> list = new ArrayList<>();
        /*for (int i = 0; i < list.size(); i++) {
            boolean contains = list.contains(list.get(i));
            if (!contains) {
                list.add(list.get(i));
            }
        }*/


    }

}
