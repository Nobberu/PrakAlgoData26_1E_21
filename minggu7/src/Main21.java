import java.util.Scanner;

public class Main21 {

    public static void main(String[] args) {
        // Array of Object Mahasiswa
        Mahasiswa21[] arrMhs = new Mahasiswa21[3];
        arrMhs[0] = new Mahasiswa21("22001", "Andi", "Teknik Informatika");
        arrMhs[1] = new Mahasiswa21("22002", "Budi", "Teknik Informatika");
        arrMhs[2] = new Mahasiswa21(
            "22003",
            "Citra",
            "Sistem Informasi Bisnis"
        );

        // Array of Object Buku
        Buku21[] arrBuku = new Buku21[4];
        arrBuku[0] = new Buku21("B001", "Algoritma", 2020);
        arrBuku[1] = new Buku21("B002", "Basis Data", 2019);
        arrBuku[2] = new Buku21("B003", "Pemrograman", 2021);
        arrBuku[3] = new Buku21("B004", "Fisika", 2024);

        // Array of Object Peminjaman
        Peminjaman21[] arrPinjam = new Peminjaman21[5];
        arrPinjam[0] = new Peminjaman21(arrMhs[0], arrBuku[0], 7);
        arrPinjam[1] = new Peminjaman21(arrMhs[1], arrBuku[0], 3);
        arrPinjam[2] = new Peminjaman21(arrMhs[2], arrBuku[2], 10);
        arrPinjam[3] = new Peminjaman21(arrMhs[2], arrBuku[3], 6);
        arrPinjam[4] = new Peminjaman21(arrMhs[0], arrBuku[1], 4);

        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda (Terbesar)");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    // Menu Daftar Mahasiswa
                    System.out.println("\nDaftar Mahasiswa:");
                    for (Mahasiswa21 m : arrMhs) m.tampilMahasiswa21();
                    break;
                case 2:
                    // Menu Daftar Buku
                    System.out.println("\nDaftar Buku:");
                    for (Buku21 b : arrBuku) b.tampilBuku21();
                    break;
                case 3:
                    // Menu Daftar Peminjaman
                    System.out.println("\nData Peminjaman:");
                    for (Peminjaman21 p : arrPinjam) p.tampilPeminjaman();
                    break;
                case 4:
                    // Menu Sorting dengan Multiple Sorting Methods Choice
                    int sortpilih;
                    do {
                        System.out.println(
                            "\nPilih Sorting Method yang Digunakan"
                        );
                        System.out.println("1. Insertion Sort");
                        System.out.println("2. Selection Sort");
                        System.out.println("3. Bubble Sort");
                        System.out.print("Pilih: ");
                        sortpilih = sc.nextInt();

                        switch (sortpilih) {
                            case 1:
                                // Algoritma Insertion Sort
                                for (int i = 1; i < arrPinjam.length; i++) {
                                    Peminjaman21 temp = arrPinjam[i];
                                    int j = i - 1;
                                    while (
                                        j >= 0 &&
                                        arrPinjam[j].denda < temp.denda
                                    ) {
                                        arrPinjam[j + 1] = arrPinjam[j];
                                        j--;
                                    }
                                    arrPinjam[j + 1] = temp;
                                }
                                break;
                            case 2:
                                // Algoritma Selection Sort
                                for (int i = 0; i < arrPinjam.length - 1; i++) {
                                    int idxMax = i;
                                    for (
                                        int j = i + 1;
                                        j < arrPinjam.length;
                                        j++
                                    ) {
                                        if (
                                            arrPinjam[j].denda >
                                            arrPinjam[idxMax].denda
                                        ) {
                                            idxMax = j;
                                        }
                                    }
                                    Peminjaman21 temp = arrPinjam[idxMax];
                                    arrPinjam[idxMax] = arrPinjam[i];
                                    arrPinjam[i] = temp;
                                }
                                break;
                            case 3:
                                // Algoritma Bubble Sort
                                for (int i = 0; i < arrPinjam.length - 1; i++) {
                                    for (
                                        int j = 0;
                                        j < arrPinjam.length - i - 1;
                                        j++
                                    ) {
                                        if (
                                            arrPinjam[j].denda <
                                            arrPinjam[j + 1].denda
                                        ) {
                                            Peminjaman21 temp = arrPinjam[j];
                                            arrPinjam[j] = arrPinjam[j + 1];
                                            arrPinjam[j + 1] = temp;
                                        }
                                    }
                                }
                                break;
                            default:
                                System.out.println("Pilihan tidak valid!");
                                break;
                        }
                    } while (sortpilih < 1 || sortpilih > 3);

                    System.out.println("\nSetelah diurutkan (Denda terbesar):");
                    for (Peminjaman21 p : arrPinjam) p.tampilPeminjaman();
                    break;
                case 5:
                    // Menu Mahasiswa Search
                    System.out.print("\nMasukkan NIM: ");
                    String cariNIM = sc.nextLine();
                    boolean found = false;
                    for (Peminjaman21 p : arrPinjam) {
                        if (p.mhs.nim.equals(cariNIM)) {
                            p.tampilPeminjaman();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Data tidak ditemukan.");
                    break;
                default:
                    System.out.println("\nMasukkan input yang valid.");
                    break;
            }
        } while (pilihan != 0); // Exit
    }
}
