package kr.ac.kaist.salab.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by USER on 2016-02-23.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController extends LayoutController {
    private final static String VIEW_NAME = "acts/acts.home";


    @RequestMapping
    public String activityMain(Model model) {
        return layoutCall(new ActivityPageDescription(), model);
    }

    public class ActivityPageDescription extends PageDescription {
        protected ActivityPageDescription() {
            super(VIEW_NAME, "Activity");
        }

        @Override
        void initCSS(List<String> pageCSS) {
            pageCSS.add("activities.css");
        }

        @Override
        void initJS(List<String> pageJS) {
            pageJS.add("salab.activities.js");
        }
    }
}
