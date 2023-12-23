package com.example.unstructureddatabasecomparator.model.postgresql.Credits;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movie_cast")
public class Cast {
    @Id
    public String cast_id;
    public String character;
    public String credit_id; //foreign key for Credit
    public String gender;
    public String id;
    public String name;

    @Column(name = "cast_order")
    public String order;
    public String profile_path;
}