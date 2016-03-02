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
 * Created by USER on 2016-02-26.
 */
@Controller
@RequestMapping("/home")
@NavigationTop(
    @NavigationDesc(
        id = "home",
        name = "Home",
        link = "/home",
        order = 1
    )
)
public class HomeController extends LayoutController {

    @RequestMapping
    public String home(Model model) {
        return layoutCall(new HomePageDescription(), model);
    }

    public class HomePageDescription extends PageDescription {
        protected HomePageDescription() {
            super("home/home", "SALab website");
        }

        @Override
        protected void initCSS(List<String> pageCSS) {
            pageCSS.add("home.css");
        }

        @Override
        protected void initJS(List<String> pageJS) {
            pageJS.add("salab.home.js");
        }
    }
}
