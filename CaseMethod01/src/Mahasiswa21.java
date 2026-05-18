public class Mahasiswa21 {

    String nim, nama, prodi;

    Mahasiswa21(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    void tampilMahasiswa21() {
        System.out.println(
            "NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi
        );
    }
}
