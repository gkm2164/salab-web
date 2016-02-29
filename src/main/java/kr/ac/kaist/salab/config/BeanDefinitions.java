package kr.ac.kaist.salab.config;

import kr.ac.kaist.salab.controller.navs.NavNode;
import kr.ac.kaist.salab.controller.navs.NavReader;
import kr.ac.kaist.salab.controller.navs.NavReverseMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.xml.sax.SAXException;

import java.io.IOException;

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
    public NavReader navReader() {
        return new NavReader();
    }

    @Bean
    @Autowired
    public NavNode navNode(NavReader navReader) {
        NavNode navNode = null;

        try {
            navNode = navReader.readFile("prop/salab-nav.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return navNode;
    }

    @Bean
    @Autowired
    public NavReverseMap reverseMap(NavReader navReader) {
        return navReader.getReverseMap();
    }
}
