package com.arsene.storageservice.entity.dsl;

import com.arsene.storageservice.entity.Artifact;
import com.arsene.storageservice.entity.Project;
import com.arsene.storageservice.entity.artifacts.ArtifactType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "SpecificLanguage")
@Table(
        name = "specific_language"
)
@PrimaryKeyJoinColumn(
        name = "artifact_id",
        foreignKey = @ForeignKey(name = "artifact_dsl_fk_id")
)
public class SpecificLanguage extends Artifact {

    @Id
    @SequenceGenerator(
            name = "dsl_sequence",
            sequenceName = "dsl_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "dsl_sequence"
    )
    @Column(
            updatable = false,
            nullable = false
    )
    private Long id;

//    @Enumerated(value = EnumType.STRING)
//    private DslType dslType;

    public SpecificLanguage() {
    }

    public SpecificLanguage(ArtifactType type,
                            @NotNull(message = "Name should be specified") String name,
                            byte[] content, Project project) {
        super(type, name, content, project);
    }
}


// ------------------------------------------------------------------

//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(
//            name = "uuid",
//            strategy = "uuid2"
//    )
//    @Column(name = "id", updatable = false, nullable = false)