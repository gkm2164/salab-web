package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by USER on 2016-03-07.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends LayoutController {
    @RequestMapping
    public String adminHome() {
        return "admin/home";
    }
}
