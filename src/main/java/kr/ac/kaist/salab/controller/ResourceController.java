package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationItem;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.repository.ResourceGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    @Autowired private ResourceGroupRepository rgr;
    @RequestMapping
    public String home(Model model) {
        setLocalNav("resources");
        return layoutCall(new DefaultPageDesc("resources/home", "Resources"), model);
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
    public String tools(Model model) {
        setLocalNav("resources");
        return layoutCall(new DefaultPageDesc("resources/tools", "Resources"), model);
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
    public String links(Model model) {
        setLocalNav("resources");
        model.addAttribute("resourceGroup", rgr.findAll());
        PageDescription linkPageDesc =
                new PageDescription("resources/links", "Resources",
                        (css, js) -> css.add("resources.links.css"));

        return layoutCall(linkPageDesc, model);
    }
}
