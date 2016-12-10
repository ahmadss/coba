package com.androidlokomedia.k;

/**
 * Created by ahmad on 09/12/2016.
 */
public class Tulis {
    private String judul, keterangan;
    private Kategori kategori;
    private long tulisId, dateCreateMilli;

    public enum Kategori{JALAN, TIDUR, NONTON, KODING};

    public Tulis(String judul, String keterangan, Kategori kategori) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.kategori = kategori;
        this.dateCreateMilli = 0;
        this.tulisId = 0;
    }

    public Tulis(String judul, String keterangan, Kategori kategori, long tulisId, long dateCreateMilli) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.kategori = kategori;
        this.tulisId = tulisId;
        this.dateCreateMilli = dateCreateMilli;
    }

    public String getJudul() {
        return judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public long getId() {
        return tulisId;
    }

    public long getDate() {
        return dateCreateMilli;
    }

    @Override
    public String toString() {
        return "Tulis{" +
                "judul='" + judul + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", kategori=" + kategori +
                ", tulisId=" + tulisId +
                ", dateCreateMilli=" + dateCreateMilli +
                '}';
    }

    public int getAssosiasiGambar(){
        return kategoriToGambar(kategori);
    }

    public static int kategoriToGambar(Kategori tulisKategori) {
        switch (tulisKategori) {
            case JALAN:
                return R.drawable.j;
            case TIDUR:
                return R.drawable.t;
            case NONTON:
                return R.drawable.n;
            case KODING:
                return R.drawable.k;
        }
        return R.drawable.j;
    }


}
