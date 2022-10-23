package com.example.activitynavegation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitynavegation.dao.IVacancyDAO;
import com.example.activitynavegation.dao.VacancyDAO;
import com.example.activitynavegation.model.Vacancy;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

        Vacancy currentVacancy = new Vacancy();
        IVacancyDAO vacancyDAO = VacancyDAO.getInstance(this);
        Button save = findViewById(R.id.save);
        Button cancel = findViewById(R.id.cancel);
        TextView vacancyId = findViewById(R.id.id);
        TextView newVacancyName = findViewById(R.id.newVacancyName);
        TextView newVacancyDescription = findViewById(R.id.newVacancyDescription);

        // pegando dados da activity
        Bundle data = getIntent().getExtras();
        String newVacancyId = data.getString("id");

        for (Vacancy vacancy : vacancyDAO.getVacancies()) {
            if (vacancy.getId().equals(newVacancyId)) {
                currentVacancy = vacancy;
            }
        }

        vacancyId.setText(currentVacancy.getId());
        newVacancyName.setText(currentVacancy.getVacancyName());
        newVacancyDescription.setText(currentVacancy.getVacancyDescription());

        Vacancy finalCurrentVacancy = currentVacancy;
        save.setOnClickListener(view -> {
            vacancyDAO.editVacancy(new Vacancy(newVacancyId, newVacancyName.getText().toString(),
                    newVacancyDescription.getText().toString()), finalCurrentVacancy);

            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });

        cancel.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Ação cancelada", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}