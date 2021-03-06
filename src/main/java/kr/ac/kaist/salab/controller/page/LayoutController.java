package kr.ac.kaist.salab.controller.page;

import kr.ac.kaist.salab.controller.navs.NavNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class LayoutController {
    private static final Logger l = Logger.getLogger(LayoutController.class.getName());
    @Autowired NavNode rootNode;
    private String navId = "";

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
                l.log(Level.WARNING, "Invalid nav Id");
            } else {
                model.addAttribute("LNAVS", localNav.getChilds());
            }
        }
        return "main";
    }

    public class DefaultPageDesc extends PageDescription {

        public DefaultPageDesc(String viewName, String title) {
            super(viewName, title, (a, b) -> {});
        }
    }
}
