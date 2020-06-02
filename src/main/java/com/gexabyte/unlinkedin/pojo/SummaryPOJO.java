package com.gexabyte.unlinkedin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gexabyte.unlinkedin.model.Summary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Almat on 02.06.2020
 *
 * POJO for {@link Summary}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryPOJO {

    private Long id;
    private String about;
    private String university;
    private String academicDegree;
    private List<String> skills = new ArrayList<>();
    private Integer expectedWage;

}
