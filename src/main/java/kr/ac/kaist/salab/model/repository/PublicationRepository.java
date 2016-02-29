package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Publication;
import kr.ac.kaist.salab.model.entity.PublicationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 2016-02-25.
 */
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    List<Publication> findByPublicationType(PublicationType type);
}