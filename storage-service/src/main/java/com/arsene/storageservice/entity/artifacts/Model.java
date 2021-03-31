package com.arsene.storageservice.entity.artifacts;

import com.arsene.storageservice.entity.Artifact;
import com.arsene.storageservice.entity.Project;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "Model")
@Table(
        name = "model"
)
@PrimaryKeyJoinColumn(
        name = "artifact_id",
        foreignKey = @ForeignKey(name = "artifact_model_fk_id")
)
public class Model extends Artifact {
    @Id
    @SequenceGenerator(
            name = "model_sequence",
            sequenceName = "model_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "model_sequence"
    )
    @Column(
            updatable = false,
            nullable = false
    )
    private Long id;

//    @Enumerated(value = EnumType.STRING)
//    private ModelType modelType;


    @ManyToOne
    @JoinColumn(
            name = "metamodel_id",
            referencedColumnName = "artifact_id",
            foreignKey = @ForeignKey(
                    name = "meta_model_fk_id"
            )
    )
    private MetaModel metaModel;

    public Model() {
    }

    public Model(ArtifactType type, @NotNull(message = "Name should be specified") String name,
                 byte[] content, Project project, MetaModel metaModel) {
        super(type, name, content, project);
        this.metaModel = metaModel;
    }
}


//------------------------------------------------------------------------------

//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(
//            name = "uuid",
//            strategy = "uuid2"
//    )
//    @Column(name = "id", updatable = false, nullable = false)