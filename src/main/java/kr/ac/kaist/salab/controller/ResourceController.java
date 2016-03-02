package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationItem;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gyeongmin on 2016. 3. 2..
 */
@Controller
@RequestMapping("/resources")
@NavigationTop(
    @NavigationDesc(
        id = "resources",
        name = "Resources",
        link = "/resources",
        order = 7
    )
)
public class ResourceController extends LayoutController {
    @RequestMapping
    public String home() {
        return "resources/home";
    }

    @RequestMapping("/tools")
    @NavigationItem(
        @NavigationDesc(
            id = "tools",
            name = "Tools",
            link = "/tools",
            order = 1
        )
    )
    public String tools() {
        return "resources/tools";
    }

    @RequestMapping("/links")
    @NavigationItem(
        @NavigationDesc(
            id = "links",
            name = "Links",
            link = "/links",
            order = 2
        )
    )
    public String links() {
        return "resources/links";
    }
}
