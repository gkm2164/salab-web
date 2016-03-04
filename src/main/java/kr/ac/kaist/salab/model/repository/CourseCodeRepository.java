package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.CourseCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by USER on 2016-03-04.
 */
@Repository
public interface CourseCodeRepository extends JpaRepository<CourseCode, Integer> {
    CourseCode findByCode(String code);
}
