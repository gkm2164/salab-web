package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by gyeongmin on 2016. 2. 28..
 */
@Controller
@RequestMapping("/member")
public class MemberController extends LayoutController {
    @Autowired MemberRepository mr;

    @RequestMapping
    public String memberMain(Model model) {

        return "member/home";
    }

    @RequestMapping("/{code}")
    public String members(@PathVariable String code, Model model) {
        List<Member> members = mr.findByDegree(code);
        model.addAttribute("members", members);
        return "member/common";
    }
}
