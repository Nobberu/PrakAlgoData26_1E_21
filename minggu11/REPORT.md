# Report

## Jobsheet XI - Linked List

### 2.1 & 2.2 Praktikum: Single Linked List Dasar dan Modifikasi

Kode program:

```java
// MahasiswaLL21.java
public class MahasiswaLL21 {
    String nim, nama, kelas;
    double ipk;

    public MahasiswaLL21() {}

    public MahasiswaLL21(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi() {
        System.out.println(nama);
        System.out.println(nim);
        System.out.println(kelas);
        System.out.println(ipk);
    }
}
```

```java
// NodeMahasiswa21.java
public class NodeMahasiswa21 {
    MahasiswaLL21 data;
    NodeMahasiswa21 next;

    public NodeMahasiswa21(MahasiswaLL21 data, NodeMahasiswa21 next) {
        this.data = data;
        this.next = next;
    }
}
```

```java
// SingleLinkedList21.java
public class SingleLinkedList21 {
    NodeMahasiswa21 head, tail;

    boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (!isEmpty()) {
            NodeMahasiswa21 tmp = head;
            System.out.println("Isi Linked List:");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked list kosong");
        }
    }

    public void addFirst(MahasiswaLL21 input) {
        NodeMahasiswa21 ndInput = new NodeMahasiswa21(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(MahasiswaLL21 input) {
        NodeMahasiswa21 ndInput = new NodeMahasiswa21(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(String key, MahasiswaLL21 input) {
        NodeMahasiswa21 ndInput = new NodeMahasiswa21(input, null);
        NodeMahasiswa21 temp = head;
        do {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, MahasiswaLL21 input) {
        if (index < 0) {
            System.out.println("indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            NodeMahasiswa21 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new NodeMahasiswa21(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }

    public void getData(int index) {
        NodeMahasiswa21 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data.tampilInformasi();
    }

    public int indexOf(String key) {
        NodeMahasiswa21 tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)) {
            tmp = tmp.next;
            index++;
        }
        if (tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            NodeMahasiswa21 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void remove(String key) {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else {
            NodeMahasiswa21 temp = head;
            while (temp != null) {
                if ((temp.data.nama.equalsIgnoreCase(key)) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.next != null && temp.next.data.nama.equalsIgnoreCase(key)) { 
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            NodeMahasiswa21 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
}
```

```java
// SLLMain21.java
import java.util.Scanner;

public class SLLMain21 {
    public static void main(String[] args) {
        SingleLinkedList21 sll = new SingleLinkedList21();
        
        MahasiswaLL21 mhs1 = new MahasiswaLL21("21212203", "Dirga", "4O", 3.6);
        MahasiswaLL21 mhs2 = new MahasiswaLL21("22212202", "Cintia", "3C", 3.5);
        MahasiswaLL21 mhs3 = new MahasiswaLL21("23212201", "Bimon", "2B", 3.8);
        MahasiswaLL21 mhs4 = new MahasiswaLL21("24212200", "Alvaro", "1A", 4.0);
        
        sll.print();
        sll.addFirst(mhs1);
        sll.print();
        sll.addLast(mhs4);
        sll.print();
        sll.insertAfter("Dirga", mhs3);
        sll.insertAt(1, mhs2); 
        sll.print();

        System.out.println("data index 1: ");
        sll.getData(1);
        System.out.println("data mahasiswa an Bimon berada pada index: " + sll.indexOf("bimon"));
        System.out.println();
        
        sll.removeFirst();
        sll.removeLast();
        sll.print();
        sll.removeAt(0);
        sll.print();

        // Modifikasi Input via Keyboard
        Scanner sc = new Scanner(System.in);
        System.out.println("== INPUT MAHASISWA BARU ==");
        System.out.print("NIM  : "); String nim = sc.nextLine();
        System.out.print("Nama : "); String nama = sc.nextLine();
        System.out.print("Kelas: "); String kelas = sc.nextLine();
        System.out.print("IPK  : "); double ipk = sc.nextDouble();
        
        MahasiswaLL21 mhsKeyboard = new MahasiswaLL21(nim, nama, kelas, ipk);
        sll.addLast(mhsKeyboard);
        System.out.println("Setelah data keyboard ditambahkan:");
        sll.print();
        sc.close();
    }
}
```

Output Praktikum 1 & 2 (Linked List):

```bash
Linked list kosong
Isi Linked List:
Dirga
21212203
4O
3.6

Isi Linked List:
Dirga
21212203
4O
3.6
Alvaro
24212200
1A
4.0

Isi Linked List:
Dirga
21212203
4O
3.6
Cintia
22212202
3C
3.5
Bimon
23212201
2B
3.8
Alvaro
24212200
1A
4.0

data index 1: 
Cintia
22212202
3C
3.5
data mahasiswa an Bimon berada pada index: 2

Isi Linked List:
Cintia
22212202
3C
3.5
Bimon
23212201
2B
3.8

Isi Linked List:
Bimon
23212201
2B
3.8

== INPUT MAHASISWA BARU ==
NIM  : 112233
Nama : Zaky
Kelas: 1E
IPK  : 3.9
Setelah data keyboard ditambahkan:
Isi Linked List:
Bimon
23212201
2B
3.8
Zaky
112233
1E
3.9
```

#### Pertanyaan Praktikum (2.1 & 2.2)

1. Mengapa hasil compile kode program di baris pertama menghasilkan "Linked List Kosong"?
= Karena fungsi pemanggilan `sll.print()` dieksekusi tepat setelah objek list diinstansiasi dan sebelum method `addFirst` atau `addLast` dipanggil. Pada kondisi awal tersebut, nilai indikator `head` masih `null`, sehingga kondisi `!isEmpty()` gagal dan mencetak blok *else* "Linked list kosong".

<br>

2. Jelaskan kegunaan variable `temp` secara umum pada setiap method!
= Variabel `temp` berfungsi sebagai penunjuk sementara (*pointer*) untuk melakukan *traverse* atau menelusuri elemen-elemen Linked List dari depan ke belakang. Kita menggunakan `temp` agar referensi asli letak `head` tidak ikut bergeser atau hilang saat kita berpindah-pindah membaca antar *node*.

<br>

3. Lakukan modifikasi agar data dapat ditambahkan dari keyboard!
= Kode Scanner pada Java Main (`SLLMain21.java`) untuk meminta input *keyboard* dari *user* dan menyimpannya menggunakan method `addLast` sudah dilampirkan pada kode sumber di atas.

<br>

4. Mengapa digunakan keyword `break` pada fungsi `remove`? Jelaskan!
= Keyword `break` digunakan untuk menghentikan iterasi pencarian dan perulangan `while` secara langsung. Setelah data (*node*) dengan `key` yang dicari ditemukan dan direlasikan ulang (dihapus logikanya), kita tidak perlu lagi mengecek *node* sisa di belakangnya. Ini membuat algoritma menjadi jauh lebih efisien.

<br>

5. Jelaskan kegunaan kode dibawah pada method `remove`!
```java
temp.next = temp.next.next;
if (temp.next == null) {
    tail = temp;
}
```
= Baris pertama memutuskan koneksi dan mem-*bypass* *node* target dengan menunjuk referensi panah (pointer `next`) langsung melompati *node* target menuju *node* sesudahnya. 
Baris `if` berikutnya mengecek apakah node yang baru saja dituju tersebut adalah ujung akhir/kosong (`null`). Jika iya, itu berarti node yang kita hapus sebelumnya berstatus sebagai ekor (Tail), sehingga kita harus memperbarui status objek `tail` bergeser ke *node* pembacaan saat ini (`temp`).

<br>

### Tugas Jobsheet XI

Kode program Tugas Linked List Queue:

```java
// TugasLLQueue21.java
import java.util.Scanner;

class MhsLayanan21 {
    String nim, nama;
    MhsLayanan21 next;

    public MhsLayanan21(String nim, String nama, MhsLayanan21 next) {
        this.nim = nim;
        this.nama = nama;
        this.next = next;
    }
    public void printInfo() {
        System.out.println("NIM: " + nim + " | Nama: " + nama);
    }
}

class QueueLayananLL {
    MhsLayanan21 head, tail;
    int size = 0;

    public boolean isEmpty() { return head == null; }
    
    public void enqueue(String nim, String nama) {
        MhsLayanan21 newNode = new MhsLayanan21(nim, nama, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println(nama + " berhasil ditambahkan ke antrian.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.print("Memanggil mahasiswa: ");
            head.printInfo();
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
        }
    }

    public void printSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!"); return;
        }
        MhsLayanan21 tmp = head;
        int i = 1;
        while (tmp != null) {
            System.out.print(i + ". "); tmp.printInfo();
            tmp = tmp.next; i++;
        }
    }

    public void printTerdepanBelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!"); return;
        }
        System.out.print("Paling Depan    : "); head.printInfo();
        System.out.print("Paling Belakang : "); tail.printInfo();
    }
    
    public void clear() {
        head = tail = null; size = 0;
        System.out.println("Antrian dikosongkan.");
    }
}

public class TugasLLQueue21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLayananLL q = new QueueLayananLL();
        int pilih;
        do {
            System.out.println("\n=== Layanan Kemahasiswaan (Linked List) ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Panggil Antrian (Layanan)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Cek Paling Depan & Belakang");
            System.out.println("5. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM: "); String nim = sc.nextLine();
                    System.out.print("Nama: "); String nama = sc.nextLine();
                    q.enqueue(nim, nama);
                    break;
                case 2: q.dequeue(); break;
                case 3: q.printSemua(); break;
                case 4: q.printTerdepanBelakang(); break;
                case 5: q.clear(); break;
            }
            if (pilih != 0) {
                System.out.println("Jumlah mahasiswa mengantre: " + q.size);
            }
        } while (pilih != 0);
        sc.close();
    }
}
```

Output Tugas Linked List:

```bash
=== Layanan Kemahasiswaan (Linked List) ===
1. Tambah Antrian
2. Panggil Antrian (Layanan)
...
Pilih: 1
NIM: 1234
Nama: Sarah
Sarah berhasil ditambahkan ke antrian.
Jumlah mahasiswa mengantre: 1

=== Layanan Kemahasiswaan (Linked List) ===
...
Pilih: 1
NIM: 5678
Nama: Jojo
Jojo berhasil ditambahkan ke antrian.
Jumlah mahasiswa mengantre: 2

=== Layanan Kemahasiswaan (Linked List) ===
...
Pilih: 4
Paling Depan    : NIM: 1234 | Nama: Sarah
Paling Belakang : NIM: 5678 | Nama: Jojo
Jumlah mahasiswa mengantre: 2

=== Layanan Kemahasiswaan (Linked List) ===
...
Pilih: 2
Memanggil mahasiswa: NIM: 1234 | Nama: Sarah
Jumlah mahasiswa mengantre: 1

=== Layanan Kemahasiswaan (Linked List) ===
...
Pilih: 3
1. NIM: 5678 | Nama: Jojo
Jumlah mahasiswa mengantre: 1
```
