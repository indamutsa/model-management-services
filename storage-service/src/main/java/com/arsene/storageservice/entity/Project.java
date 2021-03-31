package com.arsene.storageservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "Project")
@Table(
        name = "project",
        uniqueConstraints = {
                @UniqueConstraint(name = "project_name_unique", columnNames = "name")
        }
)
public class Project extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "project_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @ManyToMany(mappedBy = "sharedProjects")
    private Set<User> user =  new HashSet<>();

    @ManyToOne
    private Workspace workspace;

    public Project() {
    }

    public Project(String name, Workspace workspace) {
        this.name = name;
        this.workspace = workspace;
    }

    public Project(String name, Set<User> user, Workspace workspace) {
        this.name = name;
        this.user = user;
        this.workspace = workspace;
    }
}
