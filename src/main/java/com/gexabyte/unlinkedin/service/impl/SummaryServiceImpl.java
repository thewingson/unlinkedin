package com.gexabyte.unlinkedin.service.impl;

import com.gexabyte.unlinkedin.model.Skill;
import com.gexabyte.unlinkedin.model.Summary;
import com.gexabyte.unlinkedin.pojo.SummaryPOJO;
import com.gexabyte.unlinkedin.repo.SkillRepo;
import com.gexabyte.unlinkedin.repo.SummaryRepo;
import com.gexabyte.unlinkedin.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Almat on 02.06.2020
 */

@Service
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepo summaryRepo;
    private final SkillRepo skillRepo;

    @Autowired
    public SummaryServiceImpl(SummaryRepo summaryRepo,
                              SkillRepo skillRepo) {
        this.summaryRepo = summaryRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public Summary getOne(Long id) {
        return summaryRepo.findById(id).get();
    }

    @Override
    public List<Summary> getAll() {
        return summaryRepo.findAll();
    }

    @Override
    public void add(SummaryPOJO summaryPOJO) {
        List<Skill> skills = generateSkills(summaryPOJO);

        Summary summary = new Summary();
        summary.setAbout(summaryPOJO.getAbout());
        summary.setUniversity(summaryPOJO.getUniversity());
        summary.setAcademicDegree(summaryPOJO.getAcademicDegree());
        summary.getSkills().addAll(skills);
        summary.setExpectedWage(summaryPOJO.getExpectedWage());

        summaryRepo.save(summary);
    }

    @Override
    public void edit(Long id, SummaryPOJO summaryPOJO) {
        List<Skill> skills = generateSkills(summaryPOJO);

        summaryRepo.findById(id).ifPresent(summary -> {
            summary.setAbout(summaryPOJO.getAbout());
            summary.setUniversity(summaryPOJO.getUniversity());
            summary.setAcademicDegree(summaryPOJO.getAcademicDegree());
            summary.setExpectedWage(summaryPOJO.getExpectedWage());
            summary.getSkills().clear();
            summary.getSkills().addAll(skills);
            summaryRepo.save(summary);
        });
    }

    @Override
    public void delete(Long id) {
        Optional<Summary> summary = summaryRepo.findById(id);
        summary.ifPresent(summaryRepo::delete);
    }

    private List<Skill> generateSkills(SummaryPOJO summaryPOJO){
        summaryPOJO.getSkills().stream()
                .filter(pojoSkill -> skillRepo.findAll().stream()
                        .noneMatch(skill -> skill.getName().equals(pojoSkill)))
                .forEach(s -> skillRepo.save(new Skill(null, s, new HashSet<>())));

        return skillRepo.findAll().stream()
                .filter(skill -> summaryPOJO.getSkills().stream()
                        .anyMatch(pojoSkill -> skill.getName().equals(pojoSkill)))
                .collect(Collectors.toList());
    }
}
