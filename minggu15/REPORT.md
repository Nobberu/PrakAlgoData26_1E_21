# REPORT

## 1. Kegiatan Praktikum 1: Collection - List

### 1.1. Kode Program (`ContohList21.java`)

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContohList21 {
    public static void main(String[] args) {
        // Percobaan 1: ArrayList tipe dinamis (Object)
        List l = new ArrayList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add("Cireng");
        System.out.printf("Elemen 0: %d total elemen: %d elemen terakhir: %s\n", l.get(0), l.size(), l.get(l.size() - 1));
        
        l.add(4);
        l.remove(0);
        System.out.printf("Elemen 0: %d total elemen: %d elemen terakhir: %s\n", l.get(0), l.size(), l.get(l.size() - 1));

        System.out.println("-------------------------------------");

        // Percobaan 1 (Modifikasi): LinkedList tipe spesifik String
        LinkedList<String> names = new LinkedList<>();
        names.add("Noureen");
        names.add("Akhleema");
        names.add("Shannum");
        names.add("Uwais");
        names.add("Al-Qarni");
        System.out.printf("Elemen 0: %s total elemen: %d elemen terakhir: %s\n", names.get(0), names.size(), names.get(names.size() - 1));
        
        names.set(0, "My kid");
        System.out.printf("Elemen 0: %s total elemen: %d elemen terakhir: %s\n", names.get(0), names.size(), names.get(names.size() - 1));
        System.out.println("Names: " + names.toString());
        
        // Modifikasi push()
        names.push("Mei-mei");
        System.out.printf("Elemen 0: %s total elemen: %d elemen terakhir: %s\n", names.getFirst(), names.size(), names.getLast());
        System.out.println("Names: " + names.toString());
    }
}
```

### 1.2. Hasil Eksekusi

```text
Elemen 0: 1 total elemen: 4 elemen terakhir: Cireng
Elemen 0: 2 total elemen: 4 elemen terakhir: 4
-------------------------------------
Elemen 0: Noureen total elemen: 5 elemen terakhir: Al-Qarni
Elemen 0: My kid total elemen: 5 elemen terakhir: Al-Qarni
Names: [My kid, Akhleema, Shannum, Uwais, Al-Qarni]
Elemen 0: Mei-mei total elemen: 6 elemen terakhir: Al-Qarni
Names: [Mei-mei, My kid, Akhleema, Shannum, Uwais, Al-Qarni]
```

### 1.3. Jawaban Pertanyaan Percobaan
1. **Mengapa semua jenis data bisa ditampung ke dalam sebuah ArrayList pada baris 25-36?**
   Karena `ArrayList` diinisialisasi tanpa menspesifikasikan tipe data generik (`List l = new ArrayList();`). Ini merupakan *raw type*, sehingga Java secara otomatis akan menampung semua data sebagai tipe `Object` yang merupakan *superclass* dari semua tipe data.
2. **Modifikasi agar data yang ditampung hanya satu jenis!**
   Gunakan *Diamond Operator* `< >`. Contohnya: `List<Integer> l = new ArrayList<>();`
3. **Penjelasan fungsi `push("Mei-mei")` pada `LinkedList`:**
   Method `push()` pada `LinkedList` menyisipkan elemen pada posisi paling depan (index ke-0), layaknya operasi *stack* (tumpukan). Elemen "Mei-mei" menjadi `Elemen 0` yang baru dan otomatis menggeser indeks elemen-elemen sebelumnya.

---

## 2. Kegiatan Praktikum 2: Collection - Stack, Iterator & Stream

### 2.1. Kode Program (`LoopCollection21.java`)

```java
import java.util.Stack;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;

public class LoopCollection21 {
    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.push("Salak");

        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }
        System.out.println("\n" + fruits.toString());

        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }
        
        System.out.println("\n");
        // Refill stack
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.push("Salak");
        
        fruits.push("Melon");
        fruits.push("Durian");
        
        System.out.println("");
        for (Iterator<String> it = fruits.iterator(); it.hasNext();) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }
        System.out.println("");

        fruits.stream().forEach(e -> {
            System.out.printf("%s ", e);
        });
        System.out.println("");
        
        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));
        }
        System.out.println("");

        // Uji coba modifikasi No 5 & 6
        System.out.println("\n--- Hasil Modifikasi ---");
        fruits.set(fruits.size() - 1, "Strawberry");
        fruits.addAll(Arrays.asList("Mango", "Guava", "Avocado"));
        Collections.sort(fruits);
        System.out.println("Isi fruits setelah diurutkan: " + fruits.toString());
    }
}
```

### 2.2. Jawaban Pertanyaan Percobaan
1. **Perbedaan `push()` dan `add()` pada objek fruits:**
   * `push()` adalah method bawaan dari class `Stack` yang menambahkan elemen ke urutan paling atas dari tumpukan (prinsip *Last-In-First-Out* / LIFO).
   * `add()` adalah method turunan dari interface `Collection`/class `Vector` yang menyisipkan elemen ke bagian akhir list. Keduanya mengalokasikan data di posisi yang sama dalam implementasi internal Java, namun `push` akan me-return *item* yang dimasukkan, sedangkan `add` akan me-return status boolean.
2. **Jika baris penambahan "Melon" dan "Durian" dihilangkan:**
   Kedua buah tersebut tidak akan tersimpan di dalam memori `Stack`. Konsekuensinya, saat iterasi *print* dilakukan ke konsol, kedua nama buah tersebut tidak akan muncul.
3. **Fungsi perulangan Iterator (baris 46-49):**
   Digunakan untuk melakukan penelusuran (iterasi) yang aman pada *collection*. Method `hasNext()` mengecek apakah masih ada elemen yang tersisa, dan `next()` akan mengambil nilai elemen pada iterasi saat ini untuk ditampilkan.
4. **Apa yang terjadi jika mengganti `Stack<String>` menjadi `List<String>`?**
   Akan memunculkan *Compile-time error*. Interface `List` tidak memiliki definisi method `push()`, `empty()`, maupun `pop()`. Fungsi-fungsi tersebut eksklusif merupakan karakteristik dari struktur data *Stack*.
5. **Ganti elemen terakhir & 6. Tambahkan 3 buah dan sorting:**
   *Telah diimplementasikan pada baris terakhir kode `LoopCollection21.java`.*

---

## 3. Kegiatan Praktikum 3: Implementasi Collection pada Objek

### 3.1. Kode Program (`Mahasiswa21.java`)

```java
public class Mahasiswa21 implements Comparable<Mahasiswa21> {
    String nim;
    String nama;
    String notelp;

    public Mahasiswa21() {}

    public Mahasiswa21(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    @Override
    public String toString() {
        return "Mahasiswa21{" + "nim=" + nim + ", nama=" + nama + ", notelp=" + notelp + '}';
    }

    @Override
    public int compareTo(Mahasiswa21 o) {
        return this.nim.compareTo(o.nim); // Sorting ascending by NIM
    }
}
```

### 3.2. Kode Program (`ListMahasiswa21.java`)

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListMahasiswa21 {
    List<Mahasiswa21> mahasiswas = new ArrayList<>();

    public void tambah(Mahasiswa21... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa21 mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) return i;
        }
        return -1;
    }

    // Binary Search (Syarat: Collection harus berurutan)
    int binarySearch(String nim) {
        Mahasiswa21 dummyMhs = new Mahasiswa21(nim, "", "");
        Collections.sort(mahasiswas);
        return Collections.binarySearch(mahasiswas, dummyMhs);
    }

    public void sortAscending() {
        Collections.sort(mahasiswas);
    }

    public void sortDescending() {
        Collections.sort(mahasiswas, Comparator.reverseOrder());
    }

    public static void main(String[] args) {
        ListMahasiswa21 lm = new ListMahasiswa21();
        Mahasiswa21 m = new Mahasiswa21("201234", "Noureen", "021xx1");
        Mahasiswa21 m1 = new Mahasiswa21("201235", "Akhleema", "021xx2");
        Mahasiswa21 m2 = new Mahasiswa21("201236", "Shannum", "021xx3");

        lm.tambah(m, m1, m2);
        lm.tampil();
        
        lm.update(lm.linearSearch("201235"), new Mahasiswa21("201235", "Akhleema Lela", "021xx2"));
        System.out.println("");
        lm.tampil();

        System.out.println("\n--- Uji Coba Sorting Descending ---");
        lm.sortDescending();
        lm.tampil();
    }
}
```

### 3.3. Jawaban Pertanyaan Percobaan
1. **Konsep fungsi `tambah(Mahasiswa21... mahasiswa)`:**
   Metode ini menggunakan fitur **Varargs (Variable Arguments)**. Keunggulan utamanya adalah fleksibilitas; kita bisa mengoper jumlah argumen yang dinamis (bahkan nol argumen) tanpa perlu mendefinisikan struktur array baru pada pemanggil fungsi.
2. **Binary Search:**
   *Telah diimplementasikan pada method `binarySearch()` di `ListMahasiswa21.java` menggunakan `Collections.binarySearch()`.*
3. **Fungsi Sorting:**
   *Telah diimplementasikan pada method `sortAscending()` dan `sortDescending()` dengan bantuan interface `Comparable` pada objek `Mahasiswa21`.*

---

## 4. Tugas Praktikum: Sistem Pengolahan Data Nilai Mahasiswa

### 4.1. Kode Program Lengkap (`SistemNilai21.java`)
Program ini memuat implementasi class `MhsTugas21`, `MataKuliah21`, `Nilai21`, serta mengintegrasikan antrean penghapusan menggunakan tipe koleksi `Queue`.

```java
import java.util.*;

class MhsTugas21 {
    String nim, nama, telf;
    public MhsTugas21(String nim, String nama, String telf) {
        this.nim = nim; this.nama = nama; this.telf = telf;
    }
}

class MataKuliah21 {
    String kode, mk;
    int sks;
    public MataKuliah21(String kode, String mk, int sks) {
        this.kode = kode; this.mk = mk; this.sks = sks;
    }
}

class Nilai21 {
    MhsTugas21 mhs;
    MataKuliah21 mk;
    double nilai;
    public Nilai21(MhsTugas21 mhs, MataKuliah21 mk, double nilai) {
        this.mhs = mhs; this.mk = mk; this.nilai = nilai;
    }
}

public class SistemNilai21 {
    static List<MhsTugas21> listMhs = new ArrayList<>();
    static List<MataKuliah21> listMK = new ArrayList<>();
    static List<Nilai21> listNilai = new ArrayList<>();
    // Fitur hapus data via Queue (Sesuai instruksi soal)
    static Queue<String> queueHapus = new LinkedList<>(); 
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        int menu = 0;
        do {
            System.out.println("\n************************************************");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("************************************************");
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Hapus Data Mahasiswa (Antrean Queue)");
            System.out.println("6. Keluar");
            System.out.print("Pilih : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1: inputNilai(); break;
                case 2: tampilNilai(); break;
                case 3: cariNilai(); break;
                case 4: urutNilai(); break;
                case 5: hapusMahasiswa(); break;
                case 6: System.out.println("Keluar dari program."); break;
                default: System.out.println("Menu tidak valid.");
            }
        } while (menu != 6);
    }

    static void initData() {
        listMhs.add(new MhsTugas21("20001", "Thalhah", "021xxx"));
        listMhs.add(new MhsTugas21("20002", "Zubair", "021xxx"));
        listMhs.add(new MhsTugas21("20003", "Abdur-Rahman", "021xxx"));
        listMhs.add(new MhsTugas21("20004", "Sa'ad", "021xxx"));
        listMhs.add(new MhsTugas21("20005", "Sa'id", "021xxx"));
        listMhs.add(new MhsTugas21("20006", "Ubaidah", "021xxx"));

        listMK.add(new MataKuliah21("00001", "Internet of Things", 3));
        listMK.add(new MataKuliah21("00002", "Algoritma dan Struktur Data", 2));
        listMK.add(new MataKuliah21("00003", "Algoritma dan Pemrograman", 2));
        listMK.add(new MataKuliah21("00004", "Praktikum Algoritma dan Struktur Data", 3));
        listMK.add(new MataKuliah21("00005", "Praktikum Algoritma dan Pemrograman", 3));
    }

    static void inputNilai() {
        System.out.println("--- DAFTAR MAHASISWA ---");
        System.out.printf("%-10s %-15s %-10s\n", "NIM", "Nama", "Telf");
        for (MhsTugas21 m : listMhs) {
            System.out.printf("%-10s %-15s %-10s\n", m.nim, m.nama, m.telf);
        }
        System.out.print("Pilih mahasiswa by nim: ");
        String nim = sc.nextLine();
        MhsTugas21 mhsTerpilih = null;
        for (MhsTugas21 m : listMhs) {
            if (m.nim.equals(nim)) mhsTerpilih = m;
        }

        System.out.println("\n--- DAFTAR MATA KULIAH ---");
        System.out.printf("%-10s %-40s %-5s\n", "Kode", "Mata Kuliah", "SKS");
        for (MataKuliah21 mk : listMK) {
            System.out.printf("%-10s %-40s %-5d\n", mk.kode, mk.mk, mk.sks);
        }
        System.out.print("Pilih MK by kode: ");
        String kode = sc.nextLine();
        MataKuliah21 mkTerpilih = null;
        for (MataKuliah21 mk : listMK) {
            if (mk.kode.equals(kode)) mkTerpilih = mk;
        }

        if (mhsTerpilih != null && mkTerpilih != null) {
            System.out.print("Nilai : ");
            double nilai = sc.nextDouble();
            listNilai.add(new Nilai21(mhsTerpilih, mkTerpilih, nilai));
            System.out.println("Data berhasil disimpan!");
        } else {
            System.out.println("NIM atau Kode MK tidak ditemukan!");
        }
    }

    static void tampilNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.printf("%-10s %-15s %-40s %-5s %-5s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai21 n : listNilai) {
            System.out.printf("%-10s %-15s %-40s %-5d %-5.2f\n", n.mhs.nim, n.mhs.nama, n.mk.mk, n.mk.sks, n.nilai);
        }
    }

    static void cariNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.print("Masukkan data mahasiswa [nim]: ");
        String cariNim = sc.nextLine();
        
        int totalSks = 0;
        System.out.printf("%-10s %-15s %-40s %-5s %-5s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai21 n : listNilai) {
            if (n.mhs.nim.equals(cariNim)) {
                System.out.printf("%-10s %-15s %-40s %-5d %-5.2f\n", n.mhs.nim, n.mhs.nama, n.mk.mk, n.mk.sks, n.nilai);
                totalSks += n.mk.sks;
            }
        }
        System.out.println("Total SKS " + totalSks + " telah diambil.");
    }

    static void urutNilai() {
        listNilai.sort((n1, n2) -> Double.compare(n2.nilai, n1.nilai));
        System.out.println("\nDAFTAR NILAI MAHASISWA (Urut Berdasarkan Nilai Descending)");
        tampilNilai();
    }

    static void hapusMahasiswa() {
        System.out.print("Masukkan NIM Mahasiswa yang ingin diajukan untuk dihapus: ");
        String nimHapus = sc.nextLine();
        
        queueHapus.add(nimHapus);
        System.out.println("NIM " + nimHapus + " masuk ke antrean penghapusan.");
        
        if (!queueHapus.isEmpty()) {
            String nimProses = queueHapus.poll();
            listMhs.removeIf(m -> m.nim.equals(nimProses));
            listNilai.removeIf(n -> n.mhs.nim.equals(nimProses));
            System.out.println("Berhasil memproses antrean. Data mahasiswa dengan NIM " + nimProses + " telah dihapus dari sistem.");
        }
    }
}
```
