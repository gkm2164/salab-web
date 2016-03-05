package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by USER on 2016-03-04.
 */
@Controller
@RequestMapping("/admin/member")
public class MemberAdmin extends LayoutController {
    @Autowired private MemberRepository mr;

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String createMember(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("degreeList", new Degrees().degreeList);
        return layoutCall(new DefaultPageDesc("admin/member", "Create member"), model);
    }

    public class Degrees {

        private List<Degree> degreeList;

        public Degrees() {
            degreeList = new ArrayList<>();
            degreeList.add(new Degree("prof", "Professor"));
            degreeList.add(new Degree("phd", "Ph. D. Student"));
            degreeList.add(new Degree("ms", "Masters Student"));
            degreeList.add(new Degree("external", "External Member"));
        }

        @Data
        @AllArgsConstructor
        public class Degree {
            private String degree;
            private String label;
        }
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String createMember(@ModelAttribute Member member, BindingResult memberBindingResult) {
        if (memberBindingResult.hasErrors()) {
            memberBindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.toString());
            });

            return "redirect:/admin/member";
        }

        mr.save(member);
        return "redirect:/member";
    }
}