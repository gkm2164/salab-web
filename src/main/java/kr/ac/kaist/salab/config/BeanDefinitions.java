package kr.ac.kaist.salab.config;

import kr.ac.kaist.salab.controller.HomeController;
import kr.ac.kaist.salab.controller.navs.NavNode;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationBuilder;
import kr.ac.kaist.salab.model.helper.PublicationAuthorSortHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by USER on 2016-02-22.
 */
@Configuration
public class BeanDefinitions {

    @Bean
    @Autowired
    public NavNode navNode() {
        NavigationBuilder nb = new NavigationBuilder(HomeController.class);
        
        return nb.getRoot();
    }

    @Bean
    public PublicationAuthorSortHelper publicationAuthorSortHelper() {
        return new PublicationAuthorSortHelper();
    }
}
