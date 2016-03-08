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

    public String toString() {

        switch (publicationType) {
            case SCI_JOURNAL:
            case INTERNATIONAL_JOURNAL:
            case INTERNATIONAL_CONFERENCE:
                return toEnglishString();
            case DOMESTIC_JOURNAL:
            case DOMESTIC_CONFERENCE:
                return toKoreanString();

        }

        return "!!";
    }

    public String toEnglishString() {
        StringBuilder sb = new StringBuilder();

        memberList.forEach((x) -> sb.append(x.getPageLink(false)).append(", "));
        String names = sb.toString();

        return String.format("%s\"%s,\" %s", names, title, metadata);
    }

    public String toKoreanString() {
        StringBuilder sb = new StringBuilder();
        memberList.forEach((x) -> sb.append(x.getPageLink(true)).append(", "));
        String names = sb.toString();

        return String.format("%s\"%s,\" %s", names, title, metadata);
    }
}
