package kr.ac.kaist.salab.model.entity;

import kr.ac.kaist.salab.model.entity.types.CourseType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
@Getter @Setter
@EqualsAndHashCode
public class Course {
    @Id @TableGenerator(
        name = "CourseIDGen", table = "SurrogateKeys",
        pkColumnName = "TableName", pkColumnValue = "Courses",
        valueColumnName = "KeyValue", initialValue = 0,
        allocationSize = 1
    ) @GeneratedValue(strategy = GenerationType.TABLE, generator = "CourseIDGen")
    private Integer id;

    private String courseId;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    private String title;

    private String description;

}
