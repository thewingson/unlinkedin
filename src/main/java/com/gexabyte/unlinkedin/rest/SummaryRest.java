package com.gexabyte.unlinkedin.rest;

import com.gexabyte.unlinkedin.model.Summary;
import com.gexabyte.unlinkedin.repo.SummaryRepo;
import com.gexabyte.unlinkedin.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Almat on 02.06.2020
 * <p>
 * Rest for {@link Summary}
 */

@RestController
@RequestMapping("/")
public class SummaryRest {

    private final SummaryRepo summaryRepo;
    private final SummaryService summaryService;

    @Autowired
    public SummaryRest(SummaryRepo summaryRepo,
                       SummaryService summaryService) {
        this.summaryRepo = summaryRepo;
        this.summaryService = summaryService;
    }

    @GetMapping
    public List<Summary> all() {
        return summaryService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Summary> getById(@PathVariable Long id) {
        return summaryRepo.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Summary summary) {
        summaryService.add(summary);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Summary summary) {
        summaryService.edit(id, summary);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        summaryService.delete(id);
    }

}
