package com.arsene.storageservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "Workspace")
@Table(
        name = "workspace",
        uniqueConstraints = {
                @UniqueConstraint(name = "workspace_name_unique", columnNames = "name")
        }
)
public class Workspace extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "workspace_sequence",
            sequenceName = "workspace_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "workspace_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            unique = true,
            length = 40
    )
    private String name;

    @JsonIgnore
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "workspace",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Project> projects = new HashSet<>();

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "workspace_user_fk_id"
            )
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Workspace() {
    }

    public Workspace(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Workspace(String name, Set<Project> projects, User user) {
        this.name = name;
        this.projects = projects;
        this.user = user;
    }
}
