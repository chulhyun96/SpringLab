### 의존관계 주입이란

- "의존관계 주입이란 애플리케이션이 실행 시점 **(런타임)** 에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 서버와 클라이언트가 연결되는 것".을 의존관계 주입이라고 한다
- 객체의 인스턴스를 생성하고, 그 참조값을 넘김으로써 연결되며, 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 (요청하는) **타입 인스턴스를 동적으로 변경할 수 있다는 것.**


그리고 이러한 작업을 IoC 컨테이너(DI 컨테이너)라고 한다.


### Spring의 의존관계 사용하기


```java
@Configuration  
public class AppConfig {  
	// 빈 등록
    @Bean  
    public TestInt createA() {  
        return new TestA();  
    }  
    // 빈 등록
    @Bean  
    public TestInt createB() {  
        return new TestB();  
    }  
    // 빈 등록
    @Bean  
	public Printer createPrinter() {  
	    return new Printer();  
	}
}
public class ConfigTest {  
    public static void main(String[] args) {  
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);  
  
        /* 빈 꺼내오기*/  
        TestA testA = ac.getBean("createA", TestA.class);  
        Printer printer = ac.getBean("createPrinter", Printer.class);  
        testA.setName("testA");  
        printer.print(testA);  
  
  
        /*TestB 빈 꺼내오기*/  
        TestB testB = ac.getBean("createB", TestB.class);  
        testB.setName("testB");  
        printer.print(testB);  
    }  
}

```

해당 코드에서 개발자는 new 연산자를 통해 직접 객체를 생성하지 않았고 ApplictionContext로 부터 ac.getBean 메서드를 통해 `@Bean` 애노테이션으로 빈으로 등록후 꺼내서 사용하였다.

여기서 ApplicaionContext를 스프링 컨테이너라 부르는데, 스프링 컨테이너는 `@Configuration`이 붙은 AppConfig 클래스의 정보를  통해 Bean으로 등록한 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.


**주의**
- 빈의 이름을 @Bean(name ="TestA") 이런식으로 부여해줄 수도 있다. Bean의 이름은 중복시 에러가 나거나 기존 것을 덮어버릴 수도 있기 때문에, **반드시 중복되어서는 안된다.**

**참고**
- 스프링은 빈을 등록하고 의존관계를 주입하는 과정이 한번에 일어나는 것이 아니라 단계별로 이루어져있다.
