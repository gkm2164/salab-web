package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.types.PublicationType;
import kr.ac.kaist.salab.model.helper.PublicationAuthorSortHelper;
import kr.ac.kaist.salab.model.helper.PublicationStringCreationHelper;
import kr.ac.kaist.salab.model.repository.PublicationRepository;
import kr.ac.kaist.salab.model.repository.RMemberPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-02-24.
 */
@Controller
@RequestMapping("/pubs")
@NavigationTop(
    @NavigationDesc(
        id = "pubs",
        name = "Publications",
        link = "/pubs",
        order = 4
    )
)
public class PublicationController extends LayoutController {
    @Autowired PublicationRepository pr;
    @Autowired RMemberPublicationRepository rmpr;
    @Autowired
    PublicationAuthorSortHelper pash;
    @Autowired
    PublicationStringCreationHelper psch;

    @RequestMapping
    public String pubPage(Model model) {

        List<PublicationCategory> pubs = new ArrayList<>();

        pubs.add(
                new PublicationCategory("SCI/SCIE Journal Papers",
                        psch.toList(pr.findByPublicationType(PublicationType.SCI_JOURNAL), true)
                )
        );

        pubs.add(
                new PublicationCategory("SCI/SCIE Journal Papers",
                        psch.toList(pr.findByPublicationType(PublicationType.SCI_JOURNAL), true)
                )
        );
        pubs.add(
                new PublicationCategory("Other International Journal Papers",
                        psch.toList(pr.findByPublicationType(PublicationType.INTERNATIONAL_JOURNAL), true)
                )
        );
        pubs.add(
                new PublicationCategory("International Conference Papers",
                        psch.toList(pr.findByPublicationType(PublicationType.INTERNATIONAL_CONFERENCE), true)
                )
        );
        pubs.add(
                new PublicationCategory("Domestic Journal Papers",
                        psch.toList(pr.findByPublicationType(PublicationType.DOMESTIC_JOURNAL), true)
                )
        );
        pubs.add(
                new PublicationCategory("Domestic Conference Papers",
                        psch.toList(pr.findByPublicationType(PublicationType.DOMESTIC_CONFERENCE), true)
                )
        );

        model.addAttribute("PUBS", pubs);

        PageDescription pubPageDesc =
                new PageDescription("pubs/home", "Publications",
                        (css, js) -> css.add("pubs.home.css"));

        return layoutCall(pubPageDesc, model);
    }

    public class PublicationCategory {
        private String name;
        private List<String> list;

        public PublicationCategory(String name, List<String> list) {
            this.name = name;
            this.list = list;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getList() {
            return list;
        }
    }
}
