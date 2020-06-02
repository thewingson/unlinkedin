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
@Table(name = "SUMMARY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summary {

    @Id
    @GeneratedValue(generator = "SUMMARY_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "SUMMARY_ID_SEQ", name = "SUMMARY_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "ABOUT", nullable = false)
    private String about;

    @Column(name = "UNIVERSITY", nullable = false)
    private String university;

    @Column(name = "ACADEMIC_DEGREE", nullable = false)
    private String academicDegree;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "SUMMARY_SKILL",
            joinColumns = {@JoinColumn(name = "SUMMARY_ID", foreignKey = @ForeignKey(name = "SUMMARY_FK"))},
            inverseJoinColumns = {@JoinColumn(name = "SKILL_ID", foreignKey = @ForeignKey(name = "SKILL_FK"))})
    private Set<Skill> skills = new HashSet<>();

    @Column(name = "EXPECTED_WAGE", nullable = false)
    private Integer expectedWage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Objects.equals(id, summary.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
