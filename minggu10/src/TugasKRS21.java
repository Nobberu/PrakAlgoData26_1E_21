import java.util.Scanner;

class AntrianKRS {
    Mahasiswa21[] data;
    int front, rear, size, max;
    int sudahKRS = 0; // Total yang sudah ditangani DPA

    public AntrianKRS(int max) {
        this.max = max;
        this.data = new Mahasiswa21[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == max; }

    public void tambahAntrian(Mahasiswa21 mhs) {
        if (sudahKRS + size >= 30) {
            System.out.println("Batas maksimal DPA melayani 30 mahasiswa tercapai!");
            return;
        }
        if (isFull()) {
            System.out.println("Antrian penuh (Maks 10)!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian KRS.");
    }

    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Memproses KRS untuk:");
        int iter = Math.min(size, 2); // Proses 2 sekaligus, atau 1 jika sisa 1
        for (int i = 0; i < iter; i++) {
            System.out.print("- ");
            data[front].tampilkanData();
            front = (front + 1) % max;
            size--;
            sudahKRS++;
        }
    }

    public void clear() {
        front = 0; rear = -1; size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tampilSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong."); return;
        }
        System.out.println("Daftar Antrian KRS:");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ". ");
            data[(front + i) % max].tampilkanData();
        }
    }
    
    public void tampilDepan() {
        if (isEmpty()) { System.out.println("Antrian kosong."); return; }
        System.out.print("Antrian 1: "); data[front].tampilkanData();
        if (size > 1) {
            System.out.print("Antrian 2: "); data[(front + 1) % max].tampilkanData();
        }
    }

    public void tampilBelakang() {
        if (isEmpty()) { System.out.println("Antrian kosong."); return; }
        System.out.print("Antrian paling belakang: "); data[rear].tampilkanData();
    }

    public void infoKRS() {
        System.out.println("Mahasiswa masih mengantri : " + size);
        System.out.println("Mahasiswa sudah proses KRS: " + sudahKRS);
    }
}

public class TugasKRS21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10); // Kapasitas 10
        int pilihan;
        do {
            System.out.println("\n=== Layanan KRS DPA ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Proses KRS (2 Mahasiswa)");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Tampilkan 2 Terdepan");
            System.out.println("5. Tampilkan Paling Akhir");
            System.out.println("6. Kosongkan Antrian");
            System.out.println("7. Info Status KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt(); sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM  : "); String nim = sc.nextLine();
                    System.out.print("Nama : "); String nama = sc.nextLine();
                    System.out.print("Prodi: "); String prodi = sc.nextLine();
                    System.out.print("Kelas: "); String kelas = sc.nextLine();
                    antrian.tambahAntrian(new Mahasiswa21(nim, nama, prodi, kelas));
                    break;
                case 2: antrian.prosesKRS(); break;
                case 3: antrian.tampilSemua(); break;
                case 4: antrian.tampilDepan(); break;
                case 5: antrian.tampilBelakang(); break;
                case 6: antrian.clear(); break;
                case 7: antrian.infoKRS(); break;
            }
        } while (pilihan != 0);
        sc.close();
    }
}