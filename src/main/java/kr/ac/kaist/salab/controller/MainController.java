package kr.ac.kaist.salab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by USER on 2016-02-22.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String mainController() {
        return "redirect:/home";
    }
}
