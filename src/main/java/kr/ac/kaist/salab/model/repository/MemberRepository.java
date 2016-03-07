package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 2016-02-24.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findByDegreeAndGraduated(String degree, boolean graduated);

    @Query("select m from Member m where m.degree <> 'external' and m.graduated = true")
    List<Member> findAlumni();

    @Query("select m from Member m where m.degree <> 'external' and m.graduated = true and m.graduatedYear = ?1")
    List<Member> findAlumniByGraduatedYear(Integer year);
}
