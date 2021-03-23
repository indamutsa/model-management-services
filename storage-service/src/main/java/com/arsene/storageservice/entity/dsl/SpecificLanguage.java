package com.arsene.storageservice.entity.dsl;

import com.arsene.storageservice.entity.artifacts.Artifact;
import com.arsene.storageservice.entity.artifacts.ArtifactType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "SpecificLanguage")
@Table(
        name = "specific_language",
        uniqueConstraints = {
                @UniqueConstraint(name = "specific_language_name_unique", columnNames = "dslType")
        }
)
@PrimaryKeyJoinColumn(
        name = "artifact_id",
        foreignKey = @ForeignKey(name = "artifact_dsl_fk_id")
)
public class SpecificLanguage extends Artifact {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid2"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(value = EnumType.STRING)
    private DslType dslType;

    public SpecificLanguage() {
    }

    public SpecificLanguage(ArtifactType type, String name, DslType dslType) {
        super(type, name);
        this.dslType = dslType;
    }
}
