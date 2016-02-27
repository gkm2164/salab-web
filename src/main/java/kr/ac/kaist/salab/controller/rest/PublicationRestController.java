package kr.ac.kaist.salab.controller.rest;

import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by USER on 2016-02-25.
 */
@RestController
@RequestMapping("/pubs/rest")
public class PublicationRestController {
    @Autowired PublicationRepository publicationRepository;

    @RequestMapping
    public List<Publication> findAll() {
        publicationRepository.findAll().forEach((x)->System.out.println(x.toString()));
        return publicationRepository.findAll();
    }
}
