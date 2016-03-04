package kr.ac.kaist.salab.controller.rest;

import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.repository.PublicationRepository;
import kr.ac.kaist.salab.model.repository.RMemberPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by USER on 2016-02-25.
 */
@RestController
@RequestMapping("/pubs/rest")
public class PublicationRestController {
    @Autowired
    private PublicationRepository pr;

    @Autowired
    private RMemberPublicationRepository rmpr;

    @RequestMapping
    public List<Publication> findAll() {
        pr.findAll().forEach((x)->System.out.println(x.toString()));
        return pr.findAll();
    }

    @RequestMapping("/{id}/authors")
    public List<Member> authors(@PathVariable Integer id) {
        Publication pub = pr.findOne(id);
        List<Member> authors = pr.findOne(id).getMemberList();
        authors.sort((a, b) -> rmpr.findByPublicationAndMember(pub, a).getAuthorOrder()
                                - rmpr.findByPublicationAndMember(pub, b).getAuthorOrder());

        return authors;
    }
}
