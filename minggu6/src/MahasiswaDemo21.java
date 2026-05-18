import java.util.Scanner;

public class MahasiswaDemo21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah kuota Mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        MahasiswaBerprestasi21 list = new MahasiswaBerprestasi21(jumlah);

        // Modifikasi (Pertanyaan 5.3.4 no 2): Data dinamis dari keyboard
        for (int i = 0; i < jumlah; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine(); // Membersihkan newline
            
            Mahasiswa21 mhs = new Mahasiswa21(nim, nama, kelas, ipk);
            list.tambah(mhs);
        }

        System.out.println("\nData mahasiswa sebelum sorting: ");
        list.tampil();

        System.out.println("\nData Mahasiswa setelah sorting berdasarkan IPK (DESC) dengan BUBBLE SORT:");
        list.bubbleSort();
        list.tampil();

        System.out.println("\nData yang sudah terurut (ASC) dengan SELECTION SORT:");
        list.selectionSort();
        list.tampil();

        System.out.println("\nData yang sudah terurut (DESC) dengan INSERTION SORT (Modifikasi):");
        list.insertionSortDesc();
        list.tampil();
    }
}