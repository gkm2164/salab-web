package kr.ac.kaist.salab.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Created by USER on 2016-02-23.
 */
@Entity
@Table(name = "Courses")
public class Course {
    @Id @TableGenerator(name = "CourseIDGen", table = "SurrogateKeys",
    pkColumnName = "TableName", pkColumnValue = "Courses",
    valueColumnName = "KeyValue", initialValue = 0,
    allocationSize = 1
    )
    private Integer id;
    private String courseId;
    private String title;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
