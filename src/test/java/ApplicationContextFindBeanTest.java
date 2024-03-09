import Lab.StartSpringConf.AppConfig;
import Lab.StartSpringConf.TestA;
import Lab.StartSpringConf.TestInt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextFindBeanTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("이름으로 조회하기")
    void findBeanByName() {
        TestInt createA = ac.getBean("createA", TestInt.class);
        Assertions.assertThat(createA).isInstanceOf(TestA.class);
    }

    @Test
    @DisplayName("중복 타입으로 조회시 에러")
    void findBeanByType() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(TestInt.class));
    }

    @Test
    @DisplayName("존재하지 않는 빈 조회시 에러")
    void findNoExistBean() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(TestInt.class));
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findBeanBySpecificType() {
        Map<String, TestInt> beansOfType = ac.getBeansOfType(TestInt.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "bean" + beansOfType.get(key));
        }
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }
}
