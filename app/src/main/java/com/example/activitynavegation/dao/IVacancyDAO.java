package com.example.activitynavegation.dao;

import com.example.activitynavegation.model.Vacancy;

import java.util.List;

public interface IVacancyDAO {
    void createVacanciesMock();
    List<Vacancy> getVacancies();
    Vacancy getVacancy(Vacancy vacancy);
    boolean addVacancy(Vacancy vacancy);
    boolean editVacancy(Vacancy vacancyEdited, Vacancy oldVacancy);
    boolean removeVacancy(int vacancyId);
}
