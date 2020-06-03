package com.gexabyte.unlinkedin.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "SUMMARY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ApiModel(description = "Details about the Summary")
public class Summary {

    @Id
    @GeneratedValue(generator = "SUMMARY_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "SUMMARY_ID_SEQ", name = "SUMMARY_SEQ", allocationSize = 1)
    @ApiModelProperty(notes = "The unique ID of the Summary")
    private Long id;

    @Column(name = "ABOUT", nullable = false)
    @ApiModelProperty(notes = "Short description about person")
    private String about;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JsonManagedReference
    @JoinTable(name = "SUMMARY_SKILL",
            joinColumns = {@JoinColumn(name = "SUMMARY_ID", foreignKey = @ForeignKey(name = "SUMMARY_FK"))},
            inverseJoinColumns = {@JoinColumn(name = "SKILL_ID", foreignKey = @ForeignKey(name = "SKILL_FK"))})
    @ApiModelProperty(notes = "The list of professional skills")
    private Set<Skill> skills = new HashSet<>();

    @Column(name = "EXPECTED_WAGE", nullable = false)
    @ApiModelProperty(notes = "Expected wage on offer")
    private Integer expectedWage;

}
