package kr.ac.kaist.salab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by USER on 2016-03-03.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/pub")
    public String pubCRUD(Model model) {
        return "";
    }
}
