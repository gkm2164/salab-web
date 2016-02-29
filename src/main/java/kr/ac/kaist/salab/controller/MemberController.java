package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.NavReverseMap;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gyeongmin on 2016. 2. 28..
 */
@Controller
@RequestMapping("/member")
public class MemberController extends LayoutController {
    @Autowired MemberRepository mr;
    @Autowired NavReverseMap nrm;

    @RequestMapping
    public String memberMain(Model model) {
        System.out.println(nrm.get("home"));
        model.addAttribute("LNAVS", nrm.get("member").getChilds());

        return layoutCall(new PageDescription("member/home", "Member Home") {
            @Override
            protected void initCSS(List<String> pageCSS) {
            }

            @Override
            protected void initJS(List<String> pageJS) {
            }
        }, model);
    }

    private static final Map<String, String> statusMap = new HashMap<>();

    static {
        statusMap.put("phd", "Ph. D. Students");
        statusMap.put("ms", "M.S. Students");
    }

    @RequestMapping("/{code}")
    public String members(@PathVariable String code, Model model) {
        List<Member> members = mr.findByDegree(code);
        model.addAttribute("status", statusMap.get(code));
        model.addAttribute("members", members);
        model.addAttribute("LNAVS", nrm.get("member").getChilds());
        return layoutCall(new PageDescription("member/common", statusMap.get(code) + " List") {
            @Override
            protected void initCSS(List<String> pageCSS) {

            }

            @Override
            protected void initJS(List<String> pageJS) {

            }
        }, model);
    }
}
