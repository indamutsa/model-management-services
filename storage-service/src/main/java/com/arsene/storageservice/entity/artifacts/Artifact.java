package com.arsene.storageservice.entity.artifacts;

import com.arsene.storageservice.entity.Project;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

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
public class Artifact {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid2"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

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
