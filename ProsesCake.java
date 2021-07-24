package proses;

import java.util.*;
import kue.*;

public class ProsesCake extends Proses implements KotakKue{
    
    Scanner inputStr = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    
    @Override
    public Produk tambah(){
        boolean ulang = true;
        Produk datacake = new Produk();
        
        System.out.print  ("\t     Nama Kue : ");
        datacake.setNamaKue(inputStr.nextLine());
        System.out.print  ("\t     Toping : ");
        datacake.setToping(inputStr.nextLine());
        System.out.print  ("\t     Kadaluarsa : ");
        datacake.setKadaluarsa(inputStr.nextLine());
        while(ulang){
            System.out.print("\t     Harga Kue   : ");
            String strHarga = inputInt.nextLine();
            if (strHarga.equals("0")){
                System.err.print("\n\t           !! ALERT !!            ");
                System.err.println("\t   Data Ini Tidak Boleh Bernilai 0");
            } else{
                try{
                    datacake.setHargaKue(Integer.parseInt(strHarga));
                    System.out.println("\n\t    :: Data Kue Berhasil ditambah ✓ ::\n");
                    ulang = false;
                } catch(NumberFormatException e){
                    System.err.println("\t     Input Tidak Sesuai, Masukkan Angka");
                }
            }
        }    
       
        return datacake;
    }

    @Override
    public void hapus(ArrayList<Produk> list) {
        int hapus;
        boolean ulang = true;
        
        for (int i=0; i<list.size(); i++){
            System.out.println("\t     Index ["+i+"] Produk : " + list.get(i).getNamaKue());
        }
        while(ulang){
            System.out.print("\n\t     Input Index yang ingin di Hapus : ");
            String strHapus = inputInt.nextLine();
            try{
                hapus = Integer.parseInt(strHapus);
                list.remove(hapus);
                System.out.println("\n\t    :: Data Kue Berhasil diHapus ✓ ::\n");
                ulang = false;
            } catch (NumberFormatException e) {
                System.err.println("\t    Input Tidak Sesuai, Masukan Angka");
            } catch(IndexOutOfBoundsException e){
                System.err.println("\t    Index yang Anda Input Melebihi Batas");
            }
        }
    }

    @Override
    public ArrayList<Produk> ubah(ArrayList<Produk> list) {
        int ubah;
        boolean ulang = true, ulang2 = true;
        
        for (int i=0; i<list.size(); i++){
            System.out.println("\t     Index ["+i+"] Produk : " + list.get(i).getNamaKue());
        }
        
        while(ulang){
            System.out.print("\n\t     Input Index Ubah : ");
            String strUbah = inputInt.next();
            try{
                ubah = Integer.parseInt(strUbah);
                list.get(ubah);
                System.out.print("\n\t     Nama Kue [Baru]  : ");
                list.get(ubah).setNamaKue(inputStr.nextLine());
                System.out.print("\t     Toping Kue [Baru] : ");
                list.get(ubah).setToping(inputStr.nextLine());
                System.out.print("\t     Kadaluarsa [Baru]  : ");
                list.get(ubah).setKadaluarsa(inputStr.nextLine());
                while(ulang2){
                    System.out.print("\t     Harga [Baru] : ");
                    String strHarga = inputInt.nextLine();
                    try{
                        list.get(ubah).setHargaKue(Integer.parseInt(strHarga));
                        System.out.println("\n\t    :: Data Kue Berhasil diUbah ✓ ::\n");
                        ulang2 = false;
                        ulang=false;
                    } catch (NumberFormatException ex){
                        System.err.println("\t     Input Tidak Sesuai, Masukan Angka");
                    }
                }
            } catch (NumberFormatException e){
                System.err.println("\t     Input Tidak Sesuai, Masukan Angka");
            } catch(IndexOutOfBoundsException e){
                System.err.println("\t     Index yang Anda Input Melebihi Batas");
                
            }
            
        }
        return list;
    }

    @Override
    public void lihat(ArrayList<Produk> list) {
        for (int i=0; i<list.size(); i++){
            System.out.println("\n"+(i+1));
            System.out.println("Nama Kue: "+list.get(i).getNamaKue());
            System.out.println("Toping: "+list.get(i).getToping());
            System.out.println("Harga Kue: "+list.get(i).getHargaKue());
            System.out.println("Kadaluarsa: "+list.get(i).getKadaluarsa());
            
            
        }
    }
    
    public Customer pemesan(ArrayList<Produk> beli, ArrayList<Customer> beli2){
        boolean ulang = true,ulang2=true,ulang3=true;
        Customer cust = new Customer();
        Produk dataKue = new Produk();
        
        System.out.println("\nMasukan data pemesan");
        System.out.print("Nama Pemesan : ");
        cust.setNama(inputStr.nextLine());
        System.out.print("Pesanan      : ");
        cust.setPesanan(inputStr.nextLine());
        while(ulang2){
            for (int i=0; i<beli.size(); i++){
                if (cust.getPesanan().equalsIgnoreCase(beli.get(i).getNamaKue())){
                    System.out.println("\n     Keranjang     ");
                    System.out.println("Nama Kue: " + beli.get(i).getNamaKue());
                    System.out.println("Toping  : " + beli.get(i).getToping());
                    System.out.println("Harga   : " + beli.get(i).getHargaKue()+"\n");

                    while(ulang){
                        System.out.print("Jumlah Beli  : ");
                        String strJumlah = inputStr.nextLine();
                        if (strJumlah.equals("0")){
                            System.err.print("\n\t           !! ALERT !!            ");
                            System.err.println("\t   Data Ini Tidak Boleh Bernilai 0");
                        } else{
                            try{
                                cust.setJumlah(Integer.parseInt(strJumlah));
                                cust.setTotalHarga((beli.get(i).getHargaKue()*cust.getJumlah()));
                                System.out.println("Total Harga : " + cust.getTotalHarga());
                                beli2.add(cust);
                                ulang = false;
                            } catch(NumberFormatException e){
                                System.err.println("\t     Input Tidak Sesuai, Masukkan Angka");
                            }
                        }
                    }
                }
            }
        while (ulang3){
            System.out.println("\n      Kotak Kue:");
            System.out.println(" 1. Kotak Besar");
            System.out.println(" 2. Kotak Kecil");
            System.out.print(" Masukkan Pilihan: ");
            String pilih3 = inputStr.nextLine();
            switch(pilih3){
                case "1":
                    cust.setBungkusBesar(true);
                    ulang3 =false;
                    break;
                case "2":
                    cust.setBungkusBesar(false);
                    ulang3 =false;
                    break;
                default:
                    System.err.println("Error: Pilihan Tidak Tersedia !!");
                    break;
            }
        }
        System.out.print("\n\nAlamat       : ");
        cust.setAlamat(inputStr.nextLine());
        ulang2 = false;
        }
        return cust;
    }
    
    public void tampilStruk(ArrayList<Customer> struk) {
        for (int i=0; i<struk.size(); i++){
            System.out.println("\n\n>> Struk Pembelian <<");
            System.out.println("Nama Pemesan : " + struk.get(i).getNama());
            System.out.println("Pesanan      : " + struk.get(i).getPesanan());
            System.out.println("Alamat       : " + struk.get(i).getAlamat());
            System.out.println("Jumlah Beli  : " + struk.get(i).getJumlah());
            System.out.println("Total        : " + struk.get(i).getTotalHarga());
            if (struk.get(i).isBungkusBesar() == true){
                kotakBesar();
            
            }else{
                kotakKecil();
            }
        }
    }
    @Override
    public void kotakKecil() {
        System.out.println("Kue di bungkus dengan Kotak Kecil");
    }

    @Override
    public void kotakBesar() {
        System.out.println("Kue di bungkus dengan Kotak Besar");
    }
}