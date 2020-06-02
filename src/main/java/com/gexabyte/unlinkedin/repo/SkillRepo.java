package com.gexabyte.unlinkedin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gexabyte.unlinkedin.model.Skill;

/**
 * @author Almat on 02.06.2020
 *
 * Repo for {@link Skill}
 */

@Repository
public interface SkillRepo extends JpaRepository<Skill, Long> {
}
