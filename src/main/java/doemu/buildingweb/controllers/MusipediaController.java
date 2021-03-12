package doemu.buildingweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusipediaController {



    @RequestMapping("/hi")
    public String hello(){
        return "Hello here";
    }

    public MusipediaController() {
    }
}
