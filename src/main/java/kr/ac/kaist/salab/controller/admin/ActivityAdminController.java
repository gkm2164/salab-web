package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Activity;
import kr.ac.kaist.salab.model.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by USER on 2016-03-07.
 */
@Controller
@RequestMapping("/admin/activity")
public class ActivityAdminController extends LayoutController {
    @Autowired
    private ActivityRepository ar;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newActivity(Model model) {
        PageDescription actAdmPageDesc = new DefaultPageDesc("admin/activity", "New Activity");
        model.addAttribute("activity", new Activity());
        return layoutCall(actAdmPageDesc, model);

    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newActivity(@ModelAttribute Activity activity, BindingResult br) {
        if (br.hasErrors()) {
            return "redirect:/admin/activity/new";
        }

        ar.save(activity);
        return "redirect:/admin/activity/new";
    }
}
