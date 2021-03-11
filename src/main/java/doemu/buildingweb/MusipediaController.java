package doemu.buildingweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusipediaController {

    @RequestMapping("/hi")
    public String hello(){
        return "Hello here";
    }
}
