package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.types.PublicationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 2016-02-25.
 */
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    @Query("SELECT m FROM Publication p, RMemberPublication rmi, Member m WHERE p = rmi.publication AND rmi.member = m AND p.id = ?1 ORDER BY rmi.authorOrder ASC")
    List<Member> findByIdOrderByAuthorOrder(Integer id);

    List<Publication> findByPublicationTypeOrderByDateDesc(PublicationType type);
}
