package kr.ac.kaist.salab.controller.admin;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.types.PublicationType;
import kr.ac.kaist.salab.model.helper.PublicationStringCreationHelper;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import kr.ac.kaist.salab.model.repository.PublicationRepository;
import kr.ac.kaist.salab.model.repository.RMemberPublicationRepository;
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

@Controller
@RequestMapping("/admin/publication")
public class PublicationAdminController extends LayoutController {
    @Autowired private PublicationRepository pr;
    @Autowired private MemberRepository mr;
    @Autowired private RMemberPublicationRepository rmpr;
    @Autowired
    private PublicationStringCreationHelper psch;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createPublication(Model model) {
        List<String> pubStringList = psch.toList(pr.findAll(), false);

        model.addAttribute("publicationList", pubStringList);
        model.addAttribute("publication", new Publication());
        model.addAttribute("pubTypes", new TypeValues().pubTypes);
        return layoutCall(new DefaultPageDesc("admin/publication", "Create Publication"), model);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createPublication(@ModelAttribute Publication publication, BindingResult pbr) {
        if (pbr.hasErrors()) {
            pbr.getAllErrors().forEach(e -> System.out.println(e.toString()));
            return "redirect:/admin/publication/new";
        }

        Publication p = pr.save(publication);
        return "redirect:/admin/mempubrel/new?pubId=" + p.getId();
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


}

