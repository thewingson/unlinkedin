package com.gexabyte.unlinkedin.service.impl;

import com.gexabyte.unlinkedin.model.Skill;
import com.gexabyte.unlinkedin.model.Summary;
import com.gexabyte.unlinkedin.repo.SummaryRepo;
import com.gexabyte.unlinkedin.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Almat on 02.06.2020
 */

@Service
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepo summaryRepo;

    @Autowired
    public SummaryServiceImpl(SummaryRepo summaryRepo){
        this.summaryRepo = summaryRepo;
    }

    @Override
    public Summary getOne(Long id) {
        return null;
    }

    @Override
    public List<Summary> getAll() {
        return summaryRepo.findAll();
    }

    @Override
    public void add(Summary summary) {
        summaryRepo.save(summary);
    }

    @Override
    public void edit(Long id, Summary summary) {
        Optional<Summary> postFromDb = summaryRepo.findById(id);
        postFromDb.ifPresent(summary1 -> {
            summary1.setAbout(summary.getAbout());
            summary1.setUniversity(summary.getUniversity());
            summary1.setAcademicDegree(summary.getAcademicDegree());
            summary1.setExpectedWage(summary.getExpectedWage());
            summaryRepo.save(summary1);
        });
    }

    @Override
    public void delete(Long id) {
        Optional<Summary> post = summaryRepo.findById(id);
        summaryRepo.delete(post.get());
    }
}
