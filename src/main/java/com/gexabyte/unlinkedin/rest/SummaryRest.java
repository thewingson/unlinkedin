package com.gexabyte.unlinkedin.rest;

import com.gexabyte.unlinkedin.model.Summary;
import com.gexabyte.unlinkedin.pojo.SummaryPOJO;
import com.gexabyte.unlinkedin.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Almat on 02.06.2020
 * <p>
 * Rest for {@link Summary}
 */

@RestController
@RequestMapping("/api/summary")
public class SummaryRest {

    private final SummaryService summaryService;

    @Autowired
    public SummaryRest(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping
    public List<Summary> all() {
        return summaryService.getAll();
    }

    @GetMapping("{id}")
    public Summary getById(@PathVariable Long id) {
        return summaryService.getOne(id);
    }

    @PostMapping
    public void add(@RequestBody SummaryPOJO summaryPOJO) {
        summaryService.add(summaryPOJO);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody SummaryPOJO summaryPOJO) {
        summaryService.edit(id, summaryPOJO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        summaryService.delete(id);
    }

}
