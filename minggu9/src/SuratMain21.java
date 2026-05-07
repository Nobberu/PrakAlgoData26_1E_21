import java.util.Scanner;

public class SuratMain21 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StackSurat21 tumpukanSurat = new StackSurat21(10);
        int pilih;

        do {
            System.out.println("\n=== Sistem Manajemen Surat Izin ===");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan ID Surat: ");
                    String id = scan.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scan.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = scan.nextLine();
                    System.out.print(
                        "Masukkan Jenis Izin (S untuk Sakit / I untuk Izin): "
                    );
                    char jenis = scan.nextLine().toUpperCase().charAt(0);
                    System.out.print("Masukkan Durasi (hari): ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat21 suratBaru = new Surat21(
                        id,
                        nama,
                        kelas,
                        jenis,
                        durasi
                    );
                    tumpukanSurat.push(suratBaru);
                    break;
                case 2:
                    Surat21 diproses = tumpukanSurat.pop();
                    if (diproses != null) {
                        System.out.println("\n--- Memproses Surat ---");
                        System.out.println(
                            "Surat dari " +
                                diproses.namaMahasiswa +
                                " telah diverifikasi oleh Admin Prodi."
                        );
                    }
                    break;
                case 3:
                    Surat21 terakhir = tumpukanSurat.peek();
                    if (terakhir != null) {
                        System.out.println("\n--- Surat Teratas ---");
                        System.out.println("ID Surat   : " + terakhir.idSurat);
                        System.out.println(
                            "Nama       : " + terakhir.namaMahasiswa
                        );
                        System.out.println("Kelas      : " + terakhir.kelas);
                        System.out.println(
                            "Jenis Izin : " + terakhir.jenisIzin
                        );
                    }
                    break;
                case 4:
                    System.out.print("Masukkan Nama Mahasiswa yang dicari: ");
                    String keyword = scan.nextLine();
                    tumpukanSurat.cariSurat(keyword);
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println(
                        "Pilihan tidak valid. Silakan coba lagi."
                    );
            }
        } while (pilih != 5);

        scan.close();
    }
}
