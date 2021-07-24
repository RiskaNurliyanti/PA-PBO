package proses;

import java.util.*;
import kue.*;

public abstract class Proses {
    
    public abstract Produk tambah();
    public abstract void hapus(ArrayList<Produk> list);
    public abstract ArrayList<Produk> ubah(ArrayList<Produk> list);
    public abstract void lihat(ArrayList<Produk> list);
    
}