package com.gexabyte.unlinkedin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Almat on 02.06.2020
 */

@Entity
@Table(name = "SKILL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"name"})
public class Skill {

    @Id
    @GeneratedValue(generator = "SKILL_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "SKILL_ID_SEQ", name = "SKILL_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "SUMMARY_SKILL",
            joinColumns = {@JoinColumn(name = "SKILL_ID", foreignKey = @ForeignKey(name = "SKILL_FK"))},
            inverseJoinColumns = {@JoinColumn(name = "SUMMARY_ID", foreignKey = @ForeignKey(name = "SUMMARY_FK"))})
    private Set<Summary> summaries = new HashSet<>();


}
