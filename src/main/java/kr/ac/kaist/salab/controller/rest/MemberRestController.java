package kr.ac.kaist.salab.controller.rest;

import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by USER on 2016-02-24.
 */
@RestController
@RequestMapping("/members/rest")
public class MemberRestController {
    @Autowired MemberRepository memberRepository;
    @RequestMapping("/{id}/show")
    public Member findOne(@PathVariable Integer id) {
        return memberRepository.findOne(id);
    }

    @RequestMapping("/{id}/show/pub")
    public List<Publication> findPubs(@PathVariable Integer id) {
        List<Publication> listPubs = memberRepository.findOne(id).getPublications();

        System.out.println ("* " + listPubs);

        return listPubs;
    }
}
