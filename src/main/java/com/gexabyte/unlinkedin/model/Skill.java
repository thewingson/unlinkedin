package com.gexabyte.unlinkedin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Almat on 02.06.2020
 */

@Entity
@Table(name = "SKILL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(generator = "SKILL_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "SKILL_ID_SEQ", name = "SKILL_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "SUMMARY_SKILL",
            joinColumns = {@JoinColumn(name = "SKILL_ID", foreignKey = @ForeignKey(name = "TASK_FK"))},
            inverseJoinColumns = {@JoinColumn(name = "SKILL_ID", foreignKey = @ForeignKey(name = "SKILL_FK"))})
    private Set<Summary> summaries = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
