package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationItem;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.helper.PublicationAuthorSortHelper;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import kr.ac.kaist.salab.util.MapperClass;
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

    private static final Map<String, String> statusMap = new HashMap<>();

    static {
        statusMap.put("prof", "Professors");
        statusMap.put("reses", "Researchers");
        statusMap.put("phd", "Ph. D. Students");
        statusMap.put("ms", "M.S. Students");
        statusMap.put("alumni", "Alumni");
    }

    @Autowired MemberRepository mr;
    @Autowired
    PublicationAuthorSortHelper pash;

    @RequestMapping
    public String memberMain(Model model) {
        setLocalNav("member");
        return layoutCall(new DefaultPageDesc("member/home", "Member Home"), model);
    }

    @RequestMapping("/{id}/show")
    public String singleMember(@PathVariable Integer id, Model model) {
        setLocalNav("member");
        Member member = mr.findOne(id);
        model.addAttribute("member", member);
        member.getPublications().forEach(pash::sortByAuthorOrder);

        return layoutCall(new DefaultPageDesc("member/show", "Member Show"), model);
    }

    public String memberStatus(String code, Model model) {
        List<Member> members = mr.findByDegreeAndGraduated(code, false);
        setLocalNav("member");
        model.addAttribute("status", statusMap.get(code));
        model.addAttribute("members", members);

        members.forEach(x -> x.getPublications().forEach(pash::sortByAuthorOrder));
        String title = statusMap.get(code) + " List";
        PageDescription pageDesc =
                new PageDescription("member/common", title,
                        (css, js) -> css.add("members.css"));

        return layoutCall(pageDesc, model);
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
        PageDescription profPageDesc =
                new PageDescription("member/prof", "Professors",
                        (css, js) -> css.add("members.prof.css"));
        return layoutCall(profPageDesc, model);
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

        Map<Integer, List<Member>> map = constructAlumniHashMap();

        List<Integer> years = new ArrayList<>();

        years.addAll(map.keySet());
        years.sort((a, b) -> a - b);
        model.addAttribute("alumniYears", years);

        PageDescription alumniPageDesc =
                new PageDescription("member/alumni", "Alumni",
                        (css, js) -> {
                            css.add("members.alumni.css");
                            css.add("members.css");
                            js.add("salab.members.alumni.js");
                        });
        return layoutCall(alumniPageDesc, model);
    }

    private Map<Integer, List<Member>> constructAlumniHashMap() {

        List<Member> members = mr.findAlumni();

        MapperClass<Member, Integer, Member> mc =
                new MapperClass<>(((data, ctx) -> {
                    Integer key = data.getGraduatedYear();
                    Member value = data;

                    ctx.write(key, value);
                }));

        return mc.map(members);
    }

    @RequestMapping(path = "/alumni/{year}", method = RequestMethod.POST)
    public String memberAlumni(@PathVariable Integer year, Model model) {
        String viewName = "member/common";
        List<Member> members = mr.findAlumniByGraduatedYear(year);

        model.addAttribute("members", members);

        members.forEach(x -> x.getPublications().forEach(pash::sortByAuthorOrder));

        return viewName;
    }
}
