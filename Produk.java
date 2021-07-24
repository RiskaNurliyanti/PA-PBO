package kue;

public class Produk {
    private String namaKue,toping;
    private int hargaKue;
    private String masaTahan,kadaluarsa;

    public String getNamaKue() {
        return namaKue;
    }

    public void setNamaKue(String namaKue) {
        this.namaKue = namaKue;
    }

    public int getHargaKue() {
        return hargaKue;
    }

    public void setHargaKue(int hargaKue) {
        this.hargaKue = hargaKue;
    }

    public String getMasaTahan() {
        return masaTahan;
    }

    public void setMasaTahan(String masaTahan) {
        this.masaTahan = masaTahan;
    }

    public String getKadaluarsa() {
        return kadaluarsa;
    }

    public void setKadaluarsa(String kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public String getToping() {
        return toping;
    }

    public void setToping(String toping) {
        this.toping = toping;
    }
    
}