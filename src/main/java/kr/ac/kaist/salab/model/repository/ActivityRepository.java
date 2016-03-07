package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by USER on 2016-03-07.
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
