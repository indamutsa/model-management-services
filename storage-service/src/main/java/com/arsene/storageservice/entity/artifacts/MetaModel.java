package com.arsene.storageservice.entity.artifacts;

import com.arsene.storageservice.entity.Artifact;
import com.arsene.storageservice.entity.Project;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "MetaModel")
@Table(
        name = "metamodel"
)
@PrimaryKeyJoinColumn(
        name = "artifact_id",
        foreignKey = @ForeignKey(name = "artifact_meta_fk_id")
)
public class MetaModel extends Artifact {
    @Id
    @SequenceGenerator(
            name = "metamodel_sequence",
            sequenceName = "metamodel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "metamodel_sequence"
    )
    @Column(
            updatable = false,
            nullable = false
    )
    private Long id;

//    @Enumerated(value = EnumType.STRING)
//    private MetaModelType metaModelType;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "metaModel", // This member field is found in Model class
            orphanRemoval = true
    )
    private List<Model> model = new ArrayList<>();

    public MetaModel() {
    }

    public MetaModel(ArtifactType type, @NotNull(message = "Name should be specified") String name,
                     byte[] content, Project project, List<Model> model) {
        super(type, name, content, project);
        this.model = model;
    }
}
