package kr.ac.kaist.salab.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by USER on 2016-02-23.
 */
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
    private String title;
    private String description;
}
