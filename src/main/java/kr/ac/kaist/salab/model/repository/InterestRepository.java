package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gyeongmin on 2016. 3. 2..
 */
@Repository
public interface InterestRepository extends JpaRepository<Interest, Integer> {
}
