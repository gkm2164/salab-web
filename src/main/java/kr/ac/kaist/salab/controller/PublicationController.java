package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.types.PublicationType;
import kr.ac.kaist.salab.model.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public class PublicationCategory {
        private String name;
        private List<Publication> list;

        public PublicationCategory(String name, List<Publication> list) {
            this.name = name;
            this.list = list;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Publication> getList() {
            return list;
        }

        public void setList(List<Publication> list) {
            this.list = list;
        }
    }

    @RequestMapping
    public String pubPage(Model model) {

        PublicationCategory[] pubs = {
                new PublicationCategory("SCI/SCIE Journal Papers",
                        pr.findByPublicationType(PublicationType.SCI_JOURNAL)),
                new PublicationCategory("Other International Journal Papers",
                        pr.findByPublicationType(PublicationType.INTERNATIONAL_JOURNAL)),
                new PublicationCategory("International Conference Papers",
                        pr.findByPublicationType(PublicationType.INTERNATIONAL_CONFERENCE)),
                new PublicationCategory("Domestic Journal Papers",
                        pr.findByPublicationType(PublicationType.DOMESTIC_JOURNAL)),
                new PublicationCategory("Domestic Conference Papers",
                        pr.findByPublicationType(PublicationType.DOMESTIC_CONFERENCE))
        };

        model.addAttribute("PUBS", pubs);

        return layoutCall(new PublicationPageDescription(), model);
    }

    public class PublicationPageDescription extends PageDescription {

        protected PublicationPageDescription() {
            super("pubs/home", "Publications");
        }

        @Override
        protected void initCSS(List<String> pageCSS) {
            pageCSS.add("pubs.home.css");
        }

        @Override
        protected void initJS(List<String> pageJS) {

        }
    }
}
