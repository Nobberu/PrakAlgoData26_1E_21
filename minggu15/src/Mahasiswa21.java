public class Mahasiswa21 implements Comparable<Mahasiswa21> {

    String nim;
    String nama;
    String notelp;

    public Mahasiswa21() {}

    public Mahasiswa21(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    @Override
    public String toString() {
        return (
            "Mahasiswa21{" +
            "nim=" +
            nim +
            ", nama=" +
            nama +
            ", notelp=" +
            notelp +
            '}'
        );
    }

    // Untuk fungsi sorting dan binary search dari Collections
    @Override
    public int compareTo(Mahasiswa21 o) {
        return this.nim.compareTo(o.nim); // Sorting default ascending berdasarkan NIM
    }
}
