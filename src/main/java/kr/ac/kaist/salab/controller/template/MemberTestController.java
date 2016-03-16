package kr.ac.kaist.salab.controller.template;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;

/**
 * Created by USER on 2016-03-16.
 */
//@RequestMapping("/" + MemberTestController.CONTROLLER_NAME)
public class MemberTestController extends LayoutController {
    public static final String CONTROLLER_NAME = "memtest";
    EntityMapper<Entity, Member> em = (i, o) -> {
        o.setId(i.getId());
        o.setName(i.getName());
        o.setKoreanName(i.getKoreanName());
        o.setDegree(i.getDegree());
        o.setLink(i.getLink());
        o.setEnterDate(i.getEnterDate());
        o.setGraduated(i.isGraduated());
        o.setGraduatedYear(i.getGraduatedYear());
    };
    EntityMapper<Member, Entity> revEm = (i, o) -> {
        o.setId(i.getId());
        o.setName(i.getName());
        o.setKoreanName(i.getKoreanName());
        o.setDegree(i.getDegree());
        o.setLink(i.getLink());
        o.setEnterDate(i.getEnterDate());
        o.setGraduated(i.getGraduated());
        o.setGraduatedYear(i.getGraduatedYear());
    };

    /* Creation */
//    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model) {

        model.addAttribute("member", new Entity());

        PageDescription pageDesc = new ThisDefaultPageDesc("new", "New");
        return layoutCall(pageDesc, model);
    }

    //    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String create(@ModelAttribute Entity entity, BindingResult bindingResult) {
        /* TODO: Save action */
        return "redirect:/" + CONTROLLER_NAME + "/new";
    }

    /* Retrieve */
//    @RequestMapping
    public String listAll(Model model) {

        PageDescription pageDesc = new ThisDefaultPageDesc("list", "List All");
        return layoutCall(pageDesc, model);
    }

    //    @RequestMapping("/{id}/show")
    public String showOne(@PathVariable Integer id, Model model) {

        PageDescription pageDesc = new ThisDefaultPageDesc("show", "Show one");
        return layoutCall(pageDesc, model);
    }

    /* Update */
//    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable Integer id, Model model) {
        /**/

        PageDescription pageDesc = new ThisDefaultPageDesc("update", "Update");
        return layoutCall(pageDesc, model);
    }

    //    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, @ModelAttribute Entity entity, BindingResult entityBindingResult) {
        /* TODO: Update work */
        return "redirect:/" + CONTROLLER_NAME + "/" + id + "/show";
    }

    /* Delete */
//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        /* TODO: Deletion work */

        return "redirect:/" + CONTROLLER_NAME;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Entity {
        private Integer id;
        private String name;
        private String koreanName;
        private String degree;
        private String link;
        private Date enterDate;
        private boolean graduated;
        private Integer graduatedYear;
    }

    private class ThisDefaultPageDesc extends DefaultPageDesc {

        public ThisDefaultPageDesc(String viewName, String title) {
            super(CONTROLLER_NAME + "/" + viewName, title);
        }
    }
}
