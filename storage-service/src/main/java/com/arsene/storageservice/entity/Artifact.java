package com.arsene.storageservice.entity;

import com.arsene.storageservice.entity.Project;
import com.arsene.storageservice.entity.artifacts.ArtifactType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Artifact")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(
        name = "artifact",
        uniqueConstraints = {
                @UniqueConstraint(name = "artifact_name_unique", columnNames = "name")
        }
)
public class Artifact extends Auditable<String>{
    @Id
    @SequenceGenerator(
            name = "artifact_sequence",
            sequenceName = "artifact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "artifact_sequence"
    )
    @Column(
            updatable = false,
            nullable = false
    )
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private ArtifactType type;

    @NotNull(message = "Name should be specified")
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(name = "content")
    @Lob
    private byte[] content;

    @Column(name = "valid")
    private boolean valid;

    @Column(name = "public", columnDefinition = "TINYINT(1)") //for mapping reason columnDefinition has to be set as TINYINT(1)
    private boolean publicField;

    @Column(name = "description")
    private String description;

    @ManyToOne // Many artifacts to one project
    @JoinColumn(
            name = "project_id",
            foreignKey = @ForeignKey(
                    name = "project_artifact_id_fk"
            )
    )
    private Project project;

    public Artifact() {
    }

    public Artifact(ArtifactType type, @NotNull(message = "Name should be specified") String name, byte[] content, Project project) {
        this.type = type;
        this.name = name;
        this.content = content;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Artifact{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
