public class Mahasiswa21 {

    String nim, nama, kelas;
    int nilai;

    Mahasiswa21() {}

    Mahasiswa21(String nim, String nama, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        nilai = -1;
    }

    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}
