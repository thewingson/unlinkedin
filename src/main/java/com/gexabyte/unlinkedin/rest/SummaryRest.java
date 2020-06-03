package com.gexabyte.unlinkedin.rest;

import com.gexabyte.unlinkedin.model.Summary;
import com.gexabyte.unlinkedin.pojo.SummaryPOJO;
import com.gexabyte.unlinkedin.service.SummaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "Finds all summaries")
    public List<Summary> all() {
        return summaryService.getAll();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Finds Summary by ID",
            notes = "Provide an ID",
            response = Summary.class)
    public Summary getById(@ApiParam(value = "ID value of Post", required = true) @PathVariable Long id) {
        return summaryService.getOne(id);
    }

    @PostMapping
    @ApiOperation(value = "Adds new summary")
    public void add(@RequestBody SummaryPOJO summaryPOJO) {
        summaryService.add(summaryPOJO);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Updates summary by ID",
            notes = "Provide an ID")
    public void update(@PathVariable Long id,
                       @RequestBody SummaryPOJO summaryPOJO) {
        summaryService.edit(id, summaryPOJO);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletes summary by ID",
            notes = "Provide an ID")
    public void delete(@PathVariable Long id) {
        summaryService.delete(id);
    }

}
