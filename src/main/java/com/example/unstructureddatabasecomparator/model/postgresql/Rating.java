package com.example.unstructureddatabasecomparator.model.postgresql;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    public String userId;
    public String movieId;
    public String rating;
    public String timestamp;
}
