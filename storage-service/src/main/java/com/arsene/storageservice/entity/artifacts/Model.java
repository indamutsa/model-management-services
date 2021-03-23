package com.arsene.storageservice.entity.artifacts;

import com.arsene.storageservice.entity.Project;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity(name = "Model")
@Table(
        name = "model",
        uniqueConstraints = {
                @UniqueConstraint(name = "model_type_unique", columnNames = "modelType")
        }
)
@PrimaryKeyJoinColumn(
        name = "artifact_id",
        foreignKey = @ForeignKey(name = "artifact_model_fk_id")
)
public class Model extends Artifact {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid2"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(value = EnumType.STRING)
    private ModelType modelType;

    public Model() {
    }

    public Model(ArtifactType type,
                 @NotNull(message = "Name should be specified") String name,
                 byte[] content, Project project, ModelType modelType) {
        super(type, name, content, project);
        this.modelType = modelType;
    }
}
