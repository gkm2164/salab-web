package kr.ac.kaist.salab.model.entity;

import kr.ac.kaist.salab.model.entity.types.ResourceType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gyeongmin on 2016. 3. 2..
 */
@Entity
@Table(name = "Resources")
@Getter @Setter
@EqualsAndHashCode
public class Resource {
    @Id @TableGenerator(
        name = "RIDGen", table = "SurrogateKeys",
        pkColumnName = "TableName", pkColumnValue = "Resources",
        valueColumnName = "KeyValue", initialValue = 0,
        allocationSize = 1
    ) @GeneratedValue(strategy = GenerationType.TABLE, generator = "RIDGen")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    private String title;

    private String contents;
}
