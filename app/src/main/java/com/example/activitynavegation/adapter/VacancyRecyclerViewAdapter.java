package com.example.activitynavegation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activitynavegation.R;
import com.example.activitynavegation.model.Vacancy;

import java.util.List;

public class VacancyRecyclerViewAdapter extends RecyclerView.Adapter<VacancyRecyclerViewAdapter.MyViewHolder> {
    private List<Vacancy> vacancies;

    public VacancyRecyclerViewAdapter(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView vacancyId;
        TextView vacancyName;
        TextView vacancyDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vacancyId = itemView.findViewById(R.id.vacancyId);
            vacancyName = itemView.findViewById(R.id.vacancyName);
            vacancyDescription = itemView.findViewById(R.id.vacancyDescription);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vacancy = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_vacancies_adapter, parent, false);
        return new MyViewHolder(vacancy);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Vacancy vacancy = vacancies.get(position);

        holder.vacancyId.setText(vacancy.getId());
        holder.vacancyName.setText(vacancy.getVacancyName());
        holder.vacancyDescription.setText(vacancy.getVacancyDescription());
    }

    @Override
    public int getItemCount() {
        return vacancies.size();
    }
}
