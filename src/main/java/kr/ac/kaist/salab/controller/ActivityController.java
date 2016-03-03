package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by USER on 2016-02-23.
 */
@Controller
@RequestMapping("/activity")
@NavigationTop(
    @NavigationDesc(
        id = "activity",
        name = "Activity",
        link = "/activity",
        order = 6
    )
)
public class ActivityController extends LayoutController {
    
    @RequestMapping
    public String activityMain(Model model) {
        return layoutCall(new ActivityPageDescription(), model);
    }

    public class ActivityPageDescription extends PageDescription {
        protected ActivityPageDescription() {
            super("acts/acts.home", "Activity");
        }

        @Override
        protected void initCSS(List<String> pageCSS) {
            pageCSS.add("activities.css");
        }

        @Override
        protected void initJS(List<String> pageJS) {
            pageJS.add("salab.activities.js");
        }
    }
}
