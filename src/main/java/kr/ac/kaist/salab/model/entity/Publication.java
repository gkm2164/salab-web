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
@Table(name = "Publications")
@Getter@Setter
@EqualsAndHashCode(exclude = "memberList")
public class Publication {
    @Id @TableGenerator(
            name = "PublicationIDGenerator", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Publications",
            valueColumnName = "KeyValue", initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PublicationIDGenerator")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PublicationType publicationType;

    private String title;

    private String metadata;

    @ManyToMany
    @JoinTable(
            name = "RMemberPublications",
            joinColumns = @JoinColumn(name = "PublicationID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MemberID", referencedColumnName = "ID")
    )
    @OrderBy("memberOrder")
    @JsonBackReference
    private List<Member> memberList;
}
