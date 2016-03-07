package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController extends LayoutController {
    @RequestMapping
    public String adminHome(Model model) {
        return layoutCall(new DefaultPageDesc("admin/home", "Admin Home"), model);
    }
}
