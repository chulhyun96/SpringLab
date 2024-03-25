package Lab.kim.SpringLab.response;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        return new ModelAndView("response/hello")
                .addObject("data","V1, Hello!!");
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data","V2, Hello!!");
        return "response/hello";
    }
    @ResponseBody
    @RequestMapping("/response-test")
    public String responseTest(@PathVariable String user, HttpServletResponse response, HttpServletRequest request,
                               Model model) {
        return "ok";
    }
}
