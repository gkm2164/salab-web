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

    PageDescription coursePageDesc =
            new PageDescription("courses/courses", "Courses",
                    (css, js) -> {
                        css.add("courses.css");
                        js.add("salab.courses.js");
                    });

    @Autowired private CourseRepository cr;

    @RequestMapping
    public String courses(Model model) {
        List<Course> courses = cr.findAll();
        model.addAttribute("courses", courses);
        return layoutCall(coursePageDesc, model);
    }
}
