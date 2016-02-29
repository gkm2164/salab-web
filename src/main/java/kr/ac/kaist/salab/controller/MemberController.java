package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.page.LayoutController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gyeongmin on 2016. 2. 28..
 */
@Controller
@RequestMapping("/member")
public class MemberController extends LayoutController {

    @RequestMapping
    public String memberMain() {
        return "member/home";
    }

    @RequestMapping("/{code}")
    public String members(@PathVariable String code) {
        return "member/common";
    }
}
