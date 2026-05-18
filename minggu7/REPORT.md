# REPORT

<br>

## Jobsheet VI - Searching
### Percobaan 1 & 2: Sequential Search dan Binary Search

Kode program:

```java
Java
Mahasiswa21.java

public class Mahasiswa21 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa21(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Kelas : " + kelas);
        System.out.println("IPK   : " + ipk);
    }
```

```java
Java
MahasiswaBerprestasi21.java

public class MahasiswaBerprestasi21 {
    Mahasiswa21[] listMhs;
    int idx;

    // Modifikasi (Pertanyaan 2.7): Konstruktor ditambahkan untuk menyesuaikan ukuran array dengan input
    public MahasiswaBerprestasi21(int jumMhs) {
        listMhs = new Mahasiswa21[jumMhs];
        idx = 0;
    }

    public void tambah(Mahasiswa21 mhs) {
        if (idx < listMhs.length) {
            listMhs[idx] = mhs;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    public void tampil() {
        for (Mahasiswa21 m : listMhs) {
            if(m != null) {
                m.tampilInformasi();
                System.out.println("-------------------------");
            }
        }
    }

    public int sequentialSearch(double cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j] != null && listMhs[j].ipk == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    public void tampilPosisi(double x, int pos) {
        if (pos != -1) {
            System.out.println("data mahasiswa dengan IPK " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public void tampilDataSearch(double x, int pos) {
        if (pos != -1) {
            System.out.println("nim\t: " + listMhs[pos].nim);
            System.out.println("nama\t: " + listMhs[pos].nama);
            System.out.println("kelas\t: " + listMhs[pos].kelas);
            System.out.println("ipk\t: " + x);
        } else {
            System.out.println("Data mahasiswa dengan IPK " + x + " tidak ditemukan");
        }
    }

    public int findBinarySearch(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].ipk) {
                return mid;
            } else if (listMhs[mid].ipk > cari) {
                return findBinarySearch(cari, left, mid - 1);
            } else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }

    // Modifikasi (Pertanyaan 2.5): Method Binary Search untuk data Descending
    public int findBinarySearchDesc(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].ipk) {
                return mid;
            } else if (listMhs[mid].ipk < cari) { 
                return findBinarySearchDesc(cari, left, mid - 1);
            } else {
                return findBinarySearchDesc(cari, mid + 1, right);
            }
        }
        return -1;
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

        // Modifikasi (Pertanyaan 2.7): Jumlah input dinamis
        System.out.print("Masukkan jumlah mahasiswa yang ingin diinput: ");
        int jumMhs = sc.nextInt();
        sc.nextLine();

        MahasiswaBerprestasi21 list = new MahasiswaBerprestasi21(jumMhs);

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("-----------------------------------------");
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

            list.tambah(new Mahasiswa21(nim, nama, kelas, ipk));
        }

        System.out.println("-----------------------------------------");
        System.out.println("Data keseluruhan Mahasiswa : ");
        list.tampil();

        System.out.println("-----------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("Masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = sc.nextDouble();

        System.out.println("-----------------------------------------");
        System.out.println("menggunakan sequential searching");
        int posisi = list.sequentialSearch(cari);
        list.tampilPosisi(cari, posisi);
        list.tampilDataSearch(cari, posisi);

        System.out.println("-----------------------------------------");
        System.out.println("menggunakan binary search (Asumsi Data Ascending)");
        int posisi2 = list.findBinarySearch(cari, 0, jumMhs - 1);
        list.tampilPosisi(cari, posisi2);
        list.tampilDataSearch(cari, posisi2);

        System.out.println("-----------------------------------------");
        System.out.println("menggunakan binary search (Asumsi Data Descending - Modifikasi)");
        int posisi3 = list.findBinarySearchDesc(cari, 0, jumMhs - 1);
        list.tampilPosisi(cari, posisi3);
        list.tampilDataSearch(cari, posisi3);
    }
}
```

Output:
```bash
Bash

Masukkan jumlah mahasiswa yang ingin diinput: 5
-----------------------------------------
Masukkan Data Mahasiswa ke-1
NIM   : 111
Nama  : adi
Kelas : 2
IPK   : 3.1
-----------------------------------------
Masukkan Data Mahasiswa ke-2
NIM   : 222
Nama  : ila
Kelas : 2
IPK   : 3.2
-----------------------------------------
Masukkan Data Mahasiswa ke-3
NIM   : 333
Nama  : lia
Kelas : 2
IPK   : 3.3
-----------------------------------------
Masukkan Data Mahasiswa ke-4
NIM   : 444
Nama  : susi
Kelas : 2
IPK   : 3.5
-----------------------------------------
Masukkan Data Mahasiswa ke-5
NIM   : 555
Nama  : anita
Kelas : 2
IPK   : 3.7
-----------------------------------------
Data keseluruhan Mahasiswa : 
NIM   : 111
Nama  : adi
Kelas : 2
IPK   : 3.1
-------------------------
NIM   : 222
Nama  : ila
Kelas : 2
IPK   : 3.2
-------------------------
NIM   : 333
Nama  : lia
Kelas : 2
IPK   : 3.3
-------------------------
NIM   : 444
Nama  : susi
Kelas : 2
IPK   : 3.5
-------------------------
NIM   : 555
Nama  : anita
Kelas : 2
IPK   : 3.7
-------------------------
-----------------------------------------
Pencarian data
Masukkan ipk mahasiswa yang dicari: 
IPK: 3.7
-----------------------------------------
menggunakan sequential searching
data mahasiswa dengan IPK 3.7 ditemukan pada indeks 4
nim     : 555
nama    : anita
kelas   : 2
ipk     : 3.7
-----------------------------------------
menggunakan binary search (Asumsi Data Ascending)
data mahasiswa dengan IPK 3.7 ditemukan pada indeks 4
nim     : 555
nama    : anita
kelas   : 2
ipk     : 3.7
-----------------------------------------
menggunakan binary search (Asumsi Data Descending - Modifikasi)
data 3.7 tidak ditemukan
Data mahasiswa dengan IPK 3.7 tidak ditemukan
```

#### Pertanyaan

Pertanyaan Sequential Search

1. Jelaskan perbedaan method tampilDataSearch dan tampilPosisi pada class MahasiswaBerprestasi!
= Method tampilPosisi hanya bertugas untuk mencetak pada layar di indeks array keberapakah data tersebut ditemukan. Sedangkan tampilDataSearch berfungsi mencetak detail seluruh isi data mahasiswa (NIM, nama, kelas, IPK) yang tersimpan pada indeks tersebut.

2. Jelaskan fungsi break pada kode program di bawah ini!
= Fungsi break digunakan untuk menghentikan perulangan (looping) secara langsung dan paksa segera setelah kondisi terpenuhi, yaitu saat data IPK yang dicari cocok dengan data di array. Hal ini akan meningkatkan efisiensi pencarian.

3. Apa fungsi variabel pos atau indeks hasil pencarian dalam program sequential search?
= Variabel pos (atau posisi) berfungsi sebagai penyimpan status indeks lokasi elemen yang sedang dicari di dalam array listMhs. Jika loop selesai namun nilainya tetap -1, itu menandakan bahwa elemen tidak ditemukan dalam array.

4. Jika terdapat lebih dari satu data dengan nilai yang sama, hasil pencarian sequential search yang dibuat di atas akan menampilkan data ke berapa? Jelaskan.
= Program akan menampilkan data pertama (indeks paling awal) yang ditemukan. Karena setelah data pertama ditemukan dan variabel terisi indeks, perintah break akan langsung mengeksekusi penghentian perulangan sehingga pencarian untuk elemen duplikat di belakangnya diabaikan.

5. Berkaitan dengan pertanyaan nomor 2 di atas, apa yang terjadi jika perintah break dihapus dari kode di atas?
= Jika perintah break dihapus, program akan terus melakukan pencarian (melakukan iterasi hingga elemen terakhir array) meskipun data pertama sudah ditemukan. Akibatnya, jika ada IPK yang sama, variabel posisi akan tertimpa dan yang dikembalikan justru letak indeks mahasiswa terakhir yang memiliki IPK tersebut.

Pertanyaan Binary Search

1. Tunjukkan pada kode program yang mana proses divide dijalankan!
= Proses divide dijalankan pada kode: mid = (left + right) / 2;. Di sinilah rentang array dibelah menjadi dua untuk menentukan nilai tengahnya.

2. Tunjukkan pada kode program yang mana proses conquer dijalankan!
= Proses conquer dijalankan pada saat rekursi memanggil methodnya sendiri untuk mempersempit ruang lingkup array, yaitu pada baris: return findBinarySearch(cari, left, mid - 1); dan baris return findBinarySearch(cari, mid + 1, right);.

3. Apa fungsi left, right, dan mid?
= left berfungsi untuk melacak batas bawah atau indeks paling kiri dari rentang pencarian yang aktif. right melacak batas atas atau indeks paling kanan. mid adalah titik tengah antara indeks left dan right yang digunakan sebagai nilai pembanding untuk mencari data.

4. Jika data IPK yang dimasukkan tidak urut. Apakah program masih dapat berjalan? Mengapa demikian?
= Program secara sintaksis masih akan tetap berjalan tanpa error dan proses compile akan lolos, tetapi hasil output pencarian tidak akan akurat (error logika/bug). Hal ini dikarenakan algoritma Binary Search secara mutlak bergantung pada data yang terurut agar program bisa menentukan harus menyisihkan sisi kiri atau sisi kanan dari nilai tengah.

5. Jika IPK yang dimasukkan dari IPK terbesar ke terkecil (misal: 3.8, 3.7, 3.5, 3.4, 3.2) dan elemen yang dicari adalah 3.2. Bagaimana hasil dari binary search? Apakah sesuai? Jika tidak sesuai maka ubahlah kode program binary search agar hasilnya sesuai.
= Hasilnya tidak akan sesuai karena kode aslinya ditujukan untuk pencarian Ascending. Saya sudah memodifikasi kodenya pada file laporan di atas dengan nama fungsi findBinarySearchDesc. Perubahannya ada pada logika kondisional, mengubah tanda operator lebih dari > menjadi kurang dari < pada baris:

```java
Java

else if (listMhs[mid].ipk < cari) { 
    return findBinarySearchDesc(cari, left, mid - 1); 
}
```

6. Jelaskan bagaimana binary search menentukan bahwa data yang dicari tidak ditemukan di dalam array.
= Data disimpulkan tidak ada di array jika batas ruang pencarian sudah saling bersilangan. Pada kode program, batas pencarian dikontrol oleh seleksi kondisi if (right >= left). Jika perulangan rekursif sampai pada tahap di mana indeks batas kiri membesar dan melebihi indeks batas kanan (alias sudah tidak ada lagi rentang array yang tersisa), blok if dilewati dan program langsung mengeksekusi return -1;.

7. Modifikasi program di atas yang mana jumlah mahasiswa yang diinputkan sesuai dengan masukan dari keyboard.
= Modifikasi ini sudah saya implementasikan pada class MahasiswaBerprestasi21 (membuat array dengan panjang dinamis melalui argumen konstruktor) dan class MahasiswaDemo21 menggunakan input Scanner yang meminta jumMhs. (Bisa dilihat di blok Kode program pada file java atau laporan di atas).