package com.example.activitynavegation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activitynavegation.adapter.VacancyRecyclerViewAdapter;
import com.example.activitynavegation.dao.IVacancyDAO;
import com.example.activitynavegation.dao.VacancyDAO;
import com.example.activitynavegation.helper.RecyclerItemClickListener;
import com.example.activitynavegation.model.Vacancy;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        IVacancyDAO vacancyDAO = VacancyDAO.getInstance(this);
        RecyclerView recyclerView = findViewById(R.id.vacancies);
        Button add = findViewById(R.id.add);
        Button edit = findViewById(R.id.edit);
        EditText idVacancy = findViewById(R.id.idVacancy);

        VacancyRecyclerViewAdapter adapter = new VacancyRecyclerViewAdapter(vacancyDAO.getVacancies());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(adapter);

        add.setOnClickListener(view -> {
            boolean wasAdded = vacancyDAO.addVacancy(new Vacancy(idVacancy.getText().toString(), "", ""));

            if (wasAdded && !idVacancy.getText().toString().equals("")) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("id", idVacancy.getText().toString());
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(), "Id ja existe ou input vazio", Toast.LENGTH_SHORT).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Vacancy vacancy : vacancyDAO.getVacancies()) {
                    if (vacancy.getId().equals(idVacancy.getText().toString()) && !idVacancy.getText().toString().equals("")) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("id", idVacancy.getText().toString());
                        startActivity(intent);
                        return;
                    }
                }
                Toast.makeText(getApplicationContext(), "Id não existe ou input vazio", Toast.LENGTH_SHORT).show();
            }
        });
    }


}