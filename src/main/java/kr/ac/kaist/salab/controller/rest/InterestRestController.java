package kr.ac.kaist.salab.controller.rest;

import kr.ac.kaist.salab.model.entity.Interest;
import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.repository.InterestRepository;
import kr.ac.kaist.salab.model.repository.RMemberInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interest/rest")
public class InterestRestController {
    @Autowired private InterestRepository ir;
    @Autowired private RMemberInterestRepository rmir;

    @RequestMapping("/list")
    public List<Interest> findAll() {

        return ir.findAll();
    }

    @RequestMapping(value = "/{id}/member", method = RequestMethod.POST)
    public List<Member> findAllMember(@PathVariable Integer id) {
        return ir.findOne(id).getMemberList();
    }
}