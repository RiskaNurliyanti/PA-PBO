package kue;

public class Customer {
    private String nama,alamat,pesanan;
    private int jumlah, totalHarga;
    private boolean bungkusBesar=true;
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPesanan() {
        return pesanan;
    }

    public void setPesanan(String pesanan) {
        this.pesanan = pesanan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public boolean isBungkusBesar() {
        return bungkusBesar;
    }

    public void setBungkusBesar(boolean bungkusBesar) {
        this.bungkusBesar = bungkusBesar;
    }
    
    
    
}
