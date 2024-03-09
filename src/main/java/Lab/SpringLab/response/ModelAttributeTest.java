package Lab.SpringLab.response;


import Lab.SpringLab.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ModelAttributeTest {
    @ResponseBody
    @RequestMapping("/model-test")
    public String getModel(@ModelAttribute HelloData data) {
      log.debug("date={}", data);
      return "data";
    }
}
