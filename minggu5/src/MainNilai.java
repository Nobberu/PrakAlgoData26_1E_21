public class MainNilai {

    public static void main(String[] args) {
        Mahasiswa[] daftarMhs = {
            new Mahasiswa("Ahmad", "220101001", 2022, 78, 82),
            new Mahasiswa("Budi", "220101002", 2022, 85, 88),
            new Mahasiswa("Cindy", "220101003", 2021, 90, 87),
            new Mahasiswa("Dian", "220101004", 2021, 76, 79),
            new Mahasiswa("Eko", "220101005", 2023, 92, 95),
            new Mahasiswa("Fajar", "220101006", 2020, 88, 85),
            new Mahasiswa("Gina", "220101007", 2023, 80, 83),
            new Mahasiswa("Hadi", "220101008", 2020, 82, 84),
        };

        int maxUTS = NilaiMahasiswa.cariMaxUTS(
            daftarMhs,
            0,
            daftarMhs.length - 1
        );

        int minUTS = NilaiMahasiswa.cariMinUTS(
            daftarMhs,
            0,
            daftarMhs.length - 1
        );

        double rataUAS = NilaiMahasiswa.hitungRataUAS(daftarMhs);

        System.out.println("=== HASIL PERHITUNGAN NILAI MAHASISWA ===");
        System.out.println(
            "a) Nilai UTS Tertinggi (Divide & Conquer) : " + maxUTS
        );
        System.out.println(
            "b) Nilai UTS Terendah  (Divide & Conquer) : " + minUTS
        );
        System.out.printf(
            "c) Rata-rata Nilai UAS (Brute Force)      : %.3f\n",
            rataUAS
        );
    }
}
