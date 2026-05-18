public class Dosen21 {
    String kode;
    String nama;
    boolean jenisKelamin; // True: Laki-laki, False: Perempuan
    int usia;

    public Dosen21(String kd, String name, boolean jk, int age) {
        kode = kd;
        nama = name;
        jenisKelamin = jk;
        usia = age;
    }

    public void tampil() {
        System.out.println("Kode Dosen : " + kode);
        System.out.println("Nama       : " + nama);
        System.out.println("Gender     : " + (jenisKelamin ? "Laki-laki" : "Perempuan"));
        System.out.println("Usia       : " + usia + " tahun");
        System.out.println("-----------------------------");
    }
}