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
public class Cast {
    @Id
    public String cast_id;
    public String character;
    public String credit_id; //foreign key for Credit
    public String gender;
    public String id;
    public String name;
    public String order;
    public String profile_path;
}