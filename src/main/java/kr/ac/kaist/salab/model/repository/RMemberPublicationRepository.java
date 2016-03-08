package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.RMemberPublication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 2016-03-04.
 */
@Repository
public interface RMemberPublicationRepository extends JpaRepository<RMemberPublication, Integer>{
    RMemberPublication findByPublicationAndMember(Publication pub, Member member);

    List<RMemberPublication> findByPublicationOrderByAuthorOrderAsc(Publication pub);
}
