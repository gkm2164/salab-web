package kr.ac.kaist.salab.config;

import kr.ac.kaist.salab.controller.HomeController;
import kr.ac.kaist.salab.controller.navs.NavNode;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationBuilder;
import kr.ac.kaist.salab.model.helper.PublicationStringCreationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class BeanDefinitions {

    @Bean
    @Autowired
    public NavNode navNode() {
        NavigationBuilder nb = new NavigationBuilder(HomeController.class);
        return nb.getRoot();
    }

    @Bean
    public PublicationStringCreationHelper publicationStringCreationHelper() {
        return new PublicationStringCreationHelper();
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setViewClass(JstlView.class);
        irvr.setPrefix("/WEB-INF/jsps/");
        irvr.setSuffix(".jsp");
        return irvr;
    }
}
