# REPORT

<br>

## Jobsheet IX
### Percobaan 1: Mahasiswa mengumpulkan tugas

Kode program:

```java
Java
Mahasiswa21.java

public class Mahasiswa21 {

    String nim, nama, kelas;
    int nilai;

    Mahasiswa21() {}

    Mahasiswa21(String nim, String nama, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        nilai = -1;
    }

    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}
```

```java
Java
StackTugasMahasiswa21.java

public class StackTugasMahasiswa21 {

    Mahasiswa21[] stack;
    int top, size;

    public StackTugasMahasiswa21(int size) {
        this.size = size;
        stack = new Mahasiswa21[size];
        top = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa21 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println(
                "Stack penuh! Tidak bisa menambahkan tugas lagi."
            );
        }
    }

    public Mahasiswa21 pop() {
        if (!isEmpty()) {
            Mahasiswa21 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack kosong! Tidak ada tugas untuk dinilai.");
            return null;
        }
    }

    public Mahasiswa21 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println(
                "Stack kosong! Tidak ada tugas yang dikumpulkan."
            );
            return null;
        }
    }

    public Mahasiswa21 peekFirst() {
        if (!isEmpty()) {
            return stack[0];
        } else {
            System.out.println(
                "Stack kosong! Tidak ada tugas yang dikumpulkan."
            );
            return null;
        }
    }

    public int hitungTugas() {
        return top + 1;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(
                stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas
            );
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
        StackTugasMahasiswa21 stack = new StackTugasMahasiswa21(5);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Tugas Terbawah");
            System.out.println("5. Melihat Daftar Tugas");
            System.out.println("6. Melihat Jumlah Tugas Dikumpulkan");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    Mahasiswa21 mhs = new Mahasiswa21(nim, nama, kelas);
                    stack.push(mhs);
                    System.out.printf(
                        "Tugas %s berhasil dikumpulkan\n",
                        mhs.nama
                    );
                    break;
                case 2:
                    Mahasiswa21 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println(
                            "Menilai tugas dari " + dinilai.nama
                        );
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf(
                            "Nilai Tugas %s adalah %d\n",
                            dinilai.nama,
                            nilai
                        );
                    }
                    break;
                case 3:
                    Mahasiswa21 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println(
                            "Tugas terakhir dikumpulkan oleh " + lihat.nama
                        );
                    }
                    break;
                case 4:
                    Mahasiswa21 lihatFirst = stack.peekFirst();
                    if (lihatFirst != null) {
                        System.out.println(
                            "Tugas terakhir dikumpulkan oleh " + lihatFirst.nama
                        );
                    }
                    break;
                case 5:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;
                case 6:
                    int total = stack.hitungTugas();
                    System.out.println(
                        "Tugas yang dikumpulkan sebanyak: " + total
                    );
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 6);
    }
}
```


Output:

```bash
Bash

PS C:\GitHub\PrakAlgoData26_1E_21> java minggu9/src/MahasiswaDemo2121.java

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 1
Nama: Dila
NIM: 1001
Kelas: 1A
Tugas Dila berhasil dikumpulkan

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 1
Nama: Erik
NIM: 1002
Kelas: 1B
Tugas Erik berhasil dikumpulkan

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 3
Tugas terakhir dikumpulkan oleh Erik

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 1
Nama: Tika
NIM: 1003
Kelas: 1C
Tugas Tika berhasil dikumpulkan

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 4
Daftar semua tugas
Nama	NIM	Kelas
Dila	1001	1A
Erik	1002	1B
Tika	1003	1C

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 2
Menilai tugas dari Tika
Masukkan nilai (0-100): 87
Nilai Tugas Tika adalah 87

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 4
Daftar semua tugas
Nama	NIM	Kelas
Dila	1001	1A
Erik	1002	1B

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Tugas Terbawah
5. Melihat Daftar Tugas
6. Melihat Jumlah Tugas Dikumpulkan
Pilih: 4
Tugas terakhir dikumpulkan oleh Dila
```

#### Pertanyaan

1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi
hasil percobaan! Bagian mana yang perlu diperbaiki?

= Keluaran yang dihasilkan oleh kode yang saya tulis sudah sesuai dengan verifikasi hasil percobaan pada Jobsheet.

<br>

2. Berapa banyak data tugas mahasiswa yang dapat ditampung di dalam Stack? Tunjukkan potongan
kode programnya!

= Size dari stack yang ada di kode program adalah 5, dan ini potongan kodenya.
```java
StackTugasMahasiswa21 stack = new StackTugasMahasiswa21(5);
```

<br>

3. Mengapa perlu pengecekan kondisi !isFull() pada method push? Kalau kondisi if-else tersebut
dihapus, apa dampaknya?

= Pengecekan isFull() dilakukan untuk mencegah overflow. Jika tidak memakai pengecekan ini, program akan error OutOfBounds saat mengakses index diluar size.

<br>

4. Modifikasi kode program pada class MahasiswaDemo dan StackTugasMahasiswa sehingga
pengguna juga dapat melihat mahasiswa yang pertama kali mengumpulkan tugas melalui operasi
lihat tugas terbawah!

= Modifikasi kode program untuk melihat mahasiswa pertama yang mengumpulkan:

```java
MahasiswaDemo21.java

case 4:
    Mahasiswa21 lihatFirst = stack.peekFirst();
    if (lihatFirst != null) {
        System.out.println(
            "Tugas terakhir dikumpulkan oleh " + lihatFirst.nama
        );
    }
    break;


StackTugasMahasiswa21.java

public Mahasiswa21 peekFirst() {
    if (!isEmpty()) {
        return stack[0];
    } else {
        System.out.println(
            "Stack kosong! Tidak ada tugas yang dikumpulkan."
        );
        return null;
    }
}
```

<br>

5. Tambahkan method untuk dapat menghitung berapa banyak tugas yang sudah dikumpulkan saat
ini, serta tambahkan operasi menunya!

= Modifikasi kode program untuk melihat jumlah mahasiswa yang mengumpulkan:

```java
MahasiswaDemo21.java

case 6:
    int total = stack.hitungTugas();
    System.out.println(
        "Tugas yang dikumpulkan sebanyak: " + total
    );
    break;


StackTugasMahasiswa21.java

public int hitungTugas() {
    return top + 1;
}
```

<br>

### Percobaan 2: Konversi Nilai Tugas ke Biner

Kode program:

```java
Java
Mahasiswa21.java

public class Mahasiswa21 {

    String nim, nama, kelas;
    int nilai;

    Mahasiswa21() {}

    Mahasiswa21(String nim, String nama, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        nilai = -1;
    }

    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}
```

```java
Java
StackKonversi21.java

public class StackKonversi21 {

    int[] tumpukanBiner;
    int size, top;

    public StackKonversi21() {
        this.size = 32;
        tumpukanBiner = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh.");
        } else {
            top++;
            tumpukanBiner[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return -1;
        } else {
            int data = tumpukanBiner[top];
            top--;
            return data;
        }
    }
}
```

```java
Java
StackTugasMahasiswa21.java

public class StackTugasMahasiswa21 {

    Mahasiswa21[] stack;
    int top, size;

    public StackTugasMahasiswa21(int size) {
        this.size = size;
        stack = new Mahasiswa21[size];
        top = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa21 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println(
                "Stack penuh! Tidak bisa menambahkan tugas lagi."
            );
        }
    }

    public Mahasiswa21 pop() {
        if (!isEmpty()) {
            Mahasiswa21 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack kosong! Tidak ada tugas untuk dinilai.");
            return null;
        }
    }

    public Mahasiswa21 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println(
                "Stack kosong! Tidak ada tugas yang dikumpulkan."
            );
            return null;
        }
    }

    public Mahasiswa21 peekFirst() {
        if (!isEmpty()) {
            return stack[0];
        } else {
            System.out.println(
                "Stack kosong! Tidak ada tugas yang dikumpulkan."
            );
            return null;
        }
    }

    public int hitungTugas() {
        return top + 1;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(
                stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas
            );
        }
    }

    public String konversiDesimalKeBiner(int nilai) {
        StackKonversi21 stack = new StackKonversi21();
        while (nilai > 0) {
            int sisa = nilai % 2;
            stack.push(sisa);
            nilai = nilai / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
        return biner;
    }
}
```

```java
Java
MahasiswaDemo21.java

import java.util.Scanner;

public class MahasiswaDemo21 {

    public static void main(String[] args) {
        StackTugasMahasiswa21 stack = new StackTugasMahasiswa21(5);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Tugas Terbawah");
            System.out.println("5. Melihat Daftar Tugas");
            System.out.println("6. Melihat Jumlah Tugas Dikumpulkan");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    Mahasiswa21 mhs = new Mahasiswa21(nim, nama, kelas);
                    stack.push(mhs);
                    System.out.printf(
                        "Tugas %s berhasil dikumpulkan\n",
                        mhs.nama
                    );
                    break;
                case 2:
                    Mahasiswa21 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println(
                            "Menilai tugas dari " + dinilai.nama
                        );
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf(
                            "Nilai Tugas %s adalah %d\n",
                            dinilai.nama,
                            nilai
                        );
                        String biner = stack.konversiDesimalKeBiner(nilai);
                        System.out.println("Nilai Biner Tugas: " + biner);
                    }
                    break;
                case 3:
                    Mahasiswa21 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println(
                            "Tugas terakhir dikumpulkan oleh " + lihat.nama
                        );
                    }
                    break;
                case 4:
                    Mahasiswa21 lihatFirst = stack.peekFirst();
                    if (lihatFirst != null) {
                        System.out.println(
                            "Tugas terakhir dikumpulkan oleh " + lihatFirst.nama
                        );
                    }
                    break;
                case 5:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;
                case 6:
                    int total = stack.hitungTugas();
                    System.out.println(
                        "Tugas yang dikumpulkan sebanyak: " + total
                    );
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}
```

Output:

```bash
Bash

PS C:\GitHub\PrakAlgoData26_1E_21> java minggu9/src/MahasiswaDemo21.java

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Tugas Terbawah
5. Melihat Daftar Tugas
6. Melihat Jumlah Tugas Dikumpulkan
Pilih: 1
Nama: Tes
NIM: 12
Kelas: 12
Tugas Tes berhasil dikumpulkan

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Tugas Terbawah
5. Melihat Daftar Tugas
6. Melihat Jumlah Tugas Dikumpulkan
Pilih: 2
Menilai tugas dari Tes
Masukkan nilai (0-100): 90
Nilai Tugas Tes adalah 90
Nilai Biner Tugas: 1011010
```

### Pertanyaan

1. Jelaskan alur kerja dari method konversiDesimalKeBiner!

= Nilai desimal dari mahasiswa dibagi 2 dengan loop menggunakan while, lalu hasil modulus dimasukkan kedalam stack menggunakan push, setelah nilai menjadi 0, data diambil dari stack menggunakan pop. Karena stack menggunakan LIFO makan output akan mengurutkan biner ke urutan yang benar.

<br>
    
2. Pada method konversiDesimalKeBiner, ubah kondisi perulangan menjadi while (kode != 0),
bagaimana hasilnya? Jelaskan alasannya!

= Perubahan ke `while (nilai != 0)` hasilnya sama saja dengan program default.

<br>

### Latihan Praktikum

```java
java
Surat21.java

class Surat21 {

    String idSurat, namaMahasiswa, kelas;
    char jenisIzin;
    int durasi;

    Surat21() {}

    Surat21(
        String idSurat,
        String namaMahasiswa,
        String kelas,
        char jenisIzin,
        int durasi
    ) {
        this.idSurat = idSurat;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
        this.jenisIzin = jenisIzin;
        this.durasi = durasi;
    }
}
```

```java
java
StackSurat21.java

public class StackSurat21 {

    Surat21[] stack;
    int size, top;

    public StackSurat21(int size) {
        this.size = size;
        stack = new Surat21[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat21 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
            System.out.println(
                "Surat izin dari " +
                    surat.namaMahasiswa +
                    " berhasil ditambahkan."
            );
        } else {
            System.out.println(
                "Stack Penuh! Tidak dapat menerima surat izin lagi."
            );
        }
    }

    public Surat21 pop() {
        if (!isEmpty()) {
            Surat21 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack Kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat21 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack Kosong! Tidak ada surat yang terkumpul.");
            return null;
        }
    }

    public void cariSurat(String nama) {
        if (!isEmpty()) {
            boolean ditemukan = false;
            for (int i = top; i >= 0; i--) {
                if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                    System.out.println("\n--- Surat Ditemukan ---");
                    System.out.println("ID Surat    : " + stack[i].idSurat);
                    System.out.println(
                        "Nama        : " + stack[i].namaMahasiswa
                    );
                    System.out.println("Kelas       : " + stack[i].kelas);
                    System.out.println(
                        "Jenis Izin  : " +
                            (stack[i].jenisIzin == 'S' ? "Sakit" : "Izin Lain")
                    );
                    System.out.println(
                        "Durasi      : " + stack[i].durasi + " hari"
                    );
                    ditemukan = true;
                    break;
                }
            }
            if (!ditemukan) {
                System.out.println(
                    "Surat dari mahasiswa bernama " + nama + " tidak ditemukan."
                );
            }
        } else {
            System.out.println("Stack Kosong! Tidak ada data untuk dicari.");
        }
    }
}
```

```java
java
SuratMain21.java

import java.util.Scanner;

public class SuratMain21 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StackSurat21 tumpukanSurat = new StackSurat21(10);
        int pilih;

        do {
            System.out.println("\n=== Sistem Manajemen Surat Izin ===");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan ID Surat: ");
                    String id = scan.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scan.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = scan.nextLine();
                    System.out.print(
                        "Masukkan Jenis Izin (S untuk Sakit / I untuk Izin): "
                    );
                    char jenis = scan.nextLine().toUpperCase().charAt(0);
                    System.out.print("Masukkan Durasi (hari): ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat21 suratBaru = new Surat21(
                        id,
                        nama,
                        kelas,
                        jenis,
                        durasi
                    );
                    tumpukanSurat.push(suratBaru);
                    break;
                case 2:
                    Surat21 diproses = tumpukanSurat.pop();
                    if (diproses != null) {
                        System.out.println("\n--- Memproses Surat ---");
                        System.out.println(
                            "Surat dari " +
                                diproses.namaMahasiswa +
                                " telah diverifikasi oleh Admin Prodi."
                        );
                    }
                    break;
                case 3:
                    Surat21 terakhir = tumpukanSurat.peek();
                    if (terakhir != null) {
                        System.out.println("\n--- Surat Teratas ---");
                        System.out.println("ID Surat   : " + terakhir.idSurat);
                        System.out.println(
                            "Nama       : " + terakhir.namaMahasiswa
                        );
                        System.out.println("Kelas      : " + terakhir.kelas);
                        System.out.println(
                            "Jenis Izin : " + terakhir.jenisIzin
                        );
                    }
                    break;
                case 4:
                    System.out.print("Masukkan Nama Mahasiswa yang dicari: ");
                    String keyword = scan.nextLine();
                    tumpukanSurat.cariSurat(keyword);
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println(
                        "Pilihan tidak valid. Silakan coba lagi."
                    );
            }
        } while (pilih != 5);

        scan.close();
    }
}
```

Output

```bash
Bash

PS C:\GitHub\PrakAlgoData26_1E_21> java minggu9/src/SuratMain21.java

=== Sistem Manajemen Surat Izin ===
1. Terima Surat Izin
2. Proses Surat Izin
3. Lihat Surat Izin Terakhir
4. Cari Surat
5. Keluar
Pilih menu (1-5): 1
Masukkan ID Surat: 1001
Masukkan Nama Mahasiswa: Test
Masukkan Kelas: 1E
Masukkan Jenis Izin (S untuk Sakit / I untuk Izin): S
Masukkan Durasi (hari): 2
Surat izin dari Test berhasil ditambahkan.

=== Sistem Manajemen Surat Izin ===
1. Terima Surat Izin
2. Proses Surat Izin
3. Lihat Surat Izin Terakhir
4. Cari Surat
5. Keluar
Pilih menu (1-5): 2

--- Memproses Surat ---
Surat dari Test telah diverifikasi oleh Admin Prodi.

=== Sistem Manajemen Surat Izin ===
1. Terima Surat Izin
2. Proses Surat Izin
3. Lihat Surat Izin Terakhir
4. Cari Surat
5. Keluar
Pilih menu (1-5): 3
Stack Kosong! Tidak ada surat yang terkumpul.

=== Sistem Manajemen Surat Izin ===
1. Terima Surat Izin
2. Proses Surat Izin
3. Lihat Surat Izin Terakhir
4. Cari Surat
5. Keluar
Pilih menu (1-5): 4
Masukkan Nama Mahasiswa yang dicari: test
Stack Kosong! Tidak ada data untuk dicari.
```
