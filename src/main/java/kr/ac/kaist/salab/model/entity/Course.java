package kr.ac.kaist.salab.model.entity;

import kr.ac.kaist.salab.model.entity.types.CourseType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Courses")
@Getter @Setter
@EqualsAndHashCode(exclude = "courseCodeList")
public class Course {
    @Id @TableGenerator(
        name = "CourseIDGen", table = "SurrogateKeys",
        pkColumnName = "TableName", pkColumnValue = "Courses",
        valueColumnName = "KeyValue", initialValue = 0,
        allocationSize = 1
    ) @GeneratedValue(strategy = GenerationType.TABLE, generator = "CourseIDGen")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    private String title;

    private String description;

    private String link;

    @OneToMany(mappedBy = "course")
    private List<CourseCode> courseCodeList;

    public String getCodes() {
        StringBuilder sb = new StringBuilder();

        List<CharSequence> csList = new ArrayList<>();
        courseCodeList.forEach(x -> csList.add(x.getCode()));

        return String.join("/", csList::iterator);
    }
}
