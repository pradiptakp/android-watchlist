package com.example.watchlist.navigation.series;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watchlist.Film;
import com.example.watchlist.FilmAdapter;
import com.example.watchlist.FilmDetailActivity;
import com.example.watchlist.R;

import java.util.ArrayList;

public class SeriesFragment extends Fragment {
    private RecyclerView rvSeries;
    private ArrayList<Film> series = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_series, container, false);

        rvSeries = root.findViewById(R.id.rv_series);
        rvSeries.setHasFixedSize(true);
        series.addAll(getListFilm());
        showRecyclerList();

        return root;

    }

    private ArrayList<Film> getListFilm() {
        String[] dataJudul = getResources().getStringArray(R.array.series_title);
        String[] dataTahun = getResources().getStringArray(R.array.series_tahun);
        String[] dataDeskripsi = getResources().getStringArray(R.array.series_description);
        String[] dataRating = getResources().getStringArray(R.array.series_rating);
        @SuppressLint("Recycle") TypedArray dataFoto = getResources().obtainTypedArray(R.array.series_photo);

        ArrayList<Film> listFilm = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            Film film = new Film();

            film.setJudul(dataJudul[i]);
            film.setTanggalRilis(dataTahun[i]);
            film.setDeskripsi(dataDeskripsi[i]);
            film.setRating(dataRating[i]);
            film.setFoto(dataFoto.getResourceId(i, -1));

            listFilm.add(film);
        }
        return listFilm;
    }

    private void showRecyclerList(){
        rvSeries.setLayoutManager(new LinearLayoutManager(getActivity()));
        FilmAdapter filmAdapter = new FilmAdapter(series);
        rvSeries.setAdapter(filmAdapter);

        filmAdapter.setOnItemClickCallback(new FilmAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Film data) {
                showSelectedFilm(data);
            }
        });
    }

    private void showSelectedFilm(Film film) {
        String FILM = "FILM";

        Intent moveFilmDetailIntent = new Intent(getActivity(), FilmDetailActivity.class);
        moveFilmDetailIntent.putExtra(FILM, film);
        startActivity(moveFilmDetailIntent);
    }

}
