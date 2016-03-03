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
        return layoutCall(
                new PageDescription("resources/home", "Resources") {

                    @Override
                    protected void initCSS(List<String> pageCSS) {

                    }

                    @Override
                    protected void initJS(List<String> pageJS) {

                    }
                }, model);
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
        return layoutCall(
                new PageDescription("resources/tools", "Resources") {

                    @Override
                    protected void initCSS(List<String> pageCSS) {

                    }

                    @Override
                    protected void initJS(List<String> pageJS) {

                    }
                }, model);
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
        return layoutCall(
                new PageDescription("resources/links", "Resources") {

                    @Override
                    protected void initCSS(List<String> pageCSS) {

                    }

                    @Override
                    protected void initJS(List<String> pageJS) {

                    }
                }, model);
    }
}
