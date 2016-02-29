package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 2016-02-24.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findByDegree(String degree);
}
