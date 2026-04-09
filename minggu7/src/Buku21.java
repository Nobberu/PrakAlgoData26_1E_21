public class Buku21 {

    String kodeBuku, judul;
    int tahunTerbit;

    Buku21(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    void tampilBuku21() {
        System.out.println(
            "Kode: " +
                kodeBuku +
                " | Judul: " +
                judul +
                " | Tahun: " +
                tahunTerbit
        );
    }
}
