package com.example.unstructureddatabasecomparator.model;

import java.util.ArrayList;
import java.util.List;

public class Credit {
    public String id;
    public List<Cast> castList;
    public List<Crew> crewList;

    public Credit() {
        this.castList = new ArrayList<>();
        this.crewList = new ArrayList<>();
    }

    public Credit(String id, List<Cast> castList, List<Crew> crewList) {
        this.id = id;
        this.castList = castList;
        this.crewList = crewList;
    }

    public static class Cast {
        public String cast_id;
        public String character;
        public String credit_id;
        public String gender;
        public String id;
        public String name;
        public String order;
        public String profile_path;

        public Cast(String cast_id, String character, String credit_id, String gender, String id, String name, String order, String profile_path) {
            this.cast_id = cast_id;
            this.character = character;
            this.credit_id = credit_id;
            this.gender = gender;
            this.id = id;
            this.name = name;
            this.order = order;
            this.profile_path = profile_path;
        }
    }

    public static class Crew {
        public String credit_id;
        public String department;
        public String gender;
        public String id;
        public String job;
        public String name;
        public String profile_path;

        public Crew(String credit_id, String department, String gender, String id, String job, String name, String profile_path) {
            this.credit_id = credit_id;
            this.department = department;
            this.gender = gender;
            this.id = id;
            this.job = job;
            this.name = name;
            this.profile_path = profile_path;
        }
    }
}
