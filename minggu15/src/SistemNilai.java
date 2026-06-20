import java.util.*;

class MhsTugas {

    String nim, nama, telf;

    public MhsTugas(String nim, String nama, String telf) {
        this.nim = nim;
        this.nama = nama;
        this.telf = telf;
    }
}

class MataKuliah {

    String kode, mk;
    int sks;

    public MataKuliah(String kode, String mk, int sks) {
        this.kode = kode;
        this.mk = mk;
        this.sks = sks;
    }
}

class Nilai {

    MhsTugas mhs;
    MataKuliah mk;
    double nilai;

    public Nilai(MhsTugas mhs, MataKuliah mk, double nilai) {
        this.mhs = mhs;
        this.mk = mk;
        this.nilai = nilai;
    }
}

public class SistemNilai {

    static List<MhsTugas> listMhs = new ArrayList<>();
    static List<MataKuliah> listMK = new ArrayList<>();
    static List<Nilai> listNilai = new ArrayList<>();
    // Menggunakan Queue untuk menampung data mahasiswa yang akan dihapus (sesuai instruksi)
    static Queue<String> queueHapus = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        int menu = 0;
        do {
            System.out.println(
                "\n************************************************"
            );
            System.out.println(
                "SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER"
            );
            System.out.println(
                "************************************************"
            );
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Hapus Data Mahasiswa (Antrean Queue)");
            System.out.println("6. Keluar");
            System.out.print("Pilih : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    inputNilai();
                    break;
                case 2:
                    tampilNilai();
                    break;
                case 3:
                    cariNilai();
                    break;
                case 4:
                    urutNilai();
                    break;
                case 5:
                    hapusMahasiswa();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (menu != 6);
    }

    static void initData() {
        listMhs.add(new MhsTugas("20001", "Thalhah", "021xxx"));
        listMhs.add(new MhsTugas("20002", "Zubair", "021xxx"));
        listMhs.add(new MhsTugas("20003", "Abdur-Rahman", "021xxx"));
        listMhs.add(new MhsTugas("20004", "Sa'ad", "021xxx"));
        listMhs.add(new MhsTugas("20005", "Sa'id", "021xxx"));
        listMhs.add(new MhsTugas("20006", "Ubaidah", "021xxx"));

        listMK.add(new MataKuliah("00001", "Internet of Things", 3));
        listMK.add(new MataKuliah("00002", "Algoritma dan Struktur Data", 2));
        listMK.add(new MataKuliah("00003", "Algoritma dan Pemrograman", 2));
        listMK.add(
            new MataKuliah("00004", "Praktikum Algoritma dan Struktur Data", 3)
        );
        listMK.add(
            new MataKuliah("00005", "Praktikum Algoritma dan Pemrograman", 3)
        );
    }

    static void inputNilai() {
        System.out.println("--- DAFTAR MAHASISWA ---");
        System.out.printf("%-10s %-15s %-10s\n", "NIM", "Nama", "Telf");
        for (MhsTugas m : listMhs) {
            System.out.printf("%-10s %-15s %-10s\n", m.nim, m.nama, m.telf);
        }
        System.out.print("Pilih mahasiswa by nim: ");
        String nim = sc.nextLine();
        MhsTugas mhsTerpilih = null;
        for (MhsTugas m : listMhs) {
            if (m.nim.equals(nim)) mhsTerpilih = m;
        }

        System.out.println("\n--- DAFTAR MATA KULIAH ---");
        System.out.printf("%-10s %-40s %-5s\n", "Kode", "Mata Kuliah", "SKS");
        for (MataKuliah mk : listMK) {
            System.out.printf("%-10s %-40s %-5d\n", mk.kode, mk.mk, mk.sks);
        }
        System.out.print("Pilih MK by kode: ");
        String kode = sc.nextLine();
        MataKuliah mkTerpilih = null;
        for (MataKuliah mk : listMK) {
            if (mk.kode.equals(kode)) mkTerpilih = mk;
        }

        if (mhsTerpilih != null && mkTerpilih != null) {
            System.out.print("Nilai : ");
            double nilai = sc.nextDouble();
            listNilai.add(new Nilai(mhsTerpilih, mkTerpilih, nilai));
            System.out.println("Data berhasil disimpan!");
        } else {
            System.out.println("NIM atau Kode MK tidak ditemukan!");
        }
    }

    static void tampilNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.printf(
            "%-10s %-15s %-40s %-5s %-5s\n",
            "Nim",
            "Nama",
            "Mata Kuliah",
            "SKS",
            "Nilai"
        );
        for (Nilai n : listNilai) {
            System.out.printf(
                "%-10s %-15s %-40s %-5d %-5.2f\n",
                n.mhs.nim,
                n.mhs.nama,
                n.mk.mk,
                n.mk.sks,
                n.nilai
            );
        }
    }

    static void cariNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.print("Masukkan data mahasiswa [nim]: ");
        String cariNim = sc.nextLine();

        int totalSks = 0;
        System.out.printf(
            "%-10s %-15s %-40s %-5s %-5s\n",
            "Nim",
            "Nama",
            "Mata Kuliah",
            "SKS",
            "Nilai"
        );
        for (Nilai n : listNilai) {
            if (n.mhs.nim.equals(cariNim)) {
                System.out.printf(
                    "%-10s %-15s %-40s %-5d %-5.2f\n",
                    n.mhs.nim,
                    n.mhs.nama,
                    n.mk.mk,
                    n.mk.sks,
                    n.nilai
                );
                totalSks += n.mk.sks;
            }
        }
        System.out.println("Total SKS " + totalSks + " telah diambil.");
    }

    static void urutNilai() {
        // Mengurutkan descending berdasarkan Nilai
        listNilai.sort((n1, n2) -> Double.compare(n2.nilai, n1.nilai));
        System.out.println(
            "\nDAFTAR NILAI MAHASISWA (Urut Berdasarkan Nilai Descending)"
        );
        tampilNilai();
    }

    static void hapusMahasiswa() {
        System.out.print(
            "Masukkan NIM Mahasiswa yang ingin diajukan untuk dihapus: "
        );
        String nimHapus = sc.nextLine();

        // Memasukkan permintaan hapus ke dalam antrean (Queue)
        queueHapus.add(nimHapus);
        System.out.println(
            "NIM " + nimHapus + " masuk ke antrean penghapusan."
        );

        // Proses eksekusi Queue
        if (!queueHapus.isEmpty()) {
            String nimProses = queueHapus.poll(); // Mengambil dan menghapus dari antrean
            listMhs.removeIf(m -> m.nim.equals(nimProses));
            listNilai.removeIf(n -> n.mhs.nim.equals(nimProses)); // Hapus nilainya juga
            System.out.println(
                "Berhasil memproses antrean. Data mahasiswa dengan NIM " +
                    nimProses +
                    " telah dihapus dari sistem."
            );
        }
    }
}
