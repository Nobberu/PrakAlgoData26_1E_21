# REPORT

<br>

### 3.2: Array dari Object, Mengisi dan Menampilkan

Kode Program:

```java
Java
Mahasiswa21.java

public class Mahasiswa21 {
    public String nim, nama, kelas;
    public float ipk;
}
```

```java
Java
MahasiswaDemo21.java

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
```

Hasil dijalankan program:

```bash
Bash

NIM         : 244107060033
Nama        : AGNES TITANIA KINANTI
Kelas       : SIB-1E
IPK         : 3.75
-----------------------------------------
NIM         : 2341721172
Nama        : ACHMAD MAULANA HAMZAH
Kelas       : TI-2A
IPK         : 3.36
-----------------------------------------
NIM         : 244107023006
Nama        : DIRHAMAWAN PUTRANTO
Kelas       : TI-2E
IPK         : 3.8
-----------------------------------------
```

Pertanyaan:

1. Berdasarkan uji coba 3.2, apakah class yang akan dibuat array of object harus selalu memiliki atribut dan sekaligus method? Jelaskan!

= Tidak harus memiliki atribut dan method. Kode tidak akan menunjukkan error jika saya menulis kode seperti:
```java
public class Mahasiswa21 {
    public static void main(String[] args) {
        Mahasiswa21[] arrayMahasiswa21 = new Mahasiswa21[3];
    }
}
```
Tetapi, untuk sebuah fungsionalitas nyata, class setidaknya memiliki salah satu dari atribut atau method agar dapat digunakan dan memiliki kegunaan. Jika tidak, class tidak akan berguna sama sekali.

<br>

2. Apa yang dilakukan oleh kode program berikut?
```java
Mahasiswa21[] arrayMahasiswa21 = new Mahasiswa21[3];
```

= Kode program ini digunakan untuk membuat Array of Object bernama `arrayMahasiswa21` yang berisi object `Mahasiswa21`.

<br>

3. Apakah class Mahasiswa memiliki konstruktor? Jika tidak, kenapa bisa dilakukan pemanggilan konstruktur pada baris program berikut?
```java
arrayMahasiswa21[0] = new Mahasiswa();
```

= Kode program ini digunakan untuk membuat object baru di index 0 Array of Object yang telah dibuat sebelumnya.

<br>

4. Apa yang dilakukan oleh kode program berikut?
```java
arrayMahasiswa21[0] = new Mahasiswa21();
arrayMahasiswa21[0].nim = "244107060033";
arrayMahasiswa21[0].nama = "AGNES TITANIA KINANTI";
arrayMahasiswa21[0].kelas = "SIB-1E";
arrayMahasiswa21[0].ipk = (float) 3.75;
```

= Kode program ini digunakan untuk mengisi atribut dari object index 0 dari arrayMahasiswa21.

<br>

5. 

=
