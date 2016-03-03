package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.navs.annotation.NavigationDesc;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationTop;
import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Course;
import kr.ac.kaist.salab.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courses")
@NavigationTop(
    @NavigationDesc(
        id = "courses",
        name = "Courses",
        link = "/courses",
        order = 5
    )
)
public class CoursesController extends LayoutController {

    @Autowired private CourseRepository cr;
    @RequestMapping
    public String courses(Model model) {
        List<Course> courses = cr.findAll();
        model.addAttribute("courses", courses);
        return layoutCall(new CoursePageDescription(), model);
    }

    public class CoursePageDescription extends PageDescription {
        protected CoursePageDescription() {
            super("courses/courses", "Courses");
        }

        @Override
        protected void initCSS(List<String> pageCSS) {
            pageCSS.add("courses.css");
        }

        @Override
        protected void initJS(List<String> pageJS) {
            pageJS.add("salab.courses.js");
        }
    }
}
