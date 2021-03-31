package com.arsene.storageservice.entity;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            nullable = false,
            updatable = false
    )
    private Long id;

    @Column( nullable = false, unique = true)
    private String name;

    @Email(message = "Email should be valid")
    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;


    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    @JoinTable( // This creates a table for us on the fly, a many to many table
            name = "user_projects",
            joinColumns = @JoinColumn(
                    name = "user_id", // The name of the column is user_id
                    referencedColumnName = "id", // references the columns id in User
                    foreignKey = @ForeignKey(name = "owner_user_id_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "project_id", // The name of the column is project_id
                    referencedColumnName = "id", // References the column id in project table
                    foreignKey = @ForeignKey(name = "owner_project_id_fk")
            )
    )
    private Set<Project> sharedProjects = new HashSet<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "user" // This member field is found in comment
    )
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "user", // This member field is found in workspace
            orphanRemoval = true
    )
    private List<Workspace> workspaces = new ArrayList<>();

    public User() {
    }

    public User(String name, @Email(message = "Email should be valid") String email) {
        this.name = name;
        this.email = email;
    }


    public User(String name, @Email(message = "Email should be valid") String email, Set<Project> sharedProjects, Set<Comment> comments, List<Workspace> workspaces) {
        this.name = name;
        this.email = email;
        this.sharedProjects = sharedProjects;
        this.comments = comments;
        this.workspaces = workspaces;
    }
}
