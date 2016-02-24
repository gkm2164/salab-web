package kr.ac.kaist.salab.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by USER on 2016-02-24.
 */
@Entity
@Table(name = "RMemberInterests")
@Getter @Setter
@EqualsAndHashCode
public class RMemberInterest {
    @Id @TableGenerator(
            name = "RMIIDGen", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "RMemberInterests",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "RMIIDGen")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "InterestID")
    private Interest interest;

    @ManyToOne
    @JoinColumn(name = "MemberID")
    private Member member;
}
