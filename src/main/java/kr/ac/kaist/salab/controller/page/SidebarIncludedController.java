package kr.ac.kaist.salab.controller.page;

import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by USER on 2016-02-26.
 */
public abstract class SidebarIncludedController extends LayoutController {
    public String layoutCall(PageDescription pageDescription, Model model) {
        PageDescription pd = new EmptyViewPageDescription("sidebar.jsp", pageDescription.getTitle());
        model.addAttribute("LNAVS", null);
        return super.layoutCall(pd, model);
    }

    public class EmptyViewPageDescription extends PageDescription {
        protected EmptyViewPageDescription(String pageFileName, String title) {
            super(pageFileName, title);
        }

        @Override
        protected void initCSS(List<String> pageCSS) { }

        @Override
        protected void initJS(List<String> pageJS) { }
    }
}
