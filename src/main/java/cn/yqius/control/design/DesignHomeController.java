package cn.yqius.control.design;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//ResponseBody + Controller  = RestController
@RequestMapping(path = "/design")
public class DesignHomeController {

    @GetMapping("/home")
    public String home(){
        return "design_home";
    }
}
