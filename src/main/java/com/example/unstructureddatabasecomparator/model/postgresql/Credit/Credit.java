package com.example.unstructureddatabasecomparator.model.postgresql.Credit;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Credit {

    public String id;
    public List<Cast> castList;
    public List<Crew> crewList;
}
