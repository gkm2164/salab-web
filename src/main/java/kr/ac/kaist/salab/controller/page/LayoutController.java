package kr.ac.kaist.salab.controller.page;

import kr.ac.kaist.salab.controller.navs.NavNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * Created by USER on 2016-02-23.
 */
public abstract class LayoutController {
    @Autowired NavNode rootNode;
    public String navId = "";

    public void setLocalNav(String navId) {
        this.navId = navId;
    }

    public String layoutCall(PageDescription pageDescription, Model model) {
        model.addAttribute("DEBUG", false);
        model.addAttribute("PDESC", pageDescription);
        model.addAttribute("NAVS", rootNode.getChilds());

        if (navId != null && !navId.equals("")) {
            NavNode localNav = rootNode.findId(navId);
            if (localNav == null) {
                System.out.println ("Invalid nav Id");
            } else {
                model.addAttribute("LNAVS", localNav.getChilds());
            }
        }
        return "main";
    }
}
