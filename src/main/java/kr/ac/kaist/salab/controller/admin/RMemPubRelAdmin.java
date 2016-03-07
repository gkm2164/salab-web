package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.RMemberPublication;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import kr.ac.kaist.salab.model.repository.PublicationRepository;
import kr.ac.kaist.salab.model.repository.RMemberPublicationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by USER on 2016-03-04.
 */
@Controller
@RequestMapping(path = "/admin/mempubrel")
public class RMemPubRelAdmin extends LayoutController {
    @Autowired private PublicationRepository pr;
    @Autowired private MemberRepository mr;
    @Autowired private RMemberPublicationRepository rmpr;

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String addRelation(Model model) {
        List<Member> memberList = mr.findAll();
        memberList.sort((a, b) -> a.getName().compareTo(b.getName()));

        List<Publication> publications = pr.findAll();

        publications.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));

        model.addAttribute("members", memberList);
        model.addAttribute("publications", publications);
        model.addAttribute("relation", new Relation());

        PageDescription rmpraPageDesc =
                new PageDescription("admin/mempubrel", "Publication Relation",
                        (css, js) -> {
                            js.add("salab.admin.mempubrel.js");
                        });
        return layoutCall(rmpraPageDesc, model);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String addRelation(@ModelAttribute Relation relation, BindingResult br) {
        Publication pub = pr.findOne(relation.pubId);
        Member member = mr.findOne(relation.memberId);

        RMemberPublication rmp = rmpr.findByPublicationAndMember(pub, member);

        if (rmp != null) {
            return "redirect:/admin/mempubrel/new";
        }

        rmp = new RMemberPublication();
        rmp.setPublication(pub);
        rmp.setMember(member);
        rmp.setAuthorOrder(relation.order);
        rmpr.save(rmp);

        return "redirect:/admin/mempubrel/new";
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Relation {
        private Integer pubId;
        private Integer memberId;
        private Integer order;
    }
}
