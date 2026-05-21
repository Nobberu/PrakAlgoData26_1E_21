# REPORT

<br>

## Jobsheet XII - Double Linked List

### Percobaan 1 & 2: Double Linked List Dasar & Penghapusan

Kode program:

```java
// Mahasiswa21.java
public class Mahasiswa21 {
    String nim, nama, kelas;
    double ipk;

    public Mahasiswa21(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampil() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Kelas : " + kelas);
        System.out.println("IPK   : " + ipk);
    }
}
```

```java
// Node21.java
public class Node21 {
    Mahasiswa21 data;
    Node21 prev, next;

    public Node21(Node21 prev, Mahasiswa21 data, Node21 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
```

```java
// DoubleLinkedList21.java
public class DoubleLinkedList21 {
    Node21 head, tail;
    int size;

    public DoubleLinkedList21() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa21 data) {
        if (isEmpty()) {
            head = tail = new Node21(null, data, null);
        } else {
            Node21 newNode = new Node21(null, data, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Mahasiswa21 data) {
        if (isEmpty()) {
            head = tail = new Node21(null, data, null);
        } else {
            Node21 newNode = new Node21(tail, data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, Mahasiswa21 data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks di luar batas!");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node21 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node21 newNode = new Node21(current.prev, data, current);
            newNode.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa21 data) {
        Node21 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }
        if (current == tail) {
            addLast(data);
        } else {
            Node21 newNode = new Node21(current, data, current.next);
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        System.out.println("Data yang dihapus:");
        head.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        System.out.println("Data yang dihapus:");
        tail.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Indeks tidak valid atau List kosong.");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node21 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println("Data yang dihapus:");
            current.data.tampil();
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void removeAfter(String keyNim) {
        Node21 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Node target tidak ditemukan atau tidak ada node setelahnya.");
            return;
        }
        System.out.println("Data yang dihapus:");
        current.next.data.tampil();
        if (current.next == tail) {
            tail = current;
            tail.next = null;
        } else {
            current.next = current.next.next;
            current.next.prev = current;
        }
        size--;
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
        } else {
            System.out.println("Data Pertama:");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
        } else {
            System.out.println("Data Terakhir:");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        Node21 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Data pada index " + index + ":");
        current.data.tampil();
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node21 current = head;
        while (current != null) {
            current.data.tampil();
            System.out.println("-------------------------");
            current = current.next;
        }
        System.out.println("Total data: " + size);
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node21 current = tail;
        System.out.println("Daftar Data (Terbalik):");
        while (current != null) {
            current.data.tampil();
            System.out.println("-------------------------");
            current = current.prev;
        }
    }
}
```

```java
// DoubleLinkedListMain21.java
import java.util.Scanner;

public class DoubleLinkedListMain21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DoubleLinkedList21 list = new DoubleLinkedList21();
        int pilihan;

        do {
            System.out.println("\n===== MENU DOUBLE LINKED LIST =====");
            System.out.println("1. Tambah data di awal");
            System.out.println("2. Tambah data di akhir");
            System.out.println("3. Sisipkan data di tengah (setelah NIM)");
            System.out.println("4. Sisipkan data pada Index (Tugas)");
            System.out.println("5. Hapus data di awal");
            System.out.println("6. Hapus data di akhir");
            System.out.println("7. Hapus data pada Index (Tugas)");
            System.out.println("8. Hapus data setelah NIM (Tugas)");
            System.out.println("9. Tampilkan data");
            System.out.println("10. Tampilkan data Reverse (Modifikasi)");
            System.out.println("11. Cari data by Index (Tugas)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1: list.addFirst(inputMahasiswa(scan)); break;
                case 2: list.addLast(inputMahasiswa(scan)); break;
                case 3:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String keyNim = scan.nextLine();
                    System.out.println("Masukkan data baru:");
                    list.insertAfter(keyNim, inputMahasiswa(scan));
                    break;
                case 4:
                    System.out.print("Masukkan index untuk disisipkan: ");
                    int idx = scan.nextInt(); scan.nextLine();
                    list.add(idx, inputMahasiswa(scan));
                    break;
                case 5: list.removeFirst(); break;
                case 6: list.removeLast(); break;
                case 7:
                    System.out.print("Masukkan index yang dihapus: ");
                    int idRm = scan.nextInt(); scan.nextLine();
                    list.remove(idRm);
                    break;
                case 8:
                    System.out.print("Masukkan NIM target (hapus sebelahnya): ");
                    String keyDel = scan.nextLine();
                    list.removeAfter(keyDel);
                    break;
                case 9: list.print(); break;
                case 10: list.printReverse(); break;
                case 11:
                    System.out.print("Masukkan Index: ");
                    int findId = scan.nextInt(); scan.nextLine();
                    list.getIndex(findId);
                    break;
                case 0: System.out.println("Program selesai."); break;
                default: System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);
        scan.close();
    }

    private static Mahasiswa21 inputMahasiswa(Scanner scan) {
        System.out.print("NIM   : "); String nim = scan.nextLine();
        System.out.print("Nama  : "); String nama = scan.nextLine();
        System.out.print("Kelas : "); String kelas = scan.nextLine();
        System.out.print("IPK   : "); double ipk = scan.nextDouble(); scan.nextLine();
        return new Mahasiswa21(nim, nama, kelas, ipk);
    }
}
```

#### Pertanyaan 12.2.3 (Percobaan 1)

1. Jelaskan perbedaan struktur dan mekanisme traversal antara Single Linked List dan Double Linked List!
= **Single Linked List (SLL)** hanya memiliki satu _pointer_ (`next`) per *node*, sehingga penelusuran (*traversal*) hanya bisa dilakukan satu arah (maju) dari kepala ke ekor. Sedangkan **Double Linked List (DLL)** memiliki dua _pointer_ (`next` dan `prev`), sehingga penelusuran dapat dilakukan secara dua arah (maju dan mundur).

<br>

2. Perhatikan class Node, di dalamnya terdapat atribut `next` dan `prev`. Jelaskan fungsi masing-masing atribut tersebut pada proses traversal dan manipulasi node!
= `next` berfungsi sebagai referensi (penunjuk jalan) ke *node* selanjutnya, memungkinkan pergeseran pembacaan dari depan ke belakang. `prev` berfungsi sebagai referensi ke *node* sebelumnya, memungkinkan pembacaan mundur dan mempermudah manipulasi (penyisipan/penghapusan) di tengah tanpa harus mengulang pembacaan iterasi dari awal (head) mencari node sebelum target.

<br>

3. Perhatikan konstruktor pada class `DoubleLinkedList`. Jelaskan fungsi konstruktor tersebut terhadap kondisi awal linked list!
= Konstruktor tersebut menginisialisasi `head` dan `tail` menjadi `null` saat instansiasi kelas pertama kali. Ini menandakan bahwa list masih benar-benar kosong secara memori, tidak ada data sama sekali.

<br>

4. Perhatikan potongan kode berikut: `if (isEmpty()) { head = tail = newNode; }`. Mengapa `head` dan `tail` harus menunjuk node yang sama ketika linked list masih kosong?
= Karena saat linked list masih kosong dan dimasuki satu elemen baru, elemen tersebut secara bersamaan berstatus sebagai elemen paling awal (Head) dan juga sebagai elemen paling akhir (Tail) di dalam antrian.

<br>

5. Modifikasi method `print()` agar menampilkan pesan "Linked List masih kosong" ketika tidak terdapat data!
= *(Modifikasi ini sudah saya selesaikan di kode Java blok `print()` dengan seleksi awal `if(isEmpty()) { System.out.println("Linked List masih kosong."); return; }`).*

<br>

6. Modifikasi kode program dengan menambahkan method `printReverse()`!
= *(Method `printReverse()` sudah ditambahkan pada class `DoubleLinkedList21` dan dapat dipanggil melalui menu no 10 pada class Main).*

<br>

#### Pertanyaan 12.3.3 (Percobaan 2)

1. Perhatikan potongan kode berikut pada method `removeFirst()`:
```java
head = head.next;
head.prev = null;
```
Jelaskan fungsi masing-masing statement tersebut pada proses penghapusan node!
= Statement pertama (`head = head.next;`) berfungsi memindahkan posisi panah "Kepala/head" ke *node* nomor 2 dalam antrean. Statement kedua (`head.prev = null;`) berfungsi memutus tali koneksi dari *node* ke-2 (yang kini menjadi kepala) ke arah *node* ke-1 yang lama, sehingga *node* ke-1 yang lama benar-benar lepas dan bisa dihapus dari memori (oleh _Garbage Collector_).

<br>

2. Modifikasi method `removeFirst()` dan `removeLast()` agar program menampilkan data yang berhasil dihapus!
= *(Kedua method tersebut telah saya lengkapi dengan perintah `head.data.tampil()` dan `tail.data.tampil()` sebelum pointer diputus, agar sistem mencetak detail data mahasiswa yang dihapus).*
