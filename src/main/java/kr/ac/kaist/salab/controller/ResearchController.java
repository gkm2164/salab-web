package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Interest;
import kr.ac.kaist.salab.model.repository.InterestRepository;
import kr.ac.kaist.salab.model.repository.RMemberInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by gyeongmin on 2016. 3. 2..
 */
@Controller
@RequestMapping("/research")
@NavigationTop(
    @NavigationDesc(
        id = "research",
        name = "Researches",
        link = "/research",
        order = 3
    )
)
public class ResearchController extends LayoutController {
    @Autowired private InterestRepository ir;
    @Autowired private RMemberInterestRepository rmir;

    @RequestMapping
    public String researchSite(Model model) {
        List<Interest> interestList = ir.findAll();

        interestList.sort((a, b) -> rmir.countWithInterest(a) - rmir.countWithInterest(b));
        model.addAttribute("researches", interestList);
        return layoutCall(new PageDescription("research/home", "Researches") {
            @Override
            protected void initCSS(List<String> pageCSS) {
                pageCSS.add("research.list.css");
            }

            @Override
            protected void initJS(List<String> pageJS) {

            }
        }, model);
    }
}
