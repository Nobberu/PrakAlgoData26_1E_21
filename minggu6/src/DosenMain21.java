import java.util.Scanner;

public class DosenMain21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DataDosen21 data = new DataDosen21();
        int pilih;

        do {
            System.out.println("\n=== MENU MANAJEMEN DATA DOSEN ===");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampil Seluruh Data Dosen");
            System.out.println("3. Sorting Usia ASC (Bubble Sort)");
            System.out.println("4. Sorting Usia DESC (Selection Sort)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = scan.nextInt();
            scan.nextLine(); // Membersihkan newline

            switch (pilih) {
                case 1:
                    System.out.print("Kode Dosen : ");
                    String kode = scan.nextLine();
                    System.out.print("Nama Dosen : ");
                    String nama = scan.nextLine();
                    System.out.print("Jenis Kelamin (L/P): ");
                    String jkInput = scan.nextLine();
                    boolean jk = jkInput.equalsIgnoreCase("L");
                    System.out.print("Usia       : ");
                    int usia = scan.nextInt();
                    scan.nextLine();

                    Dosen21 dsnBaru = new Dosen21(kode, nama, jk, usia);
                    data.tambah(dsnBaru);
                    break;
                case 2:
                    System.out.println("\n--- DAFTAR DOSEN ---");
                    data.tampil();
                    break;
                case 3:
                    data.sortingASC();
                    data.tampil();
                    break;
                case 4:
                    data.sortingDSC();
                    data.tampil();
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilih != 5);
        
        scan.close();
    }
}