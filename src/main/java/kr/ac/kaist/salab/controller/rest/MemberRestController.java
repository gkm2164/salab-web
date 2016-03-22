package kr.ac.kaist.salab.controller.rest;

import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.repository.MemberRepository;
import kr.ac.kaist.salab.util.HashMapLinked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member/rest")
public class MemberRestController {
    @Autowired private MemberRepository memberRepository;
    @RequestMapping("/{id}/show")
    public Member findOne(@PathVariable Integer id) {
        return memberRepository.findOne(id);
    }

    @RequestMapping("/{id}/show/pub")
    public List<Publication> findPubs(@PathVariable Integer id) {
        return memberRepository.findOne(id).getPublications();
    }

    @RequestMapping("/alumni")
    private Map<Integer, List<Member>> constructHashMapAlumni() {
        HashMapLinked<Integer, Member> hml = new HashMapLinked<>();
        List<Member> members = memberRepository.findAlumni();
        members.forEach((x) -> hml.add(x.getGraduatedYear(), x));

        return hml;
    }
}
