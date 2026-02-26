# REPORT

<br>

### 2.1 Percobaan 1: Deklarasi Class, Atribut dan Method

Kode Program:

```java
Java

public class mahasiswa {

    String nama, nim, kelas;
    double ipk;

    void tampilkanInformasi() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("IPK: " + ipk);
        System.out.println("Kelas: " + kelas);
    }

    void ubahKelas(String kelasBaru) {
        kelas = kelasBaru;
    }

    void updateIpk(Double ipkBaru) {
        ipk = ipkBaru;
    }

    String nilaiKinerja() {
        if (ipk >= 3.5) {
            return "Kinerja sangat baik";
        } else if (ipk >= 3.0) {
            return "Kinerja baik";
        } else if (ipk >= 2.0) {
            return "Kinerja cukup";
        } else {
            return "Kinerja kurang";
        }
    }
}

```

Hasil dijalankan program:

```bash
Bash

error: can't find main(String[])g or main() method in class: mahasiswa
```

Pertanyaan:

1. Sebutkan dua karakteristik class atau object!

= Atribut dan Method

<br>

2. Perhatikan class **Mahasiswa** pada Praktikum tersebut, ada berapa atribut yang dimiliki oleh class Mahasiswa? Sebutkan apa saja atributnya!

= Nama, Nim, Kelas, IPK

<br>

3. Ada berapa method yang dimiliki oleh class tersebut? Sebutkan apa saja methodnya!

= Ada 4 method: mahasiswa(), tampilkanInformasi(), ubahKelas(), updateIpk()

<br>

4. Perhatikan method updateIpk() yang terdapat di dalam class Mahasiswa. Modifikasi isi method tersebut sehingga IPK yang dimasukkan valid yaitu terlebih dahulu dilakukan pengecekan apakah IPK yang dimasukkan di dalam rentang 0.0 sampai dengan 4.0 (0.0 <= IPK <= 4.0). Jika IPK tidak pada rentang tersebut maka dikeluarkan pesan: "IPK tidak valid. Harus antara 0.0 dan 4.0".

=
```java
Java

void updateIpk(double ipkBaru) {
    if (ipkBaru >= 0.0 && ipkBaru <= 4.0) {
        ipk = ipkBaru;
    } else {
        System.out.println("IPK tidak valid. Harus antara 0.0 dan 4.0");
    }
}
```

<br>

5. Jelaskan bagaimana cara kerja method nilaiKinerja() dalam mengevaluasi kinerja mahasiswa, kriteria apa saja yang digunakan untuk menentukan nilai kinerja tersebut, dan apa yang dikembalikan (di-return-kan) oleh method nilaiKinerja() tersebut?

= Method menggunakan pemilihan if-else if untuk mengecek IPK. Jika IPK >= 3.5, kinerja "Sangat Baik". Jika IPK >= 3.0 dan < 3.5

<br>

6. Commit dan push kode program ke Github

= Sudah

<br>

### 2.2 Percobaan 2: Instansiasi Object, serta Mengakses Atribut dan Method

Kode Program:

```java
Java

public class MahasiswaMain21 {

    public static void main(String[] args) {
        mahasiswa mhs1 = new mahasiswa();
        mhs1.nama = "Muhammad Ali Farhan";
        mhs1.nim = "2241720171";
        mhs1.kelas = "SI 2J";
        mhs1.ipk = 3.55;

        mhs1.tampilkanInformasi();
        mhs1.ubahKelas("SI 2K");
        mhs1.updateIpk(3.60);
        mhs1.tampilkanInformasi();
    }
}

```

Hasil dijalankan program:

```bash
Bash

Nama: Muhammad Ali Farhan
NIM: 2241720171
IPK: 3.55
Kelas: SI 2J
Nama: Muhammad Ali Farhan
NIM: 2241720171
IPK: 3.6
Kelas: SI 2K
```

Pertanyaan:

1. Pada class MahasiswaMain21, tunjukkan baris kode program yang digunakan untuk proses instansiasi! Apa nama object yang dihasilkan?

= 
```java
mahasiswa mhs1 = new mahasiswa();
```
Baris kode ini yang digunakan untuk instansiasi, dan menghasilkan nama object mhs1.

<br>

2. Bagaimana cara mengakses atribut dan method suatu objek?

= Dengan cara menuliskan nama objek dan memberi .[namaAtribut] atau .[namaMethod]() seperti ini:
```java
mhs1,nim = "999";
mhs1.tampilkanInformasi();
```

<br>

3. Mengapa hasil output pemanggilan method tampilkanInformasi() pertama dan kedua berbeda?

= Karena, di class MahasiswaMain21 terdapat pemanggilan 2 method update sebelum pemanggilan method tampilkanInformasi() yang kedua. Yang mana pemanggilan 2 method update itu adalah updateIpk() dan ubahKelas().

<br>

### 2.3 Percobaan 3: Membuat Konstruktor

Kode Program:

```java
Java
MahasiswaMain21

public class MahasiswaMain21 {

    public static void main(String[] args) {
        Mahasiswa21 mhs1 = new Mahasiswa21();
        mhs1.nama = "Muhammad Ali Farhan";
        mhs1.nim = "2241720171";
        mhs1.kelas = "SI 2J";
        mhs1.ipk = 3.55;

        mhs1.tampilkanInformasi();
        mhs1.ubahKelas("SI 2K");
        mhs1.updateIpk(3.60);
        mhs1.tampilkanInformasi();

        Mahasiswa21 mhs2 = new Mahasiswa21("Annisa Nabila", "2141720160", 3.25, "TI 2L");

        mhs2.updateIpk(3.30);
        mhs2.tampilkanInformasi();
    }
}

```

```java
Java
Mahasiswa21

public class Mahasiswa21 {

    String nama, nim, kelas;
    double ipk;

    public Mahasiswa21() {}

    public Mahasiswa21(String nm, String nim, double ipk, String kls) {
        nama = nm;
        this.nim = nim;
        this.ipk = ipk;
        kelas = kls;
    }

    void tampilkanInformasi() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("IPK: " + ipk);
        System.out.println("Kelas: " + kelas);
    }

    void ubahKelas(String kelasBaru) {
        kelas = kelasBaru;
    }

    void updateIpk(Double ipkBaru) {
        ipk = ipkBaru;
    }

    String nilaiKinerja() {
        if (ipk >= 3.5) {
            return "Kinerja sangat baik";
        } else if (ipk >= 3.0) {
            return "Kinerja baik";
        } else if (ipk >= 2.0) {
            return "Kinerja cukup";
        } else {
            return "Kinerja kurang";
        }
    }
}

```

Hasil dijalankan program:

```bash
Bash

Nama: Muhammad Ali Farhan
NIM: 2241720171
IPK: 3.55
Kelas: SI 2J
Nama: Muhammad Ali Farhan
NIM: 2241720171
IPK: 3.6
Kelas: SI 2K
Nama: Annisa Nabila
NIM: 2141720160
IPK: 3.3
Kelas: TI 2L
```

Pertanyaan:

1. Pada class Mahasiswa21 di Percobaan 3, tunjukkan baris kode program yang digunakan untuk mendeklarasikan konstruktor berparameter!

=
```java
    public Mahasiswa21(String nm, String nim, double ipk, String kls) {}
```

<br>
    
2. Perhatikan class MahasiswaMain21. Apa sebenarnya yang dilakukan pada baris program berikut?
```java
Mahasiswa21 mhs2 = new Mahasiswa21("Annisa Nabila", "2141720160", 3.25, "TI 2L");
```

= Baris program tersebut adalah melakukan instansiasi, tetapi langsung memasukkan parameter ke konstruktor yang telah dibuat sebelumnya.

<br>

3. Hapus konstruktor default pada class Mahasiswa21, kemudian compile dan run program. Bagaimana hasilnya? Jelaskan mengapa hasilnya demikian!

= Jika aku menghapus konstruktor default akan terjadi error. Hal ini dikarenakan di class MahasiswaMain21 masih ada instansiasi objek Mahasiswa yang tidak diberi parameter. Jika konstruktor default dihapus, maka instansiasi objek tanpa parameter tidak akan bekerja karena hanya ada konstruktor yang memerlukan untuk mengisi parameter terlebih dahulu.

<br>

4. Setelah instansiasi objek, apakah method di dalam Mahasiswa21 harus diakses secara berurutan? Jelaskan alasannya!

= Specifically di java, method tidak harus diakses berurutan. Karena dalam sepengetahuan saya urutan pengaksesan di java tidak terlalu penting dalam konteks urutan proses.

5. Buat object baru dengan nama mhs<NamaMahasiswa> menggunakan konstruktor berparameter di Mahasiswa21!

=
```java
Mahasiswa21 mhsNobbelKaisarBhumi = new Mahasiswa21("Nobbel Kaisar Bhumi", "254107020098", 3.63, "TI 1E");
```

<br>

6. Commit dan push kode program ke Github.