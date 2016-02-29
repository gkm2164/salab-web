package kr.ac.kaist.salab.controller.page;

import kr.ac.kaist.salab.controller.navs.NavNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * Created by USER on 2016-02-23.
 */
public abstract class LayoutController {
    @Autowired NavNode rootNode;

    public String layoutCall(PageDescription pageDescription, Model model) {
        model.addAttribute("DEBUG", false);
        model.addAttribute("PDESC", pageDescription);
        model.addAttribute("NAVS", rootNode.getChilds());

        return "main";
    }


}
