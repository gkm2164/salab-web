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
@RequestMapping("/member/rest")
public class MemberRestController {
    @Autowired MemberRepository memberRepository;
    @RequestMapping("/{id}/show")
    public Member findOne(@PathVariable Integer id) {
        return memberRepository.findOne(id);
    }

    @RequestMapping("/{id}/show/pub")
    public List<Publication> findPubs(@PathVariable Integer id) {
        System.out.println("Number of author: " + memberRepository.findOne(id).getPublications().get(0).getMemberList().size());
        return memberRepository.findOne(id).getPublications();
    }
}
