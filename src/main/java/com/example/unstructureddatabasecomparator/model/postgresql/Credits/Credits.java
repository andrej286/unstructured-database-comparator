package com.example.unstructureddatabasecomparator.model.postgresql.Credits;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Credits {
    @Id
    public String id;

    @OneToMany(mappedBy = "credit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Cast> castList;

    @OneToMany(mappedBy = "credit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Crew> crewList;
}
