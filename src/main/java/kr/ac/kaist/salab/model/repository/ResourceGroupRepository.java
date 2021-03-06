package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.ResourceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by USER on 2016-03-03.
 */
@Repository
public interface ResourceGroupRepository extends JpaRepository<ResourceGroup, Integer> {
}
