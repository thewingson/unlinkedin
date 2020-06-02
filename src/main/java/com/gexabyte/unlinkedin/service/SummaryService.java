package com.gexabyte.unlinkedin.service;

import com.gexabyte.unlinkedin.model.Summary;

import java.util.List;

/**
 * @author Almat on 02.06.2020
 *
 * Service for {@link Summary}
 */
public interface SummaryService {

    Summary getOne(Long id);
    List<Summary> getAll();
    void add(Summary summary);
    void edit(Long id, Summary summary);
    void delete(Long id);

}
