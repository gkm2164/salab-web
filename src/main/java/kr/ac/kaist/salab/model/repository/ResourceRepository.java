package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Resource;
import kr.ac.kaist.salab.model.entity.types.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gyeongmin on 2016. 3. 2..
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    List<Resource> findByResourceType(ResourceType resourceType);
}
