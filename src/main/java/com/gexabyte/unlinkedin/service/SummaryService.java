package com.gexabyte.unlinkedin.service;

import com.gexabyte.unlinkedin.model.Summary;
import com.gexabyte.unlinkedin.pojo.SummaryPOJO;

import java.util.List;

/**
 * @author Almat on 02.06.2020
 *
 * Service for {@link Summary}
 */
public interface SummaryService {

    Summary getOne(Long id);
    List<Summary> getAll();
    void add(SummaryPOJO summaryPOJO);
    void edit(Long id, SummaryPOJO summaryPOJO);
    void delete(Long id);

}
