package com.example.activitynavegation.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.activitynavegation.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class VacancyDAO implements IVacancyDAO {
    private static Context context;
    private static VacancyDAO vacancyDAO = null;
    private List<Vacancy> vacancies = new ArrayList<>();

    private VacancyDAO(Context context) {
        VacancyDAO.context = context;
        createVacanciesMock();
    }

    public static IVacancyDAO getInstance(Context context) {
        if (vacancyDAO == null) {
            vacancyDAO = new VacancyDAO(context);
        }
        return vacancyDAO;
    }

    @Override
    public void createVacanciesMock() {
        Vacancy vacancy = new Vacancy("1", "Pedreiro", "ser um bom pedreito");
        vacancies.add(vacancy);

        vacancy = new Vacancy("2", "Pedreiro bom", "ser um bom pedreito");
        vacancies.add(vacancy);

        vacancy = new Vacancy("3", "Pedreiro do brabo", "ser um bom pedreito");
        vacancies.add(vacancy);

        vacancy = new Vacancy("4", "Pedreiro Eiro", "ser um bom pedreito");
        vacancies.add(vacancy);

        vacancy = new Vacancy("5", "Pedro eiro", "ser um bom pedreito");
        vacancies.add(vacancy);
    }

    @Override
    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    @Override
    public Vacancy getVacancy(Vacancy vacancy) {
        return null;
    }

    @Override
    public boolean addVacancy(Vacancy vacancy) {
        for (Vacancy currentVacancy : vacancies) {
            if (currentVacancy.getId().equals(vacancy.getId())) {
                return false;
            }
        }

        vacancies.add(vacancy);
        return true;
    }

    @Override
    public boolean editVacancy(Vacancy vacancyEdited, Vacancy oldVacancy) {
        vacancies.set(vacancies.indexOf(oldVacancy), vacancyEdited);
        return true;
    }

    @Override
    public boolean removeVacancy(int vacancyId) {
        return false;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
