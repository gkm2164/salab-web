package kr.ac.kaist.salab.config;

import kr.ac.kaist.salab.controller.HomeController;
import kr.ac.kaist.salab.controller.navs.NavNode;
import kr.ac.kaist.salab.controller.navs.annotation.NavigationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by USER on 2016-02-22.
 */
@Configuration
public class BeanDefinitions {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    @Autowired
    public NavNode navNode() {
        NavigationBuilder nb = new NavigationBuilder(HomeController.class);
        
        return nb.getRoot();
    }
}
