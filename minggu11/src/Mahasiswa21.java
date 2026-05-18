public class Mahasiswa21 {

    String nm, name, kls;
    double ip;

    Mahasiswa21() {}

    Mahasiswa21(String nm, String name, String kls, double ip) {
        this.nm = nm;
        this.name = name;
        this.kls = kls;
        this.ip = ip;
    }

    void tampilInformasi() {
        System.out.println(
            "NM: " +
                nm +
                " | Nama: " +
                name +
                " | Kelas: " +
                kls +
                " | IP: " +
                ip
        );
    }
}
