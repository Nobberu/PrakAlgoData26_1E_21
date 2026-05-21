import java.util.Scanner;

public class DoubleLinkedListMain21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DoubleLinkedList21 list = new DoubleLinkedList21();
        int pilihan;

        do {
            System.out.println("\n===== MENU DOUBLE LINKED LIST =====");
            System.out.println("1. Tambah data di awal");
            System.out.println("2. Tambah data di akhir");
            System.out.println("3. Sisipkan data di tengah (setelah NIM)");
            System.out.println("4. Sisipkan data pada Index (Tugas)");
            System.out.println("5. Hapus data di awal");
            System.out.println("6. Hapus data di akhir");
            System.out.println("7. Hapus data pada Index (Tugas)");
            System.out.println("8. Hapus data setelah NIM (Tugas)");
            System.out.println("9. Tampilkan data");
            System.out.println("10. Tampilkan data Reverse (Modifikasi)");
            System.out.println("11. Cari data by Index (Tugas)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    list.addFirst(inputMahasiswa(scan));
                    break;
                case 2:
                    list.addLast(inputMahasiswa(scan));
                    break;
                case 3:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String keyNim = scan.nextLine();
                    System.out.println("Masukkan data baru:");
                    list.insertAfter(keyNim, inputMahasiswa(scan));
                    break;
                case 4:
                    System.out.print("Masukkan index untuk disisipkan: ");
                    int idx = scan.nextInt(); scan.nextLine();
                    list.add(idx, inputMahasiswa(scan));
                    break;
                case 5:
                    list.removeFirst();
                    break;
                case 6:
                    list.removeLast();
                    break;
                case 7:
                    System.out.print("Masukkan index yang dihapus: ");
                    int idRm = scan.nextInt(); scan.nextLine();
                    list.remove(idRm);
                    break;
                case 8:
                    System.out.print("Masukkan NIM target (hapus sebelahnya): ");
                    String keyDel = scan.nextLine();
                    list.removeAfter(keyDel);
                    break;
                case 9:
                    list.print();
                    break;
                case 10:
                    list.printReverse();
                    break;
                case 11:
                    System.out.print("Masukkan Index: ");
                    int findId = scan.nextInt(); scan.nextLine();
                    list.getIndex(findId);
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);
        scan.close();
    }

    private static Mahasiswa21 inputMahasiswa(Scanner scan) {
        System.out.print("NIM   : "); String nim = scan.nextLine();
        System.out.print("Nama  : "); String nama = scan.nextLine();
        System.out.print("Kelas : "); String kelas = scan.nextLine();
        System.out.print("IPK   : "); double ipk = scan.nextDouble(); scan.nextLine();
        return new Mahasiswa21(nim, nama, kelas, ipk);
    }
}