package com.example.activitynavegation.model;

import java.io.Serializable;

public class Vacancy implements Serializable {

    private String id;
    private String vacancyName;
    private String vacancyDescription;

    public Vacancy() {
    }

    public Vacancy(String id, String vacancyName, String vacancyDescription) {
        this.id = id;
        this.vacancyName = vacancyName;
        this.vacancyDescription = vacancyDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public String getVacancyDescription() {
        return vacancyDescription;
    }

    public void setVacancyDescription(String vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }
}
