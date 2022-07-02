package com.tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class data_mahasiswa {

    public static void main(String[] args) {

        ArrayList<String> nama = new ArrayList<>();
        ArrayList<String> NIM = new ArrayList<>();
        ArrayList<String> alamat = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int pilihan;

        do {
            System.out.println("\nProgram data mahasiswa");
            System.out.println("==============");
            System.out.println("1. Tambahkan");
            System.out.println("2.Tampilkan");
            System.out.println("3.cari");
            System.out.println("4.hapus");
            System.out.println("5. keluar ");
            System.out.print("\nPilih Menu : ");
            pilihan = input.nextInt();

            if (pilihan == 1 ) {
                System.out.print("masukan nama :  ");
                String nm = input.next();
                nama.add(nm);

                System.out.print("masukan NIM : ");
                String nim = input.next();
                NIM.add(nim);

                System.out.print("masukan Alamat : ");
                String alm = input.next();
                alamat.add(alm);

            } else if (pilihan == 2) {
                System.out.println("Data mahasiswa");
                System.out.println("========");

                for (int i = 0; i < NIM.size(); i++) {
                    System.out.print(i + 1 +"." + NIM.get(i));
                }

                System.out.println("untuk melihat data lengkap, cari data : (3)");

            } else if (pilihan == 3) {
                System.out.print("masukan data nomor yang dicari : ");
                int cari = input.nextInt();
                if (cari == 1) {
                    System.out.println("nama :" + nama.get(0));
                    System.out.println("NIM : " + NIM.get(0));
                    System.out.println("Alamat :" + alamat.get(0));
                }
                System.out.println("=======");
                if (cari == 2) {
                    System.out.println("nama: "+ nama.get(1));
                    System.out.println("NIM: " + NIM.get(1));
                    System.out.println("Alamat:" + alamat.get(1));
                }
            } else if (pilihan == 4) {
                System.out.println("Data Mahasiswa :");
                System.out.println("=========");

                for (int i = 0; i < NIM.size(); i++) {
                    System.out.println(i + 1 + "." + NIM.get(i));
                }
                System.out.println(" Masukan nim yang akan dihapus :");
                String nim = input.next();
                NIM.remove(nim);

            }
            else if (pilihan == 5) {
                System.out.println("selesai");
            } else {
                System.err.println("menu tidak tersedia");
            }

        } while (pilihan != 5);
    }
}