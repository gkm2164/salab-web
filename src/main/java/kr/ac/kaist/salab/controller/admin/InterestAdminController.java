package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Interest;
import kr.ac.kaist.salab.model.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/interest")
public class InterestAdminController extends LayoutController {
    @Autowired private InterestRepository ir;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newResearchInterest(Model model) {
        model.addAttribute("interest", new Interest());
        PageDescription riadminPageDesc =
                new PageDescription("admin/interest", "New Research Admin",
                        (css, js) -> {});
        return layoutCall(riadminPageDesc, model);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newResearchInterest(@ModelAttribute Interest interest, BindingResult ibr) {
        if (ibr.hasErrors()) {
            ibr.getAllErrors().forEach(System.out::println);
            return "redirect:/admin/rmir/new";
        }
        ir.save(interest);
        return "redirect:/admin/rmir/new";
    }
}
