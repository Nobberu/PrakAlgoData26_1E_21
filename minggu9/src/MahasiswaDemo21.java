import java.util.Scanner;

public class MahasiswaDemo21 {

    public static void main(String[] args) {
        StackTugasMahasiswa21 stack = new StackTugasMahasiswa21(5);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Tugas Terbawah");
            System.out.println("5. Melihat Daftar Tugas");
            System.out.println("6. Melihat Jumlah Tugas Dikumpulkan");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    Mahasiswa21 mhs = new Mahasiswa21(nim, nama, kelas);
                    stack.push(mhs);
                    System.out.printf(
                        "Tugas %s berhasil dikumpulkan\n",
                        mhs.nama
                    );
                    break;
                case 2:
                    Mahasiswa21 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println(
                            "Menilai tugas dari " + dinilai.nama
                        );
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf(
                            "Nilai Tugas %s adalah %d\n",
                            dinilai.nama,
                            nilai
                        );
                        String biner = stack.konversiDesimalKeBiner(nilai);
                        System.out.println("Nilai Biner Tugas: " + biner);
                    }
                    break;
                case 3:
                    Mahasiswa21 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println(
                            "Tugas terakhir dikumpulkan oleh " + lihat.nama
                        );
                    }
                    break;
                case 4:
                    Mahasiswa21 lihatFirst = stack.peekFirst();
                    if (lihatFirst != null) {
                        System.out.println(
                            "Tugas terakhir dikumpulkan oleh " + lihatFirst.nama
                        );
                    }
                    break;
                case 5:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;
                case 6:
                    int total = stack.hitungTugas();
                    System.out.println(
                        "Tugas yang dikumpulkan sebanyak: " + total
                    );
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 6);
    }
}
