package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationItem;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import kr.ac.kaist.salab.util.HashMapLinked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        statusMap.put("reses", "Researchers");
        statusMap.put("phd", "Ph. D. Students");
        statusMap.put("ms", "M.S. Students");
        statusMap.put("alumni", "Alumni");
    }

    public String memberStatus(String code, Model model) {
        List<Member> members = mr.findByDegreeAndGraduated(code, false);
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
        setLocalNav("member");
        return layoutCall(new PageDescription("member/prof", "Professors") {
            @Override
            protected void initCSS(List<String> pageCSS) {
                pageCSS.add("members.prof.css");
            }

            @Override
            protected void initJS(List<String> pageJS) {

            }
        }, model);
    }

    @RequestMapping("/reses")
    @NavigationItem(
            value = @NavigationDesc(
                    id = "reses",
                    name = "Researchers",
                    link = "/reses",
                    order = 1
            ),
            exposeOnGlobalNav = false,
            exposeOnLocalNav = false
    )
    public String memberResearchers(Model model) {
        return memberStatus("reses", model);
    }

    @RequestMapping("/phd")
    @NavigationItem(
        @NavigationDesc(
            id = "phd",
            name = "Ph.D. Candidates",
            link = "/phd",
            order = 2
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
            order = 3
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
            order = 4
        )
    )
    public String memberAlumni(Model model) {
        setLocalNav("member");
        Map<Integer, List<Member>> map = constructHashMapAlumni();
        List<Integer> years = new ArrayList<>();
        years.addAll(map.keySet());
        years.sort((a, b) -> a - b);
        model.addAttribute("alumniYears", years);
        return layoutCall(new PageDescription("member/alumni", "Alumni") {
            @Override
            protected void initCSS(List<String> pageCSS) {
                pageCSS.add("members.alumni.css");
                pageCSS.add("members.css");
            }

            @Override
            protected void initJS(List<String> pageJS) {
                pageJS.add("salab.members.alumni.js");
            }
        }, model);
    }

    private Map<Integer, List<Member>> constructHashMapAlumni() {
        HashMapLinked<Integer, Member> hml = new HashMapLinked<>();
        List<Member> members = mr.findAlumni();
        members.forEach((x) -> hml.add(x.getGraduatedYear(), x));

        return hml;
    }

    @RequestMapping(path = "/alumni/{year}", method = RequestMethod.POST)
    public String memberAlumni(@PathVariable Integer year, Model model) {
        List<Member> members = mr.findAlumniByGraduatedYear(year);
        model.addAttribute("members", members);
        return "member/common";
    }
}
