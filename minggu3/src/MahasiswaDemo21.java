public class MahasiswaDemo21 {

    public static void main(String[] args) {
        Mahasiswa21[] arrayMahasiswa21 = new Mahasiswa21[3];

        arrayMahasiswa21[0] = new Mahasiswa21();
        arrayMahasiswa21[0].nim = "244107060033";
        arrayMahasiswa21[0].nama = "AGNES TITANIA KINANTI";
        arrayMahasiswa21[0].kelas = "SIB-1E";
        arrayMahasiswa21[0].ipk = (float) 3.75;

        arrayMahasiswa21[1] = new Mahasiswa21();
        arrayMahasiswa21[1].nim = "2341721172";
        arrayMahasiswa21[1].nama = "ACHMAD MAULANA HAMZAH";
        arrayMahasiswa21[1].kelas = "TI-2A";
        arrayMahasiswa21[1].ipk = (float) 3.36;

        arrayMahasiswa21[2] = new Mahasiswa21();
        arrayMahasiswa21[2].nim = "244107023006";
        arrayMahasiswa21[2].nama = "DIRHAMAWAN PUTRANTO";
        arrayMahasiswa21[2].kelas = "TI-2E";
        arrayMahasiswa21[2].ipk = (float) 3.80;

        System.out.println("NIM         : " + arrayMahasiswa21[0].nim);
        System.out.println("Nama        : " + arrayMahasiswa21[0].nama);
        System.out.println("Kelas       : " + arrayMahasiswa21[0].kelas);
        System.out.println("IPK         : " + arrayMahasiswa21[0].ipk);
        System.out.println("-----------------------------------------");
        System.out.println("NIM         : " + arrayMahasiswa21[1].nim);
        System.out.println("Nama        : " + arrayMahasiswa21[1].nama);
        System.out.println("Kelas       : " + arrayMahasiswa21[1].kelas);
        System.out.println("IPK         : " + arrayMahasiswa21[1].ipk);
        System.out.println("-----------------------------------------");
        System.out.println("NIM         : " + arrayMahasiswa21[2].nim);
        System.out.println("Nama        : " + arrayMahasiswa21[2].nama);
        System.out.println("Kelas       : " + arrayMahasiswa21[2].kelas);
        System.out.println("IPK         : " + arrayMahasiswa21[2].ipk);
        System.out.println("-----------------------------------------");
    }
}
