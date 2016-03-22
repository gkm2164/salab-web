package kr.ac.kaist.salab.model.entity;

import kr.ac.kaist.salab.model.entity.types.PublicationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Publications")
@Getter@Setter
@EqualsAndHashCode(exclude = "memberList")
public class Publication {
    @Id @TableGenerator(
            name = "PublicationIDGenerator", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Publications",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PublicationIDGenerator")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PublicationType publicationType;

    private String title;

    private String metadata;

    private Date date;

    @ManyToMany
    @JoinTable(
            name = "RMemberPublications",
            joinColumns =
            @JoinColumn(
                    table = "Publications",
                    name = "PublicationID",
                    referencedColumnName = "ID"
            ),
            inverseJoinColumns =
            @JoinColumn(
                    table = "Members",
                    name = "MemberID",
                    referencedColumnName = "ID"),
            indexes = @Index(columnList = "AuthorOrder")
    )
    private List<Member> memberList;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Don't use it!!");
    }

}
