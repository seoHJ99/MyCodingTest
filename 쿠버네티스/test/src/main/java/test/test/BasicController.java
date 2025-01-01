package test.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BasicController {

    @RequestMapping("/")
    public String home(){
        return "커밍홈";
    }
}
