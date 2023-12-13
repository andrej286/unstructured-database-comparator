package com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Keyword {
    @Id
    public String id;
    public String names;
}