package kr.ac.kaist.salab.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gyeongmin on 2016. 3. 3..
 */
@Entity
@Table(name = "ResourceGroups")
public class ResourceGroup {
    @Id
    @TableGenerator(
            name = "RGIDGen", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "ResourceGroups",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    ) @GeneratedValue(strategy = GenerationType.TABLE, generator = "RGIDGen")
    private Integer id;

    @Column(name = "GroupName")
    private String groupName;

    @OneToMany(mappedBy = "resourceGroup")
    private List<Resource> resourceList;
}
