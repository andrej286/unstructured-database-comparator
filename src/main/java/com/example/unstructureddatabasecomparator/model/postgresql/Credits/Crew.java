package com.example.unstructureddatabasecomparator.model.postgresql.Credits;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Crew {
    @Id
    public String id;
    public String credit_id; //foreign key for Credit
    public String department;
    public String gender;
    public String job;
    public String name;
    public String profile_path;
}
