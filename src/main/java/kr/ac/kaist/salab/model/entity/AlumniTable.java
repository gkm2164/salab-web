package kr.ac.kaist.salab.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by USER on 2016-03-16.
 */
@Entity
@Table(name = "AlumniTable")
@Getter
@Setter
@EqualsAndHashCode
public class AlumniTable {
    @Id
    @TableGenerator(
            name = "ATIDGen", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "AlumniTable",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "ATIDGen"
    )
    private Integer id;

    @OneToOne
    @JoinColumn(name = "MemberID")
    @JsonBackReference
    private Member member;

    private String currentWork;
}
