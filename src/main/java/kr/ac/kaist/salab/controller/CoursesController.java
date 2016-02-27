package kr.ac.kaist.salab.controller;

import kr.ac.kaist.salab.controller.page.LayoutController;
import kr.ac.kaist.salab.controller.page.PageDescription;
import kr.ac.kaist.salab.model.entity.Course;
import kr.ac.kaist.salab.model.repository.CourseXMLRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by USER on 2016-02-23.
 */
@Controller
@RequestMapping("/courses")
public class CoursesController extends LayoutController {

    @RequestMapping
    public String courses(Model model) {
        List<Course> courses = new CourseXMLRepository().findAll();
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
