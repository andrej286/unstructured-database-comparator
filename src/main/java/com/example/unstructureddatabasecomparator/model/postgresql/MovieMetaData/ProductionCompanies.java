package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProductionCompanies {
    @Id
    public int Id;
    public String name;
}

