package kr.ac.kaist.salab.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by USER on 2016-02-24.
 */
@Entity
@Table(name = "Interests")
@Getter @Setter
@EqualsAndHashCode(exclude = "memberList")
public class Interest {
    @Id @TableGenerator(
            name = "InterestIDGenerator", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Interests",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "InterestIDGenerator")
    private Integer id;

    private String fieldName;

    @Basic(optional = true)
    private String fieldDesc;

    @ManyToMany
    @JoinTable(
            name = "RMemberInterests",
            joinColumns = @JoinColumn(name = "InterestID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MemberID", referencedColumnName = "ID")
    )
    @JsonBackReference
    private List<Member> memberList;
}
