package com.example.watchlist;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int foto;
    private String judul;
    private String deskripsi;
    private String tanggalRilis;
    private String rating;

    public Film(){ }

    private Film(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tanggalRilis = in.readString();
        this.rating = in.readString();
        this.foto = in.readInt();
    }

    int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.tanggalRilis);
        dest.writeString(this.rating);
        dest.writeInt(this.foto);
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
