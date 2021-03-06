package kr.ac.kaist.salab.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by USER on 2016-02-24.
 */
@Entity
@Table(name = "Members")
@Getter @Setter
@EqualsAndHashCode(exclude = {"interests", "publications", "alumniTable"})
public class Member {
    @Id @TableGenerator(
            name = "MemberIDGenerator", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Members",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MemberIDGenerator")
    private Integer id;

    private String name;

    private String koreanName;

    private String degree;

    @Basic(optional = true)
    private String link;

    private Date enterDate;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean graduated;

    private Integer graduatedYear;

    @OneToOne(mappedBy = "member")
    private AlumniTable alumniTable;

    @ManyToMany
    @JoinTable(
            name = "RMemberInterests",
            joinColumns = @JoinColumn(name = "MemberID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "InterestID", referencedColumnName = "ID")
    )
    @JsonManagedReference
    private List<Interest> interests;

    @ManyToMany
    @JoinTable(
            name = "RMemberPublications",
            joinColumns = @JoinColumn(name = "MemberID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PublicationID", referencedColumnName = "ID")
    )
    @JsonBackReference
    @OrderBy("date desc")
    private List<Publication> publications;

    public String getPageLink(boolean korean) {
        String format = "<a href=\"/member/%d/show\">%s</a>";

        if (korean) {
            return String.format(format, id, koreanName);
        } else {
            return String.format(format, id, name);
        }
    }

    public String toString() {
        String format = "%d: %s(%s)";

        return String.format(format, id, name, koreanName);
    }
}
