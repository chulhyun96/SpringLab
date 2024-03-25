package Lab.kim.SpringLab.response;


import Lab.kim.SpringLab.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Controller
public class ResponseBodyController {
    // HTTP 바디에 텍스트 형식으로 데이터 집어넣기
    @ResponseBody
    @GetMapping("/response-body-string")
    public String responseBody() {
        return "Hello";
    }

    @ResponseBody
    @GetMapping("/response-body-response-entity")
    public ResponseEntity<HelloData> responseBodyJson() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userB");
        helloData.setAge(30);
        return new ResponseEntity<>(helloData,HttpStatus.OK);
    }


    //json 형식으로 집어 넣기
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(" /response-body-json")
    public HelloData responseHelloDataJson() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }

    @ResponseBody
    @RequestMapping("/response-body1")
    public String getParam1(@RequestParam(value = "username", required = false)  String userName,
                           @RequestParam(value = "age", required = false) String age) {
        log.info("username = {}, age = {}", userName,age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/response-body2")
    public String getParam2(@RequestParam(required = false)  String userName,
                           @RequestParam(required = false) String age) {
        log.info("username = {}, age = {}", userName,age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/response-body3")
    public String getParam3(@RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }
}
