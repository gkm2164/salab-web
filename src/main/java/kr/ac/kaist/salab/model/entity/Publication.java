package kr.ac.kaist.salab.model.entity;

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
            inverseJoinColumns = @JoinColumn(name = "MemberID", referencedColumnName = "ID"),
            indexes = @Index(name = "IDX_RMP_AuthorOrder", columnList = "AuthorOrder")
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
        memberList.forEach((x) -> sb.append(x.getName()).append(", "));
        String names = sb.toString();

        return String.format("%s\"%s,\" %s", names, title, metadata);
    }

    public String toKoreanString() {
        StringBuilder sb = new StringBuilder();
        memberList.forEach((x) -> sb.append(x.getKoreanName()).append(", "));
        String names = sb.toString();

        return String.format("%s\"%s,\" %s", names, title, metadata);
    }
}
