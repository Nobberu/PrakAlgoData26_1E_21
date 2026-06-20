public class Buku21 {
    String kodeBuku, judul, pengarang;
    int tahunTerbit;

    public Buku21() {}

    public Buku21(String kodeBuku, String judul, String pengarang, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    public void tampilInformasi() {
        System.out.println("Kode buku: " +this.kodeBuku+" "+"Judul: "+this.judul+" "+"Pengarang: "+this.pengarang+" "+"Tahun terbit: "+this.tahunTerbit);
    }
}
