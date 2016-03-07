package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Interest;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.RMemberInterest;
import kr.ac.kaist.salab.model.repository.InterestRepository;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import kr.ac.kaist.salab.model.repository.PublicationRepository;
import kr.ac.kaist.salab.model.repository.RMemberInterestRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gyeongmin on 3/7/16.
 */
@Controller
@RequestMapping("/admin/memintrel")
public class RMemIntRelAdmin extends LayoutController {
    @Autowired private InterestRepository ir;
    @Autowired private MemberRepository mr;
    @Autowired private RMemberInterestRepository rmir;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newRelation(Model model) {
        PageDescription nrPageDesc = new PageDescription(
                "admin/memintrel", "New Relation",
                (css, js) -> {
                }
        );
        model.addAttribute("relation", new RMIBox ());
        model.addAttribute("interests", ir.findAll());
        model.addAttribute("members", mr.findAll());

        return layoutCall(nrPageDesc, model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String newRelation(@ModelAttribute RMIBox rmib, BindingResult br) {
        if (br.hasErrors()) {
            return "redirect:/admin/memintrel/new";
        }

        Interest i = ir.findOne(rmib.intId);
        Member m = mr.findOne(rmib.memId);

        RMemberInterest rmi = new RMemberInterest();
        rmi.setInterest(i);
        rmi.setMember(m);

        rmir.save(rmi);
        return "redirect:/admin/memintrel/new";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RMIBox {
        private Integer intId;
        private Integer memId;
    }
}
