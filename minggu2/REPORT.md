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