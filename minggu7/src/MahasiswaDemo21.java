import java.util.Scanner;

public class MahasiswaDemo21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa yang ingin diinput: ");
        int jumMhs = sc.nextInt();
        sc.nextLine();

        MahasiswaBerprestasi21 list = new MahasiswaBerprestasi21(jumMhs);

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("-----------------------------------------");
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            list.tambah(new Mahasiswa21(nim, nama, kelas, ipk));
        }

        System.out.println("-----------------------------------------");
        System.out.println("Data keseluruhan Mahasiswa : ");
        list.tampil();

        System.out.println("-----------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("Masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = sc.nextDouble();

        System.out.println("-----------------------------------------");
        System.out.println("menggunakan sequential searching");
        int posisi = list.sequentialSearch(cari);
        list.tampilPosisi(cari, posisi);
        list.tampilDataSearch(cari, posisi);

        System.out.println("-----------------------------------------");
        System.out.println("menggunakan binary search (Asumsi Data Ascending)");
        int posisi2 = list.findBinarySearch(cari, 0, jumMhs - 1);
        list.tampilPosisi(cari, posisi2);
        list.tampilDataSearch(cari, posisi2);

        System.out.println("-----------------------------------------");
        System.out.println("menggunakan binary search (Asumsi Data Descending - Modifikasi)");
        int posisi3 = list.findBinarySearchDesc(cari, 0, jumMhs - 1);
        list.tampilPosisi(cari, posisi3);
        list.tampilDataSearch(cari, posisi3);
    }
}
