package com.arsene.storageservice.entity.artifacts;

import com.arsene.storageservice.entity.Project;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity(name = "MetaModel")
@Table(
        name = "metamodel",
        uniqueConstraints = {
                @UniqueConstraint(name = "metamodel_type_unique", columnNames = "metaModelType")
        }
)
@PrimaryKeyJoinColumn(
        name = "artifact_id",
        foreignKey = @ForeignKey(name = "artifact_meta_fk_id")
)
public class MetaModel extends Artifact {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid2"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(value = EnumType.STRING)
    private MetaModelType metaModelType;

    public MetaModel() {
    }

    public MetaModel(ArtifactType type,
                     @NotNull(message = "Name should be specified") String name,
                     byte[] content, Project project, MetaModelType metaModelType) {
        super(type, name, content, project);
        this.metaModelType = metaModelType;
    }
}
