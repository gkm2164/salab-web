package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.RMemberPublication;
import kr.ac.kaist.salab.model.entity.types.PublicationType;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-03-04.
 */
@Controller
@RequestMapping("/admin/publication")
public class PublicationAdmin extends LayoutController {
    @Autowired private PublicationRepository pr;
    @Autowired private MemberRepository mr;
    @Autowired private RMemberPublicationRepository rmpr;

    @RequestMapping(path = "/addrel", method = RequestMethod.GET)
    public String addRelation(Model model) {
        List<Member> memberList = mr.findAll();
        memberList.sort((a, b) -> a.getName().compareTo(b.getName()));
        model.addAttribute("members", memberList);
        model.addAttribute("publications", pr.findAll());
        model.addAttribute("relation", new Relation());

        return layoutCall(new PageDescription("admin/pub.addrel", "Publication Relation") {
            @Override
            protected void initCSS(List<String> pageCSS) {

            }

            @Override
            protected void initJS(List<String> pageJS) {

            }
        }, model);
    }

    @RequestMapping(path = "/addrel", method = RequestMethod.POST)
    public String addRelation(@ModelAttribute Relation relation, BindingResult br) {
        Publication pub = pr.findOne(relation.pubId);
        Member member = mr.findOne(relation.memberId);

        RMemberPublication rmp = rmpr.findByPublicationAndMember(pub, member);

        if (rmp != null) {
            return "redirect:/admin/publication/adrel";
        }

        rmp = new RMemberPublication();
        rmp.setPublication(pub);
        rmp.setMember(member);
        rmp.setAuthorOrder(relation.order);
        rmpr.save(rmp);

        return "redirect:/pubs";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createPublication(Model model) {
        model.addAttribute("publication", new Publication());
        model.addAttribute("pubTypes", new TypeValues().pubTypes);
        return layoutCall(new PageDescription("admin/publication", "Create Publication") {
            @Override
            protected void initCSS(List<String> pageCSS) {

            }

            @Override
            protected void initJS(List<String> pageJS) {

            }
        }, model);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createPublication(@ModelAttribute Publication publication, BindingResult pbr) {
        if (pbr.hasErrors()) {
            pbr.getAllErrors().forEach(e -> System.out.println(e.toString()));
            return "redirect:/admin/publication/new";
        }

        pr.save(publication);
        return "redirect:/pubs";
    }

    public class TypeValues {
        private List<TypeValue> pubTypes = new ArrayList<>();

        public TypeValues() {
            for (PublicationType pt: PublicationType.values()) {
                pubTypes.add(new TypeValue (pt.toString(), pt.toString()));
            }
        }

        @Data
        @AllArgsConstructor
        public class TypeValue {
            private String name;
            private String value;
        }
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
