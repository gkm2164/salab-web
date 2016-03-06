package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Interest;
import kr.ac.kaist.salab.model.entity.RMemberInterest;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by gyeongmin on 3/6/16.
 */
@Repository
public interface RMemberInterestRepository extends JpaRepository<RMemberInterest, Integer>{
    @Query("SELECT count(r) FROM RMemberInterest r WHERE r.interest = ?1")
    Integer countWithInterest(Interest interest);
}
