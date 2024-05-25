package db.lab6.projectmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Task> tasks;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "project_member",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "FK_project_member_project_id",
                            foreignKeyDefinition = "FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE")),
            inverseJoinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "FK_project_member_member_id",
                            foreignKeyDefinition = "FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE"))
    )
    @JsonIgnore
    private Set<Member> members;
}
