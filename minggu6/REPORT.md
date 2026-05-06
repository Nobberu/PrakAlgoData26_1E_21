# REPORT

<br>

### 5.2 Praktikum 1: Mengimplementasikan Sorting menggunakan object

#### A. Sorting - Bubble Sort

Kode program:

```java
Java
Sorting21.java

public class Sorting21 {

    int[] data;
    int jumData;

    Sorting21(int Data[], int jmlDat) {
        jumData = jmlDat;
        data = new int[jmlDat];
        for (int i = 0; i < jumData; i++) {
            data[i] = Data[i];
        }
    }

    void bubbleSort() {
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

    void tampil() {
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
        int a[] = { 20, 10, 2, 7, 12 };
        Sorting21 dataurut1 = new Sorting21(a, a.length);

        System.out.println("Data awal 1");
        dataurut1.tampil();
        dataurut1.bubbleSort();
        System.out.println("Data sudah diurutkan dengan BUBBLE SORT (ASC)");
        dataurut1.tampil();
    }
}
```

Output:

```bash
Bash

PS C:\GitHub\PrakAlgoData26_1E_21> java minggu6/src/SortingMain21.java
Data awal 1
20 10 2 7 12
Data sudah diurutkan dengan BUBBLE SORT (ASC)
2 7 10 12 20
```

<br>

#### B. Sorting - Selection Sort

Kode program:

```java
Java
Pangkat21.java

public class Pangkat21 {

    int nilai, pangkat;

    Pangkat21(int n, int p) {
        this.nilai = n;
        this.pangkat = p;
    }

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil = hasil * a;
        }

        return hasil;
    }

    int pangkatDC(int a, int n) {
        if (n == 1) {
            return a;
        } else {
            if ((n & 1) == 1) {
                return (pangkatDC(a, (n >> 1)) * pangkatDC(a, (n >> 1)) * a);
            } else {
                return (pangkatDC(a, (n >> 1)) * pangkatDC(a, (n >> 1)));
            }
        }
    }
}

```

```java
Java
MainPangkat.java

import java.util.Scanner;

public class MainPangkat {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah elemen: ");
        int elemen = input.nextInt();

        Pangkat21[] png = new Pangkat21[elemen];
        for (int i = 0; i < elemen; i++) {
            System.out.print(
                "Masukkan nilai basis elemen ke-" + (i + 1) + ": "
            );
            int basis = input.nextInt();
            System.out.print(
                "Masukkan nilai pangkat elemen ke-" + (i + 1) + ": "
            );
            int pangkat = input.nextInt();
            png[i] = new Pangkat21(basis, pangkat);
        }

        System.out.println("HASIL PANGKAT BRUTEFORCE:");
        for (Pangkat21 p : png) {
            System.out.println(
                p.nilai +
                    "^" +
                    p.pangkat +
                    ": " +
                    p.pangkatBF(p.nilai, p.pangkat)
            );
        }

        System.out.println("HASIL PANGKAT DIVIDE AND CONQUER:");
        for (Pangkat21 p : png) {
            System.out.println(
                p.nilai +
                    "^" +
                    p.pangkat +
                    ": " +
                    p.pangkatDC(p.nilai, p.pangkat)
            );
        }

        input.close();
    }
}

```

Output:

```bash
Bash

PS C:\GitHub\PrakAlgoData26_1E_21> java minggu5/src/MainPangkat.java
Masukkan jumlah elemen: 3
Masukkan nilai basis elemen ke-1: 2
Masukkan nilai pangkat elemen ke-1: 3
Masukkan nilai basis elemen ke-2: 4
Masukkan nilai pangkat elemen ke-2: 5
Masukkan nilai basis elemen ke-3: 6
Masukkan nilai pangkat elemen ke-3: 7
HASIL PANGKAT BRUTEFORCE:
2^3: 8
4^5: 1024
6^7: 279936
HASIL PANGKAT DIVIDE AND CONQUER:
2^3: 8
4^5: 1024
6^7: 279936
```

### Pertanyaan

1. Jelaskan mengenai perbedaan 2 method yang dibuat yaitu `pangkatBF()` dan `pangkatDC()`!

= Method `pangkatBF()` menggunakan pendekatan `Brute Force` (iteratif) untuk mengalikan nilai basis sebanyak `n` kali sehingga prosesnya standar `(O(n))`, sedangkan `pangkatDC()` menggunakan pendekatan `Divide and Conquer` (rekursif) pangkat dibagi 2 `(n/2)`, kemudian menggabungkan hasilnya yang membuat keseluruhan proses bisa lebih efisien.

<br>

2. Apakah tahap combine sudah termasuk dalam kode tersebut? Tunjukkan!

= Combine sudah ada di dalam kode tersebut, contohnya:
```java
return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2) * a);
```

<br>

3. Pada method `pangkatBF()` terdapat parameter untuk melewatkan nilai yang akan dipangkatkan dan pangkat berapa, padahal di sisi lain di class `Pangkat` telah ada atribut `nilai` dan `pangkat`, apakah menurut Anda method tersebut tetap relevan untuk memiliki parameter? Apakah bisa jika method tersebut dibuat dengan tanpa parameter? Jika bisa, seperti apa method `pangkatBF()` yang tanpa parameter?

= Method `pangkatBF()` "sebenarnya" tidak diwajibkan memiliki parameter, karena nilai `nilai` dan `pangkat` sudah ada sebagai atribut class. Method dapat langsung menggunakan atribut tersebut tanpa parameter agar lebih singkat.

<br>

4. Tarik tentang cara kerja method `pangkatBF()` dan `pangkatDC()`!

= Kesimpulannya, method `pangkatBF()` bekerja dengan meng-kalikan nilai secara berulang menggunakan pendekatan `Brute Force` (iteratif), dan prosesnya sederhana. Sedangkan `pangkatDC()` bekerja dengan memecah masalah menjadi lebih kecil menggunakan pendekatan `Divide and Conquer` (rekursif), dan lebih efisien karena jumlah operasi yang dijalankan lebih sedikit.

<br>

### 5.4: Menghitung Sum Array dengan Algoritma Brute Force dan Divide and Conquer

Kode program:

```java
Java
Sum21.java

public class Sum21 {

    double keuntungan[];

    Sum21(int el) {
        keuntungan = new double[el];
    }

    double totalBF() {
        double total = 0;
        for (int i = 0; i < keuntungan.length; i++) {
            total = total + keuntungan[i];
        }

        return total;
    }

    double totalDC(double arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int mid = (l + r) >> 1;

        double lsum = totalDC(arr, l, mid);
        double rsum = totalDC(arr, mid + 1, r);

        return lsum + rsum;
    }
}
```

```java
Java
MainSum.java

import java.util.Scanner;

public class MainSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen: ");

        int elemen = input.nextInt();

        Sum21 sm = new Sum21(elemen);
        for (int i = 0; i < elemen; i++) {
            System.out.print("Masukkan keuntungan ke-" + (i + 1) + ": ");
            sm.keuntungan[i] = input.nextDouble();
        }

        System.out.println(
            "Total keuntungan menggunakan BruteForce: " + sm.totalBF()
        );
        System.out.println(
            "Total keuntungan menggunakan Divide and Conquer: " +
                sm.totalDC(sm.keuntungan, 0, elemen - 1)
        );

        input.close();
    }
}
```

Output:

```bash
Bash

PS C:\GitHub\PrakAlgoData26_1E_21> java minggu5/src/MainSum.java
Masukkan jumlah elemen: 5
Masukkan keuntungan ke-1: 10
Masukkan keuntungan ke-2: 20
Masukkan keuntungan ke-3: 30
Masukkan keuntungan ke-4: 40
Masukkan keuntungan ke-5: 50
Total keuntungan menggunakan BruteForce: 150.0
Total keuntungan menggunakan Divide and Conquer: 150.0
```

### Pertanyaan

1. Kenapa dibutuhkan variable `mid` pada method `TotalDC()`?

= `mid` digunakan untuk menentukan titik tengah array agar dapat membagi array menjadi tepat dua bagian. Metode pendekatan ini termasuk `Divide and Conquer` yang dimana poin intinya adalah memecah masalah menjadi bentuk lebih kecil agar lebih efisien dalam proses pemecahan masalah.

<br>

2. Untuk apakah statement di bawah ini dilakukan dalam `TotalDC()`?

```java
    double lsum = totalDC(arr, l, mid);
    double rsum = totalDC(arr, mid + 1, r);
```

= Statement tersebut digunakan untuk membagi masalah menjadi dua bagian:

- `lsum` menghitung sum kiri array
- `rsum` menghitung sum kanan array

<br>

3. Kenapa diperlukan penjumlahan hasil `lsum` dan `rsum` seperti di bawah ini?

```java
    return lsum + rsum;
```

= `lsum + rsum` adalah tahap combine, yaitu penggabungan dari masalah-masalah yang sudah dipecah di awal agar mendapatkan hasil akhir.

<br>

4. Apakah base case dari `totalDC()`?

= Base case:

```java
if (l == r) {
  return arr[l];
}
```

Artinya, jika hanya ada satu elemen, maka langsung dikembalikan nilainya karena tidak bisa dibagi lagi.

<br>

5. Tarik Kesimpulan tentang cara kerja `totalDC()`

= Method `totalDC()` berjalan dengan cara membagi array menjadi dua bagian secara rekursif hingga mencapai base case. Kemudian hasil dari pembagian array tersebut dijumlahkan kembali (combine) untuk memperoleh total keseluruhan.

<br>

### 4.5 Latihan Praktikum

#### Sebuah kampus memiliki daftar nilai mahasiswa dengan data sesuai tabel di bawah ini

| Nama  | NIM        | Tahun Masuk | Nilai UTS | Nilai UAS |
|-------|------------|-------------|-----------|-----------|
| Ahmad | 220101001  | 2022        | 78        | 82        |
| Budi  | 220101002  | 2022        | 85        | 88        |
| Cindy | 220101003  | 2021        | 90        | 87        |
| Dian  | 220101004  | 2021        | 76        | 79        |
| Eko   | 220101005  | 2023        | 92        | 95        |
| Fajar | 220101006  | 2020        | 88        | 85        |
| Gina  | 220101007  | 2023        | 80        | 83        |
| Hadi  | 220101008  | 2020        | 82        | 84        |

Tentukan:

a) Nilai UTS tertinggi tertinggi menggunakan Divide and Conquer!
b) Nilai UTS terendah menggunakan Divide and Conquer!
c) Rata-rata nilai UAS dari semua mahasiswa menggunakan Brute Force!

= Kode program:

```java
Java
Mahasiswa.java

public class Mahasiswa {

    String nama;
    String nim;
    int tahunMasuk;
    int nilaiUTS;
    int nilaiUAS;

    public Mahasiswa(
        String nama,
        String nim,
        int tahunMasuk,
        int nilaiUTS,
        int nilaiUAS
    ) {
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }
}
```

```java
Java
NilaiMahasiswa.java

public class NilaiMahasiswa {

    public static int cariMaxUTS(Mahasiswa[] mhs, int low, int high) {
        if (low == high) {
            return mhs[low].nilaiUTS;
        }
        
        int mid = (low + high) / 2;
        int maxKiri = cariMaxUTS(mhs, low, mid);
        int maxKanan = cariMaxUTS(mhs, mid + 1, high);
        
        return Math.max(maxKiri, maxKanan);
    }

    public static int cariMinUTS(Mahasiswa[] mhs, int low, int high) {
        if (low == high) {
            return mhs[low].nilaiUTS;
        }
        
        int mid = (low + high) / 2;
        int minKiri = cariMinUTS(mhs, low, mid);
        int minKanan = cariMinUTS(mhs, mid + 1, high);
        
        return Math.min(minKiri, minKanan);
    }

    public static double hitungRataUAS(Mahasiswa[] mhs) {
        double total = 0;
        for (Mahasiswa m : mhs) {
            total += m.nilaiUAS;
        }
        return total / mhs.length;
    }
}
```


```java
Java
MainNilai.java

public class MainNilai {

    public static void main(String[] args) {
        Mahasiswa[] daftarMhs = {
            new Mahasiswa("Ahmad", "220101001", 2022, 78, 82),
            new Mahasiswa("Budi", "220101002", 2022, 85, 88),
            new Mahasiswa("Cindy", "220101003", 2021, 90, 87),
            new Mahasiswa("Dian", "220101004", 2021, 76, 79),
            new Mahasiswa("Eko", "220101005", 2023, 92, 95),
            new Mahasiswa("Fajar", "220101006", 2020, 88, 85),
            new Mahasiswa("Gina", "220101007", 2023, 80, 83),
            new Mahasiswa("Hadi", "220101008", 2020, 82, 84),
        };

        int maxUTS = NilaiMahasiswa.cariMaxUTS(
            daftarMhs,
            0,
            daftarMhs.length - 1
        );

        int minUTS = NilaiMahasiswa.cariMinUTS(
            daftarMhs,
            0,
            daftarMhs.length - 1
        );

        double rataUAS = NilaiMahasiswa.hitungRataUAS(daftarMhs);

        System.out.println("=== HASIL PERHITUNGAN NILAI MAHASISWA ===");
        System.out.println(
            "a) Nilai UTS Tertinggi (Divide & Conquer) : " + maxUTS
        );
        System.out.println(
            "b) Nilai UTS Terendah  (Divide & Conquer) : " + minUTS
        );
        System.out.printf(
            "c) Rata-rata Nilai UAS (Brute Force)      : %.3f\n",
            rataUAS
        );
    }
}

```

Output:

```bash
Bash

=== HASIL PERHITUNGAN NILAI MAHASISWA ===
a) Nilai UTS Tertinggi (Divide & Conquer) : 92
b) Nilai UTS Terendah  (Divide & Conquer) : 76
c) Rata-rata Nilai UAS (Brute Force)      : 85.375
```
