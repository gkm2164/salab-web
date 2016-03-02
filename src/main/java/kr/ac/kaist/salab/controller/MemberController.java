package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationItem;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gyeongmin on 2016. 2. 28..
 */
@Controller
@RequestMapping("/member")
@NavigationTop(
    @NavigationDesc(
        id = "member",
        name = "Member",
        link = "/member",
        order = 2
    )
)
public class MemberController extends LayoutController {

    @Autowired MemberRepository mr;

    @RequestMapping
    public String memberMain(Model model) {
        setLocalNav("member");
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
        statusMap.put("prof", "Professors");
        statusMap.put("phd", "Ph. D. Students");
        statusMap.put("ms", "M.S. Students");
    }

    public String memberStatus(String code, Model model) {
        List<Member> members = mr.findByDegree(code);
        setLocalNav("member");
        model.addAttribute("status", statusMap.get(code));
        model.addAttribute("members", members);
        return layoutCall(new PageDescription("member/common", statusMap.get(code) + " List") {
            @Override
            protected void initCSS(List<String> pageCSS) {
                pageCSS.add("members.css");
            }

            @Override
            protected void initJS(List<String> pageJS) {

            }
        }, model);
    }

    @RequestMapping("/prof")
    @NavigationItem(
        @NavigationDesc(
            id = "prof",
            name = "Professor",
            link = "/prof",
            order = 0
        )
    )
    public String memberProf(Model model) {
        return memberStatus("prof", model);
    }

    @RequestMapping("/phd")
    @NavigationItem(
        @NavigationDesc(
            id = "phd",
            name = "Ph.D. Candidates",
            link = "/phd",
            order = 1
        )
    )
    public String memberPhD(Model model) {
        return memberStatus("phd", model);
    }

    @RequestMapping("/ms")
    @NavigationItem(
        @NavigationDesc(
            id = "ms",
            name = "Masters Candidates",
            link = "/ms",
            order = 2
        )
    )
    public String membersMS(Model model) {
        return memberStatus("ms", model);
    }

    @RequestMapping("/alumni")
    @NavigationItem(
        @NavigationDesc(
            id = "alumni",
            name = "Alumni",
            link = "/alumni",
            order = 3
        )
    )
    public String memberAlumni(Model model) {
        return memberStatus("alumni", model);
    }
}
