package kr.ac.kaist.salab.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by USER on 2016-03-04.
 */
@Entity
@Table(name = "CourseCodes")
@Getter @Setter
@EqualsAndHashCode
public class CourseCode {
    @Id @TableGenerator(
            name = "CCIDGen", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "CourseCodes",
            valueColumnName = "KeyValues", initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CCIDGen")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    private Course course;

    private String code;
}
