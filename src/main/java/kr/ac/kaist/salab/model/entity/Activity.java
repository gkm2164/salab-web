package kr.ac.kaist.salab.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Activities",
        indexes = {
                @Index(columnList = "Date")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @TableGenerator(
            name = "ActivityIDGen", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Activities",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "ActivityIDGen")
    private Integer id;

    private String title;

    private String contents;

    private Date date;
}
