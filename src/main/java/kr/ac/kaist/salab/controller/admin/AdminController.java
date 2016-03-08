package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Hashtable;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController extends LayoutController {
    @RequestMapping
    public String adminHome(Model model) {
        Map<String, String> linkPair = new Hashtable<>();

        linkPair.put("/admin/member/new", "New Member");
        linkPair.put("/admin/publication/new", "New Publication");
        linkPair.put("/admin/mempubrel/new", "New Relation for Member & Publication");
        linkPair.put("/admin/memintrel/new", "New Relation for Member & Interests");
        linkPair.put("/admin/activity/new", "New Activities");

        model.addAttribute("linkmap", linkPair);
        model.addAttribute("links", linkPair.keySet());
        return layoutCall(new DefaultPageDesc("admin/home", "Admin Home"), model);
    }
}
