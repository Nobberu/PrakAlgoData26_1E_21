# REPORT

<br>

## Jobsheet X - Queue

### 2.1 Percobaan 1: Operasi Dasar Queue

Kode program:

```java
// Queue21.java
public class Queue21 {
    int[] data;
    int front, rear, size, max;

    public Queue21(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean IsFull() {
        return size == max;
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
            System.exit(0); // Modifikasi: Hentikan program jika overflow
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public int Dequeue() {
        int dt = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
            System.exit(0); // Modifikasi: Hentikan program jika underflow
        } else {
            dt = data[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }
}
```

```java
// QueueMain21.java
import java.util.Scanner;

public class QueueMain21 {
    public static void menu() {
        System.out.println("\nMasukkan operasi yang diinginkan:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("0. Keluar");
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int n = sc.nextInt();
        Queue21 Q = new Queue21(n);
        int pilih;

        do {
            menu();
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if (dataKeluar != 0) {
                        System.out.println("Data yang dikeluarkan: " + dataKeluar);
                    }
                    break;
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih >= 1 && pilih <= 5);
        sc.close();
    }
}
```

Output Praktikum 1:

```bash
Masukkan kapasitas queue: 4

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
0. Keluar
---------------------------------
Pilih: 1
Masukkan data baru: 15

Masukkan operasi yang diinginkan:
1. Enqueue
...
Pilih: 1
Masukkan data baru: 31

Masukkan operasi yang diinginkan:
...
Pilih: 4
Elemen terdepan: 15
```

#### Pertanyaan 2.1.3

1. Pada konstruktor, mengapa nilai awal atribut `front` dan `rear` bernilai `-1`, sementara atribut `size` bernilai `0`?
= Nilai `-1` pada `front` dan `rear` mengindikasikan bahwa indeks antrian (Queue) belum menunjuk ke elemen apa pun di dalam Array, yang berarti Queue dalam keadaan kosong mutlak. Sedangkan `size` bernilai `0` untuk mencatat jumlah elemen riil yang ada, yang mana saat inisialisasi memang tidak ada elemen.

<br>

2. Pada method `Enqueue`, jelaskan maksud dan kegunaan dari potongan kode berikut!
```java
if (rear == max - 1) {
    rear = 0;
}
```
= Kode tersebut menerapkan logika *Circular Queue*. Jika nilai `rear` (penunjuk elemen terakhir) sudah mencapai batas maksimal indeks array (`max - 1`), ia tidak akan *overflow* melainkan kembali ke indeks `0` (membentuk lingkaran) apabila masih ada ruang/kapasitas kosong di indeks depan array.

<br>

3. Pada method `Dequeue`, jelaskan maksud dan kegunaan dari potongan kode berikut!
```java
if (front == max - 1) {
    front = 0;
}
```
= Sama seperti kasus pada `Enqueue`, ini adalah logika *Circular Queue* untuk pencabutan elemen. Saat elemen yang dicabut/dikeluarkan (`Dequeue`) berada di indeks ujung akhir array (`max - 1`), maka penunjuk `front` berikutnya akan dipindah ke indeks `0` untuk melanjutkan pergeseran sisa antrian.

<br>

4. Pada method `print`, mengapa pada proses perulangan variabel `i` tidak dimulai dari `0` (`int i = 0`), melainkan `int i = front`?
= Karena dalam *Circular Queue*, elemen paling depan/antrian nomor satu tidak selalu berada di indeks `0`. Posisinya dinamis bergerak sesuai eksekusi penambahan atau pencabutan, sehingga iterasi harus dimulai dari lokasi elemen terdepan yang sebenarnya, yaitu `front`.

<br>

5. Perhatikan kembali method `print`, jelaskan maksud dari potongan kode berikut! `i = (i + 1) % max;`
= Kode ini berfungsi untuk melakukan increment (penambahan) iterasi yang bersirkulasi. Operator modulus (`%`) menjamin ketika iterasi `i` ditambah 1 dan telah melampaui ukuran maksimal array, nilainya akan memutar kembali sisa baginya ke `0`. 

<br>

6. Tunjukkan potongan kode program yang merupakan *queue overflow*!
= Kondisi *overflow* dicegah dan dikontrol oleh method `IsFull()` pada method `Enqueue`:
```java
if (IsFull()) {
    System.out.println("Queue sudah penuh");
}
```

<br>

7. Lakukan modifikasi program sehingga pada saat terjadi *queue overflow* dan *queue underflow*, program dihentikan!
= Pada method `Enqueue` dan `Dequeue`, tambahkan sintaks penghenti eksekusi paksa: `System.exit(0);`. *(Sudah diterapkan pada source code `Queue21.java` di atas).*

<br>

---

### 2.2 Percobaan 2: Antrian Layanan Akademik

Kode program:

```java
// Mahasiswa21.java
public class Mahasiswa21 {
    String nim, nama, prodi, kelas;

    public Mahasiswa21(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    public void tampilkanData() {
        System.out.println(nim + " " + nama + " " + prodi + " " + kelas);
    }
}
```

```java
// AntrianLayanan21.java
public class AntrianLayanan21 {
    Mahasiswa21[] data;
    int front, rear, size, max;

    public AntrianLayanan21(int max) {
        this.max = max;
        this.data = new Mahasiswa21[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == max; }

    public void tambahAntrian(Mahasiswa21 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public Mahasiswa21 layaniMahasiswa() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        Mahasiswa21 mhs = data[front];
        front = (front + 1) % max;
        size--;
        return mhs;
    }

    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa terdepan: ");
            System.out.println("NIM NAMA PRODI KELAS");
            data[front].tampilkanData();
        }
    }

    // Jawaban Pertanyaan 2.2.3: Method LihatAkhir
    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa terbelakang: ");
            System.out.println("NIM NAMA PRODI KELAS");
            data[rear].tampilkanData();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        System.out.println("NIM NAMA PRODI KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }
}
```

```java
// LayananAkademikSIAKAD21.java
import java.util.Scanner;

public class LayananAkademikSIAKAD21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLayanan21 antrian = new AntrianLayanan21(5);
        int pilihan;

        do {
            System.out.println("\n=== Menu Antrian Layanan Akademik ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Layani Mahasiswa");
            System.out.println("3. Lihat Mahasiswa Terdepan");
            System.out.println("4. Lihat Semua Antrian");
            System.out.println("5. Jumlah Mahasiswa dalam Antrian");
            System.out.println("6. Lihat Mahasiswa Paling Belakang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM  : "); String nim = sc.nextLine();
                    System.out.print("Nama : "); String nama = sc.nextLine();
                    System.out.print("Prodi: "); String prodi = sc.nextLine();
                    System.out.print("Kelas: "); String kelas = sc.nextLine();
                    Mahasiswa21 mhs = new Mahasiswa21(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    Mahasiswa21 dilayani = antrian.layaniMahasiswa();
                    if (dilayani != null) {
                        System.out.print("Melayani mahasiswa: ");
                        dilayani.tampilkanData();
                    }
                    break;
                case 3:
                    antrian.lihatTerdepan();
                    break;
                case 4:
                    antrian.tampilkanSemua();
                    break;
                case 5:
                    System.out.println("Jumlah dalam antrian: " + antrian.getJumlahAntrian());
                    break;
                case 6:
                    antrian.lihatAkhir();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}
```

Output Praktikum 2:

```bash
=== Menu Antrian Layanan Akademik ===
1. Tambah Mahasiswa ke Antrian
...
Pilih menu: 1
NIM  : 123
Nama : Aldi
Prodi: TI
Kelas: 1A
Aldi berhasil masuk ke antrian.

=== Menu Antrian Layanan Akademik ===
...
Pilih menu: 1
NIM  : 124
Nama : Bobi
Prodi: TI
Kelas: 1G
Bobi berhasil masuk ke antrian.

=== Menu Antrian Layanan Akademik ===
...
Pilih menu: 4
Daftar Mahasiswa dalam Antrian:
NIM NAMA PRODI KELAS
1. 123 Aldi TI 1A
2. 124 Bobi TI 1G

=== Menu Antrian Layanan Akademik ===
...
Pilih menu: 2
Melayani mahasiswa: 123 Aldi TI 1A

=== Menu Antrian Layanan Akademik ===
...
Pilih menu: 5
Jumlah dalam antrian: 1
```

#### Pertanyaan 2.2.3

1. Lakukan modifikasi program dengan menambahkan method baru bernama `LihatAkhir` pada class `AntrianLayanan` dan menu di class main!
= Modifikasi telah saya sertakan secara komprehensif pada file Java `AntrianLayanan21.java` (dengan membuat *method* `lihatAkhir()`) dan mengintegrasikannya ke menu nomor `6` pada file `LayananAkademikSIAKAD21.java`.

<br>

---

### Tugas Jobsheet X

Kode program Tugas KRS:

```java
// TugasKRS21.java
import java.util.Scanner;

class AntrianKRS {
    Mahasiswa21[] data;
    int front, rear, size, max;
    int sudahKRS = 0; 

    public AntrianKRS(int max) {
        this.max = max;
        this.data = new Mahasiswa21[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == max; }

    public void tambahAntrian(Mahasiswa21 mhs) {
        if (sudahKRS + size >= 30) {
            System.out.println("Batas maksimal DPA melayani 30 mahasiswa tercapai!");
            return;
        }
        if (isFull()) {
            System.out.println("Antrian penuh (Maks 10)!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian KRS.");
    }

    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Memproses KRS untuk:");
        int iter = Math.min(size, 2); // Proses 2 sekaligus, atau 1 jika sisa 1
        for (int i = 0; i < iter; i++) {
            System.out.print("- ");
            data[front].tampilkanData();
            front = (front + 1) % max;
            size--;
            sudahKRS++;
        }
    }

    public void clear() {
        front = 0; rear = -1; size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tampilSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong."); return;
        }
        System.out.println("Daftar Antrian KRS:");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ". ");
            data[(front + i) % max].tampilkanData();
        }
    }
    
    public void tampilDepan() {
        if (isEmpty()) { System.out.println("Antrian kosong."); return; }
        System.out.print("Antrian 1: "); data[front].tampilkanData();
        if (size > 1) {
            System.out.print("Antrian 2: "); data[(front + 1) % max].tampilkanData();
        }
    }

    public void tampilBelakang() {
        if (isEmpty()) { System.out.println("Antrian kosong."); return; }
        System.out.print("Antrian paling belakang: "); data[rear].tampilkanData();
    }

    public void infoKRS() {
        System.out.println("Mahasiswa masih mengantri : " + size);
        System.out.println("Mahasiswa sudah proses KRS: " + sudahKRS);
    }
}

public class TugasKRS21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10); // Kapasitas maks 10
        int pilihan;
        do {
            System.out.println("\n=== Layanan KRS DPA ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Proses KRS (2 Mahasiswa)");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Tampilkan 2 Terdepan");
            System.out.println("5. Tampilkan Paling Akhir");
            System.out.println("6. Kosongkan Antrian");
            System.out.println("7. Info Status KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt(); sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM  : "); String nim = sc.nextLine();
                    System.out.print("Nama : "); String nama = sc.nextLine();
                    System.out.print("Prodi: "); String prodi = sc.nextLine();
                    System.out.print("Kelas: "); String kelas = sc.nextLine();
                    antrian.tambahAntrian(new Mahasiswa21(nim, nama, prodi, kelas));
                    break;
                case 2: antrian.prosesKRS(); break;
                case 3: antrian.tampilSemua(); break;
                case 4: antrian.tampilDepan(); break;
                case 5: antrian.tampilBelakang(); break;
                case 6: antrian.clear(); break;
                case 7: antrian.infoKRS(); break;
            }
        } while (pilihan != 0);
        sc.close();
    }
}
```

Output Tugas:

```bash
=== Layanan KRS DPA ===
1. Tambah Antrian
2. Proses KRS (2 Mahasiswa)
...
Pilih: 1
NIM  : 111
Nama : Andi
Prodi: TI
Kelas: 1A
Andi berhasil masuk ke antrian KRS.

=== Layanan KRS DPA ===
...
Pilih: 1
NIM  : 222
Nama : Budi
Prodi: TI
Kelas: 1B
Budi berhasil masuk ke antrian KRS.

=== Layanan KRS DPA ===
...
Pilih: 1
NIM  : 333
Nama : Citra
Prodi: SIB
Kelas: 1C
Citra berhasil masuk ke antrian KRS.

=== Layanan KRS DPA ===
...
Pilih: 4
Antrian 1: 111 Andi TI 1A
Antrian 2: 222 Budi TI 1B

=== Layanan KRS DPA ===
...
Pilih: 2
Memproses KRS untuk:
- 111 Andi TI 1A
- 222 Budi TI 1B

=== Layanan KRS DPA ===
...
Pilih: 7
Mahasiswa masih mengantri : 1
Mahasiswa sudah proses KRS: 2
```
