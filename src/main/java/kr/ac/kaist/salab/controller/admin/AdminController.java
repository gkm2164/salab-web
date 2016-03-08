package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController extends LayoutController {
    @RequestMapping
    public String adminHome(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("authToken") == null) {
            return "redirect:/admin/login";
        }
        return layoutCall(new DefaultPageDesc("admin/home", "Admin Home"), model);
    }

    @RequestMapping("/login")
    public String adminLoginHome(HttpSession httpSession, Model model) {
        return layoutCall(new DefaultPageDesc("admin/login", "Login"), model);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String adminLoginHome(String id, String password, HttpSession httpSession) {
        if (id.equals("gkm2164") && password.equals("gyeongmin")) {
            httpSession.setAttribute("authToken", "gkm2164");
            return "redirect:/admin";
        }
        return "redirect:/admin/login";
    }
}
