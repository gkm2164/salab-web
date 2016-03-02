package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Interest;
import kr.ac.kaist.salab.model.repository.InterestRepository;
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
public class ResearchController extends LayoutController {
    @Autowired InterestRepository ir;

    @RequestMapping
    public String researchSite(Model model) {
        model.addAttribute("researches", ir.findAll());
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
