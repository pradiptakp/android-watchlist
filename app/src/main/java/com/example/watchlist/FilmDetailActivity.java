package com.example.watchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class FilmDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        final String FILM = "FILM";
        Film film = getIntent().getParcelableExtra(FILM);

        TextView title = findViewById(R.id.item_detail_title);
        TextView deskripsi = findViewById(R.id.item_detail_description);
        TextView rating = findViewById(R.id.item_detail_rating);
        TextView tahun = findViewById(R.id.item_detail_date);
        ImageView foto = findViewById(R.id.item_detail_photo);

        assert film != null;
        title.setText(film.getJudul());
        deskripsi.setText(film.getDeskripsi());
        rating.setText(film.getRating());
        tahun.setText(film.getTanggalRilis());
        foto.setImageResource(film.getFoto());

    }

    public void onClick(View v) {
        super.onBackPressed();
    }
}
