package Lab.mylogger;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component()
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;

    @Setter
    private String requestUrl;
    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestUrl + "] " +message);
    }
    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);

    }

    @PreDestroy
    public void close () throws InterruptedException {
        Thread.sleep(5000);

        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }

}
