package tokokue;

import java.io.IOException;
import java.util.*;
import kue.*;
import proses.*;

public class Main {
    static Scanner inputStr = new Scanner(System.in);
    static Scanner inputInt = new Scanner(System.in);
    static String pilih, admin, pilih2, cust;
    static ProsesCookies prosesCookies = new ProsesCookies();
    static ProsesCake prosesCake  = new ProsesCake();
    static ArrayList<Produk> listCookies = new ArrayList<>();
    static ArrayList<Produk> listCake = new ArrayList<>();
    static ArrayList<Customer> listPesan = new ArrayList<>();
    
    public static void main(String[] args) {
        Boolean start,restart,restart2,restart3,restart4;
        
        start = true;
        while(start){
            menu();
            switch(pilih2){
                case "1":
                    restart = getAdmin();
                    while (restart){
                        menuKue();
                        switch (pilih){
                            case "1":
                                restart2 = true;
                                while (restart2){
                                    menuAdmin();
                                    switch (admin){
                                        case "1":
                                            getTambah(prosesCookies,listCookies);
                                            break;
                                        case "2":
                                            prosesCookies.lihat(listCookies);
                                            break;
                                        case "3":
                                            listCookies = prosesCookies.ubah(listCookies);
                                            prosesCookies.lihat(listCookies);
                                            break;
                                        case "4":
                                            prosesCookies.hapus(listCookies);
                                            break;
                                        case "5":
                                            prosesCookies.tampilStruk(listPesan);
                                            break;
                                        case "6":
                                            restart2 = false;
                                            break;
                                        case "7":
                                            System.err.println("Program Selesai");
                                            System.exit(0);
                                            break;
                                        default:
                                            System.err.println("Error: Pilihan Tidak Tersedia !!");
                                            break;
                                    }
                                }
                                break;

                            case "2":
                                restart3 = true;
                                while (restart3){
                                    menuAdmin();
                                    switch (admin){
                                        case "1":
                                            getTambah(prosesCake,listCake);
                                            break;
                                        case "2":
                                            prosesCake.lihat(listCake);
                                            break;
                                        case "3":
                                            listCake = prosesCake.ubah(listCake);
                                            prosesCake.lihat(listCake);
                                            break;
                                        case "4":
                                            prosesCake.hapus(listCake);
                                            break;
                                        case "5":
                                            prosesCake.tampilStruk(listPesan);
                                            break;
                                        case "6":
                                            restart3 = false;
                                            break;
                                        case "7":
                                            System.err.println("Program Selesai");
                                            System.exit(0);
                                            break;
                                        default:
                                            System.err.println("Error: Pilihan Tidak Tersedia !!");
                                            break;
                                    }
                                }
                                break;
                                
                            case "3":
                                restart=false;
                                break;
                            
                            case "4":
                                System.err.println("Program Selesai");
                                System.exit(0);
                                break;
                            default:
                                System.err.println("Error: Pilihan Tidak Tersedia !!");
                                break;
                        }
                    }
                    break;
                     
                case "2":
                    restart4=true;
                    while(restart4){
                        menuCustomer();
                        switch(cust){
                            case "1":
                                prosesCookies.lihat(listCookies);
                                prosesCookies.pemesan(listCookies, listPesan);
                                prosesCookies.tampilStruk(listPesan);
                                break;
                            case "2":
                                prosesCake.lihat(listCake);
                                prosesCake.pemesan(listCake, listPesan);
                                prosesCake.tampilStruk(listPesan);
                                break;
                            case "3":
                                restart4=false;
                                break;
                            case "4":
                                System.err.println("Program Selesai");
                                System.exit(0);
                                break;
                            default:
                                System.err.println("Error: Pilihan Tidak Tersedia !!");
                                break;
                        }
                    }
                    break;
                
                case "3":
                    System.err.println("Program Selesai");
                    System.exit(0);
                    break;
                    
                default:
                    System.err.println("Error: Pilihan Tidak Tersedia !!");
                    break;
            }
        }
    }
                     
        
    public static String menu(){
        System.out.println("\n\t| Ingin Masuk Sebagai:          |");
        System.out.println("\t| 1. Admin                      |");
        System.out.println("\t| 2. Customer                   |");
        System.out.println("\t| 3. Keluar                     |");
        System.out.print("\t| Pilih: ");
        
        pilih2 = inputStr.nextLine();
        return pilih2;
    }
    
    public static String menuKue(){
        clearScreen();
        System.out.println("\n\t ___                       ___ ");
        System.out.println("\t|   |_____________________|   |");
        System.out.println("\t|                             |");
        System.out.println("\t|      Menu Jenis Produk      |");
        System.out.println("\t|_____________________________|");
        System.out.println("\t|                             |");
        System.out.println("\t| 1. Buat Cookies             |");
        System.out.println("\t| 2. Buat Cake                |");
        System.out.println("\t| 3. Kembali                  |");
        System.out.println("\t| 4. Keluar                   |");
        System.out.println("\t|_____________________________|");
        System.out.print("\t| Pilih: ");
        
        pilih = inputStr.nextLine();
        return pilih;
    }
    
    public static String menuAdmin(){
        clearScreen();
        System.out.println("\n\t ___                         ___  ");
        System.out.println("\t|   |_______________________|   | ");
        System.out.println("\t|                               | ");
        System.out.println("\t|      Menu Perintah Admin      | ");
        System.out.println("\t|_______________________________| ");
        System.out.println("\t|                               |");
        System.out.println("\t| 1. Tambah Kue                 |");
        System.out.println("\t| 2. Lihat Kue                  |");
        System.out.println("\t| 3. Ubah Data Kue              |");
        System.out.println("\t| 4. Hapus Data Kue             |");
        System.out.println("\t| 5. Histori Penjualan          |");
        System.out.println("\t| 6. Kembali                    |");
        System.out.println("\t| 7. Keluar                     |");
        System.out.println("\t|_______________________________| ");
        System.out.print("\t| Pilih: ");
        
        admin = inputStr.nextLine();
        return admin;
    }
    
    public static String menuCustomer(){
        System.out.println("\n\n\t    :---------------------------:");
        System.out.println("\t    |          CUSTOMER         |");
        System.out.println("\t    :---------------------------:");
        System.out.println("\t    | 1. Beli Cookies           |");
        System.out.println("\t    | 2. Beli Cake              |");
        System.out.println("\t    | 3. Kembali                |");
        System.out.println("\t    | 4. Keluar                 |");
        System.out.println("\t    :---------------------------:");
        System.out.print  ("\t     Pilih Menu : ");
        
        cust = inputStr.nextLine();
        return cust;
    }
    
    public static Produk tambahKue(Proses proses) throws IOException {
        Produk dataKue = proses.tambah();
        return dataKue;
    }
    
    private static boolean getAdmin(){
        boolean admin;
        User akun = new User();
        
        clearScreen();
        System.out.println("\n\t ___                         ___  ");
        System.out.println("\t|   |_______________________|   | ");
        System.out.println("\t|                               | ");
        System.out.println("\t|        Menu Konfirmasi        | ");
        System.out.println("\t|_______________________________| ");
        System.out.print("\t| Username  : ");
        String uname = inputStr.nextLine();
        System.out.print("\t| Password  : ");
        String pass = inputStr.nextLine();
        
        while(!uname.equals(akun.getUsername()) || !pass.equals(akun.getPassword())){
            System.err.print("\t Username atau Password Anda Salah ");
            
            System.err.print("\t| Username  : ");
            uname = inputStr.nextLine();
            System.err.print("\t| Password  : ");
            pass = inputStr.nextLine();
            
        }
        admin = true;
        return admin;
    }
    
    private static void getTambah(Proses proses, ArrayList<Produk> listKue){
        int jumlah;
        boolean restart4 = true;
        
        while(restart4){
            System.out.print("\n\t| Jumlah Data : ");
            String strJumlah = inputStr.next();
            if (strJumlah.equals("0")){
                System.err.println("\t   Data yang Diinput Tidak Boleh 0 \n\n");
            } else {
                try{
                    jumlah = Integer.parseInt(strJumlah);
                    for (int i=0; i<jumlah; i++){
                        listKue.add(tambahKue(proses));
                        restart4 = false;
                    }
                } catch (Exception e) {
                    System.err.println("\n\t             !! ALERT !!");
                    System.err.println("\t   Data yang Anda Inputkan Tidak Sesuai.");
                    System.err.println("\t           Masukkan Angka \n\n");
                }
            }
        }
    }
    
    static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // clear screen untuk Linux, Unix, Mac
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final IOException | InterruptedException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }
}