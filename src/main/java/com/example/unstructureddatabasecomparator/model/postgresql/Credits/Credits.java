package com.example.unstructureddatabasecomparator.model.postgresql.Credits;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_id")
    public List<Cast> castList;

    @OneToMany(fetch = FetchType.EAGER)
    public List<Crew> crewList;
}
