package kr.ac.kaist.salab.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by USER on 2016-02-24.
 */
@Entity
@Table(name = "RMemberPublications")
@Getter @Setter
@EqualsAndHashCode
public class RMemberPublication {
    @Id
    @TableGenerator(
            name = "RMPIDGen", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "RMemberInterests",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "RMPIDGen")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PublicationID")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "MemberID")
    private Member member;

    private Integer authorOrder;
}
