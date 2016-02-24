package kr.ac.kaist.salab.controller.page;

import org.springframework.ui.Model;

/**
 * Created by USER on 2016-02-23.
 */
public abstract class LayoutController {
    public String layoutCall(PageDescription pageDescription, Model model) {
        model.addAttribute("DEBUG", false);
        model.addAttribute("PDESC", pageDescription);
        return "main";
    }
}
