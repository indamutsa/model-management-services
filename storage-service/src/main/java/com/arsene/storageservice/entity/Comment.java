package com.arsene.storageservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "Comment")
@Table(
        name = "comment",
        uniqueConstraints = {
                @UniqueConstraint(name = "comment_type_unique", columnNames = "id")
        }
)
public class Comment extends Auditable<String>{
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "comment_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    private String comment;

    private int star;

    @ManyToOne // Many comments to one user
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(
                    name = "user_comment_id_fk"
            )
    )
    private User user;

//    @ManyToOne
//    private Artifact artifact;

    @ManyToOne // Many comments to one project
    @JoinColumn(
            name = "project_id",
            foreignKey = @ForeignKey(
                    name = "project_comment_id_fk"
            )
    )
    private Project project;

    public Comment() {
    }

    public Comment(String comment, int star, User user, Project project) {
        this.comment = comment;
        this.star = star;
        this.user = user;
        this.project = project;
    }
}
