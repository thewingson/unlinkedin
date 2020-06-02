package com.gexabyte.unlinkedin.repo;

import com.gexabyte.unlinkedin.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Almat on 02.06.2020
 *
 * Repo for {@link Summary}
 */

@Repository
public interface SummaryRepo extends JpaRepository<Summary, Long> {
}
