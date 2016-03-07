package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        PageDescription activityPageDesc =
                new PageDescription("acts/acts.home", "Activity",
                        (css, js) -> {
                            css.add("activities.css");
                            js.add("salab.activities.js");
                        });
        return layoutCall(activityPageDesc, model);
    }
}
