# REPORT

<br>

## Jobsheet V - Sorting (Bubble, Selection, dan Insertion Sort)

### Praktikum 1: Mengimplementasikan Sorting menggunakan object

Kode program:

```java
Java
Sorting21.java

public class Sorting21 {
    int[] data;
    int jumData;

    public Sorting21(int[] Data, int jmlDat) {
        jumData = jmlDat;
        data = new int[jmlDat];
        for (int i = 0; i < jumData; i++) {
            data[i] = Data[i];
        }
    }

    public void bubbleSort() {
        int temp = 0;
        for (int i = 0; i < jumData - 1; i++) {
            for (int j = 1; j < jumData - i; j++) {
                if (data[j - 1] > data[j]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < jumData - 1; i++) {
            int min = i;
            for (int j = i + 1; j < jumData; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }

    public void insertionSort() {
        for (int i = 1; i <= data.length - 1; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }

    public void tampil() {
        for (int i = 0; i < jumData; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
```

```java
Java
SortingMain21.java

public class SortingMain21 {
    public static void main(String[] args) {
        int[] a = {20, 10, 2, 7, 12};
        Sorting21 dataurut1 = new Sorting21(a, a.length);
        System.out.println("Data awal 1");
        dataurut1.tampil();
        dataurut1.bubbleSort();
        System.out.println("Data sudah diurutkan dengan BUBBLE SORT (ASC)");
        dataurut1.tampil();
        System.out.println("------------------------------------------------");

        int[] b = {30, 20, 2, 8, 14};
        Sorting21 dataurut2 = new Sorting21(b, b.length);
        System.out.println("Data awal 2");
        dataurut2.tampil();
        dataurut2.selectionSort();
        System.out.println("Data sudah diurutkan dengan SELECTION SORT (ASC)");
        dataurut2.tampil();
        System.out.println("------------------------------------------------");

        int[] c = {40, 10, 4, 9, 3};
        Sorting21 dataurut3 = new Sorting21(c, c.length);
        System.out.println("Data awal 3");
        dataurut3.tampil();
        dataurut3.insertionSort();
        System.out.println("Data sudah diurutkan dengan INSERTION SORT (ASC)");
        dataurut3.tampil();
    }
}
```

Output:
```bash
Bash

Data awal 1
20 10 2 7 12 
Data sudah diurutkan dengan BUBBLE SORT (ASC)
2 7 10 12 20 
------------------------------------------------
Data awal 2
30 20 2 8 14 
Data sudah diurutkan dengan SELECTION SORT (ASC)
2 8 14 20 30 
------------------------------------------------
Data awal 3
40 10 4 9 3 
Data sudah diurutkan dengan INSERTION SORT (ASC)
3 4 9 10 40
```

#### Pertanyaan

1. Jelaskan fungsi kode program berikut (Blok Bubble Sort)!
= Kode tersebut berfungsi untuk melakukan proses swap (pertukaran posisi) dua elemen yang bersebelahan. Jika nilai elemen di sebelah kiri (data[j-1]) lebih besar daripada elemen di sebelah kanan (data[j]), maka posisinya ditukar dengan bantuan variabel penyimpan sementara (temp). Hal ini digunakan untuk mendorong nilai terbesar ke indeks paling kanan.

2. Tunjukkan kode program yang merupakan algoritma pencarian nilai minimum pada selection sort!
= Kode untuk mencari nilai minimum berada pada blok nested loop (perulangan dalam) pada method selectionSort, yaitu:

```java
Java

for (int j = i + 1; j < jumData; j++) {
    if (data[j] < data[min]) {
        min = j;
    }
}
```

3. Pada Insertion sort jelaskan maksud dari kondisi pada perulangan while (j>=0 && data[j]>temp)!
= Kondisi tersebut berarti perulangan while akan terus berjalan mundur selama indeks j belum melampaui batas awal array (tidak minus) DAN elemen pada indeks j tersebut nilainya masih lebih besar dibandingkan elemen temp (elemen yang sedang dicek/akan disisipkan). Jika kedua kondisi ini terpenuhi, maka elemen di data[j] perlu digeser ke kanan.

4. Pada Insertion sort, apakah tujuan dari perintah data[j+1] = data[j];?
= Tujuan dari perintah tersebut adalah untuk menggeser elemen array yang bernilai lebih besar dari nilai temp ke sebelah kanannya sebanyak 1 posisi indeks. Pergeseran ini akan menciptakan "ruang kosong" di posisi yang tepat agar nilai temp nantinya dapat disisipkan.

### Praktikum 2: Mengimplementasikan Sorting menggunakan object

Kode program:

```java
Java
Mahasiswa21.java

public class Mahasiswa21 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa21() {}

    public Mahasiswa21(String nm, String name, String kls, double ip) {
        nim = nm;
        nama = name;
        kelas = kls;
        ipk = ip;
    }

    void tampilInformasi() {
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
        System.out.println("Kelas: " + kelas);
        System.out.println("IPK  : " + ipk);
    }
}
```

```java
Java
MahasiswaBerprestasi21.java

public class MahasiswaBerprestasi21 {
    Mahasiswa21[] listMhs;
    int idx;

    public MahasiswaBerprestasi21(int size) {
        listMhs = new Mahasiswa21[size];
        idx = 0;
    }

    void tambah(Mahasiswa21 m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh");
        }
    }

    void tampil() {
        for (Mahasiswa21 m : listMhs) {
            if (m != null) {
                m.tampilInformasi();
                System.out.println("-------------------------");
            }
        }
    }

    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 1; j < listMhs.length - i; j++) {
                if (listMhs[j] != null && listMhs[j - 1] != null && listMhs[j].ipk > listMhs[j - 1].ipk) {
                    Mahasiswa21 tmp = listMhs[j];
                    listMhs[j] = listMhs[j - 1];
                    listMhs[j - 1] = tmp;
                }
            }
        }
    }

    void selectionSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listMhs.length; j++) {
                if (listMhs[j] != null && listMhs[idxMin] != null && listMhs[j].ipk < listMhs[idxMin].ipk) {
                    idxMin = j;
                }
            }
            Mahasiswa21 tmp = listMhs[idxMin];
            listMhs[idxMin] = listMhs[i];
            listMhs[i] = tmp;
        }
    }

    void insertionSortDesc() {
        for (int i = 1; i < listMhs.length; i++) {
            if(listMhs[i] == null) continue;
            Mahasiswa21 temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1] != null && listMhs[j - 1].ipk < temp.ipk) { 
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }
}
```

```java
Java
MahasiswaDemo21.java

import java.util.Scanner;

public class MahasiswaDemo21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah kuota Mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        MahasiswaBerprestasi21 list = new MahasiswaBerprestasi21(jumlah);

        for (int i = 0; i < jumlah; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine(); 
            
            Mahasiswa21 mhs = new Mahasiswa21(nim, nama, kelas, ipk);
            list.tambah(mhs);
        }

        System.out.println("\nData Mahasiswa setelah sorting berdasarkan IPK (DESC) dengan BUBBLE SORT:");
        list.bubbleSort();
        list.tampil();
    }
}
```

Output:
```bash
Bash

Masukkan jumlah kuota Mahasiswa: 4
Masukkan Data Mahasiswa ke-1
NIM   : 101
Nama  : Budi
Kelas : 1A
IPK   : 3.2
Masukkan Data Mahasiswa ke-2
NIM   : 102
Nama  : Siti
Kelas : 1A
IPK   : 3.8
Masukkan Data Mahasiswa ke-3
NIM   : 103
Nama  : Andi
Kelas : 1A
IPK   : 3.5
Masukkan Data Mahasiswa ke-4
NIM   : 104
Nama  : Rara
Kelas : 1A
IPK   : 3.1

Data mahasiswa sebelum sorting: 
Nama : Budi
NIM  : 101
Kelas: 1A
IPK  : 3.2
-------------------------
Nama : Siti
NIM  : 102
Kelas: 1A
IPK  : 3.8
-------------------------
Nama : Andi
NIM  : 103
Kelas: 1A
IPK  : 3.5
-------------------------
Nama : Rara
NIM  : 104
Kelas: 1A
IPK  : 3.1
-------------------------

Data Mahasiswa setelah sorting berdasarkan IPK (DESC) dengan BUBBLE SORT:
Nama : Siti
NIM  : 102
Kelas: 1A
IPK  : 3.8
-------------------------
Nama : Andi
NIM  : 103
Kelas: 1A
IPK  : 3.5
-------------------------
Nama : Budi
NIM  : 101
Kelas: 1A
IPK  : 3.2
-------------------------
Nama : Rara
NIM  : 104
Kelas: 1A
IPK  : 3.1
-------------------------

Data yang sudah terurut (ASC) dengan SELECTION SORT:
Nama : Rara
NIM  : 104
Kelas: 1A
IPK  : 3.1
-------------------------
Nama : Budi
NIM  : 101
Kelas: 1A
IPK  : 3.2
-------------------------
Nama : Andi
NIM  : 103
Kelas: 1A
IPK  : 3.5
-------------------------
Nama : Siti
NIM  : 102
Kelas: 1A
IPK  : 3.8
-------------------------

Data yang sudah terurut (DESC) dengan INSERTION SORT (Modifikasi):
Nama : Siti
NIM  : 102
Kelas: 1A
IPK  : 3.8
-------------------------
Nama : Andi
NIM  : 103
Kelas: 1A
IPK  : 3.5
-------------------------
Nama : Budi
NIM  : 101
Kelas: 1A
IPK  : 3.2
-------------------------
Nama : Rara
NIM  : 104
Kelas: 1A
IPK  : 3.1
-------------------------
```


#### Pertanyaan Bubble Sort
1. Perhatikan perulangan di dalam bubbleSort():
   a. Mengapa syarat dari perulangan i adalah i<listMhs.length-1?
   = Karena pada iterasi (fase/putaran) paling luar, kita hanya perlu melakukan perulangan sebanyak "jumlah elemen dikurangi 1". Jika elemen lainnya sudah diurutkan dengan benar, elemen terakhir otomatis akan menempati posisinya yang benar di sisa ruang, sehingga tidak perlu lagi diiterasi ulang.

   b. Mengapa syarat dari perulangan j adalah j<listMhs.length-i?
   = Karena dalam setiap tahap (fase i) yang sudah selesai berjalan, setidaknya sudah ada satu elemen bernilai paling besar/kecil yang berada di posisi akhir yang tepat. Mengurangi iterasi di dalam dengan i mencegah algoritma mengecek kembali elemen-elemen di bagian ekor yang sudah terurut, sehingga proses jauh lebih optimal.

   c. Jika banyak data di dalam listMhs adalah 50, maka berapa kali perulangan i akan berlangsung? Dan ada berapa Tahap bubble sort yang ditempuh?
   = Perulangan i akan berlangsung sebanyak 49 kali (karena 50 dikurangi 1). Maka, tahap Bubble Sort yang ditempuh juga sebanyak 49 tahap.

2. Modifikasi program di atas di mana data mahasiswa bersifat dinamis (input dari keyboard) yang terdiri dari nim, nama, kelas, dan ipk!
= Program di atas (class MahasiswaDemo21) sudah dimodifikasi menggunakan Scanner dan iterasi dinamis agar pengguna bisa memasukkan jumlah kuota array di awal lalu menginput data secara manual dari keyboard.

#### Pertanyaan Selection Sort

1. Di dalam method selection sort, terdapat baris program... (proses perbandingan idxMin). Untuk apakah proses tersebut, jelaskan!
= Kode di dalam blok tersebut digunakan untuk mecari dan menentukan indeks dari elemen array yang memiliki IPK paling kecil (nilai minimum) pada sisa array yang belum tersortir. Jika ada IPK di suatu indeks j yang lebih kecil dari indeks minimum sementara (idxMin), maka variabel idxMin diperbarui dengan indeks j tersebut.

#### Pertanyaan Insertion Sort

1. Ubahlah fungsi pada InsertionSort sehingga fungsi ini dapat melaksanakan proses sorting dengan cara descending.
= Modifikasi tersebut sudah diimplementasikan menjadi method bernama insertionSortDesc() pada class MahasiswaBerprestasi21. Hal yang diubah hanyalah operator perbandingan pada kondisi while loop, dari yang awalnya "lebih besar dari" (>) menjadi "kurang dari" (<) seperti pada kode berikut:

```java
while (j > 0 && listMhs[j - 1] != null && listMhs[j - 1].ipk < temp.ipk) {
```

### Latihan Praktikum

```java
Java
Dosen21.java

public class Dosen21 {
    String kode;
    String nama;
    boolean jenisKelamin; 
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
```

```java
Java
DataDosen21.java

public class DataDosen21 {
    Dosen21[] dataDosen = new Dosen21[10];
    int idx = 0;

    public void tambah(Dosen21 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
            System.out.println("Data Dosen berhasil ditambahkan!");
        } else {
            System.out.println("Kapasitas data Dosen penuh!");
        }
    }

    public void tampil() {
        if (idx == 0) {
            System.out.println("Data Dosen kosong.");
            return;
        }
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
        }
    }

    // Menggunakan Bubble Sort (ASC)
    public void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (dataDosen[j - 1].usia > dataDosen[j].usia) {
                    Dosen21 temp = dataDosen[j];
                    dataDosen[j] = dataDosen[j - 1];
                    dataDosen[j - 1] = temp;
                }
            }
        }
        System.out.println("Data berhasil diurutkan berdasarkan Usia (Termuda - Tertua).");
    }

    // Menggunakan Selection Sort (DESC)
    public void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int max = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[max].usia) {
                    max = j;
                }
            }
            Dosen21 temp = dataDosen[i];
            dataDosen[i] = dataDosen[max];
            dataDosen[max] = temp;
        }
        System.out.println("Data berhasil diurutkan berdasarkan Usia (Tertua - Termuda).");
    }
}
```

```java
Java
DosenMain21.java

import java.util.Scanner;

public class DosenMain21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DataDosen21 data = new DataDosen21();
        int pilih;

        do {
            System.out.println("\n=== MENU MANAJEMEN DATA DOSEN ===");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampil Seluruh Data Dosen");
            System.out.println("3. Sorting Usia ASC (Bubble Sort)");
            System.out.println("4. Sorting Usia DESC (Selection Sort)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = scan.nextInt();
            scan.nextLine(); 

            switch (pilih) {
                case 1:
                    System.out.print("Kode Dosen : ");
                    String kode = scan.nextLine();
                    System.out.print("Nama Dosen : ");
                    String nama = scan.nextLine();
                    System.out.print("Jenis Kelamin (L/P): ");
                    String jkInput = scan.nextLine();
                    boolean jk = jkInput.equalsIgnoreCase("L");
                    System.out.print("Usia       : ");
                    int usia = scan.nextInt();
                    scan.nextLine();

                    Dosen21 dsnBaru = new Dosen21(kode, nama, jk, usia);
                    data.tambah(dsnBaru);
                    break;
                case 2:
                    System.out.println("\n--- DAFTAR DOSEN ---");
                    data.tampil();
                    break;
                case 3:
                    data.sortingASC();
                    data.tampil();
                    break;
                case 4:
                    data.sortingDSC();
                    data.tampil();
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilih != 5);
        
        scan.close();
    }
}
```

Output:

```bash
Bash

=== MENU MANAJEMEN DATA DOSEN ===
1. Tambah Data Dosen
2. Tampil Seluruh Data Dosen
3. Sorting Usia ASC (Bubble Sort)
4. Sorting Usia DESC (Selection Sort)
5. Keluar
Pilih menu (1-5): 1
Kode Dosen : D01
Nama Dosen : Pak Anton
Jenis Kelamin (L/P): L
Usia       : 45
Data Dosen berhasil ditambahkan!

=== MENU MANAJEMEN DATA DOSEN ===
1. Tambah Data Dosen
2. Tampil Seluruh Data Dosen
3. Sorting Usia ASC (Bubble Sort)
4. Sorting Usia DESC (Selection Sort)
5. Keluar
Pilih menu (1-5): 1
Kode Dosen : D02
Nama Dosen : Bu Rina
Jenis Kelamin (L/P): P
Usia       : 35
Data Dosen berhasil ditambahkan!

=== MENU MANAJEMEN DATA DOSEN ===
1. Tambah Data Dosen
2. Tampil Seluruh Data Dosen
3. Sorting Usia ASC (Bubble Sort)
4. Sorting Usia DESC (Selection Sort)
5. Keluar
Pilih menu (1-5): 1
Kode Dosen : D03
Nama Dosen : Pak Budi
Jenis Kelamin (L/P): L
Usia       : 50
Data Dosen berhasil ditambahkan!

=== MENU MANAJEMEN DATA DOSEN ===
1. Tambah Data Dosen
2. Tampil Seluruh Data Dosen
3. Sorting Usia ASC (Bubble Sort)
4. Sorting Usia DESC (Selection Sort)
5. Keluar
Pilih menu (1-5): 2

--- DAFTAR DOSEN ---
Kode Dosen : D01
Nama       : Pak Anton
Gender     : Laki-laki
Usia       : 45 tahun
-----------------------------
Kode Dosen : D02
Nama       : Bu Rina
Gender     : Perempuan
Usia       : 35 tahun
-----------------------------
Kode Dosen : D03
Nama       : Pak Budi
Gender     : Laki-laki
Usia       : 50 tahun
-----------------------------

=== MENU MANAJEMEN DATA DOSEN ===
1. Tambah Data Dosen
2. Tampil Seluruh Data Dosen
3. Sorting Usia ASC (Bubble Sort)
4. Sorting Usia DESC (Selection Sort)
5. Keluar
Pilih menu (1-5): 3
Data berhasil diurutkan berdasarkan Usia (Termuda - Tertua).
Kode Dosen : D02
Nama       : Bu Rina
Gender     : Perempuan
Usia       : 35 tahun
-----------------------------
Kode Dosen : D01
Nama       : Pak Anton
Gender     : Laki-laki
Usia       : 45 tahun
-----------------------------
Kode Dosen : D03
Nama       : Pak Budi
Gender     : Laki-laki
Usia       : 50 tahun
-----------------------------

=== MENU MANAJEMEN DATA DOSEN ===
1. Tambah Data Dosen
2. Tampil Seluruh Data Dosen
3. Sorting Usia ASC (Bubble Sort)
4. Sorting Usia DESC (Selection Sort)
5. Keluar
Pilih menu (1-5): 4
Data berhasil diurutkan berdasarkan Usia (Tertua - Termuda).
Kode Dosen : D03
Nama       : Pak Budi
Gender     : Laki-laki
Usia       : 50 tahun
-----------------------------
Kode Dosen : D01
Nama       : Pak Anton
Gender     : Laki-laki
Usia       : 45 tahun
-----------------------------
Kode Dosen : D02
Nama       : Bu Rina
Gender     : Perempuan
Usia       : 35 tahun
-----------------------------

=== MENU MANAJEMEN DATA DOSEN ===
1. Tambah Data Dosen
2. Tampil Seluruh Data Dosen
3. Sorting Usia ASC (Bubble Sort)
4. Sorting Usia DESC (Selection Sort)
5. Keluar
Pilih menu (1-5): 5
Keluar dari program. Terima kasih!
```
