# REPORT

<br>

## Jobsheet XIV - Tree

### Percobaan 1 & 2: Binary Search Tree (Linked List) & Binary Tree (Array)

Kode program:
```java
// Mahasiswa21.java
public class Mahasiswa21 {
    String nim, nama, kelas;
    double ipk;

    public Mahasiswa21() {
    }

    public Mahasiswa21(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi() {
        System.out.println("NIM: " + this.nim + " " +
                           "Nama: " + this.nama + " " +
                           "Kelas: " + this.kelas + " " +
                           "IPK: " + this.ipk);
    }
}
```

```java
// Node21.java
public class Node21 {
    Mahasiswa21 mahasiswa;
    Node21 left, right;

    public Node21() {
    }

    public Node21(Mahasiswa21 mahasiswa) {
        this.mahasiswa = mahasiswa;
        this.left = null;
        this.right = null;
    }
}
```

```java
// BinaryTree21.java
public class BinaryTree21 {
    Node21 root;

    public BinaryTree21() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa21 mahasiswa) {
        Node21 newNode = new Node21(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node21 current = root;
            while (true) {
                Node21 parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(double ipk) {
        boolean result = false;
        Node21 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    public void traversePreOrder(Node21 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node21 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node21 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    public Node21 getSuccessor(Node21 del) {
        Node21 successor = del.right;
        Node21 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }

        Node21 parent = root;
        Node21 current = root;
        boolean isLeftChild = false;

        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } 
            else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } 
            else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } 
            else {
                Node21 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
        }
    }
}
```

```java
// BinaryTreeMain21.java
public class BinaryTreeMain21 {
    public static void main(String[] args) {
        BinaryTree21 bst = new BinaryTree21();

        bst.add(new Mahasiswa21("244160121", "Ali", "A", 3.57));
        bst.add(new Mahasiswa21("244160221", "Badar", "B", 3.85));
        bst.add(new Mahasiswa21("244160185", "Candra", "C", 3.21));
        bst.add(new Mahasiswa21("244160220", "Dewi", "B", 3.54));

        System.out.println("\nDaftar semua mahasiswa (in order traversal):");
        bst.traverseInOrder(bst.root);

        System.out.println("\nPencarian data mahasiswa:");
        System.out.print("Cari mahasiswa dengan ipk: 3.54: ");
        String hasilCari = bst.find(3.54) ? "Ditemukan" : "Tidak ditemukan";
        System.out.println(hasilCari);

        System.out.print("Cari mahasiswa dengan ipk: 3.22: ");
        hasilCari = bst.find(3.22) ? "Ditemukan" : "Tidak ditemukan";
        System.out.println(hasilCari);

        bst.add(new Mahasiswa21("244160131", "Devi", "A", 3.72));
        bst.add(new Mahasiswa21("244160205", "Ehsan", "D", 3.37));
        bst.add(new Mahasiswa21("244160170", "Fizi", "B", 3.46));

        System.out.println("\nDaftar semua mahasiswa setelah penambahan 3 mahasiswa:");
        System.out.println("InOrder Traversal:");
        bst.traverseInOrder(bst.root);

        System.out.println("\nPreOrder Traversal:");
        bst.traversePreOrder(bst.root);

        System.out.println("\nPostOrder Traversal:");
        bst.traversePostOrder(bst.root);

        System.out.println("\nPenghapusan data mahasiswa");
        bst.delete(3.57);

        System.out.println("\nDaftar semua mahasiswa setelah penghapusan 1 mahasiswa (in order traversal):");
        bst.traverseInOrder(bst.root);
    }
}
```

```java
// BinaryTreeArray21.java
public class BinaryTreeArray21 {
    Mahasiswa21[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray21() {
        this.dataMahasiswa = new Mahasiswa21[10];
    }

    void populateData(Mahasiswa21 dataMhs[], int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
}
```

```java
// BinaryTreeArrayMain21.java
public class BinaryTreeArrayMain21 {
    public static void main(String[] args) {
        BinaryTreeArray21 bta = new BinaryTreeArray21();
        Mahasiswa21 mhs1 = new Mahasiswa21("244160121", "Ali", "A", 3.57);
        Mahasiswa21 mhs2 = new Mahasiswa21("244160185", "Candra", "C", 3.41);
        Mahasiswa21 mhs3 = new Mahasiswa21("244160221", "Badar", "B", 3.75);
        Mahasiswa21 mhs4 = new Mahasiswa21("244160220", "Dewi", "B", 3.35);
        Mahasiswa21 mhs5 = new Mahasiswa21("244160131", "Devi", "A", 3.48);
        Mahasiswa21 mhs6 = new Mahasiswa21("244160205", "Ehsan", "D", 3.61);
        Mahasiswa21 mhs7 = new Mahasiswa21("244160170", "Fizi", "B", 3.86);

        Mahasiswa21[] dataMahasiswas = {mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7, null, null, null};
        int idxLast = 6;

        bta.populateData(dataMahasiswas, idxLast);
        System.out.println("\nInorder Traversal Mahasiswa: ");
        bta.traverseInOrder(0);
    }
}
```

#### Pertanyaan 14.2.3 (Percobaan 1)

1. Mengapa dalam binary search tree proses pencarian data bisa lebih efektif dilakukan dibanding binary tree biasa?
= Karena Binary Search Tree (BST) memiliki aturan penempatan data yang terurut teratur, di mana node sebelah kiri selalu lebih kecil dari root dan node sebelah kanan selalu lebih besar. Aturan ini memotong setengah jalur pencarian pada setiap tahap penelusuran (mirip konsep binary search), memberikan efisiensi waktu rata-rata O(log n) dibandingkan pohon biner biasa yang harus menelusuri seluruh node (O(n)).

<br>

2. Untuk apakah di class Node, kegunaan dari atribut left dan right?
= Atribut `left` digunakan untuk menyimpan referensi/alamat menuju anak cabang sebelah kiri (left child) yang memiliki nilai data lebih kecil. Atribut `right` digunakan untuk menyimpan referensi/alamat menuju anak cabang sebelah kanan (right child) yang memiliki nilai data lebih besar.

<br>

3. a. Untuk apakah kegunaan dari atribut root di dalam class BinaryTree?
= Sebagai pointer utama atau penunjuk jalan utama menuju gerbang node teratas dari seluruh struktur pohon biner, sehingga program bisa menelusuri elemen-elemen lainnya di dalam pohon tersebut.

<br>

b. Ketika objek tree pertama kali dibuat, apakah nilai dari root?
= Nilai awal dari atribut `root` adalah `null`, yang mengindikasikan bahwa struktur pohon masih kosong.

<br>

4. Ketika tree masih kosong, dan akan ditambahkan sebuah node baru, proses apa yang akan terjadi?
= Program akan melakukan evaluasi melalui kondisi `isEmpty()`. Ketika terbukti benar-benar kosong, node baru yang dibuat akan langsung ditunjuk dan ditetapkan sebagai node `root` utama.

<br>

5. Perhatikan method add(), di dalamnya terdapat baris program seperti di bawah ini. Jelaskan secara detil untuk apa baris program tersebut?
```java
parent = current;
if (mahasiswa.ipk < current.mahasiswa.ipk) {
    current = current.left;
    if (current == null) {
        parent.left = newNode;
        return;
    }
}
```
= Potongan kode tersebut berfungsi melacak posisi tempat kosong yang tepat untuk disisipi data baru secara iteratif. Atribut `parent` mencatat objek node saat ini sebelum pointer `current` bergerak turun ke anak kiri (`current.left`) karena IPK data baru lebih kecil. Ketika `current` mendeteksi posisi kosong (`null`), program akan memasang objek data baru tersebut sebagai anak kiri dari `parent` menggunakan perintah `parent.left = newNode;` lalu menghentikan perulangan.

<br>

6. Jelaskan langkah-langkah pada method delete() saat menghapus sebuah node yang memiliki dua anak. Bagaimana method getSuccessor() membantu dalam proses ini?
= Langkah pertamanya adalah mencari node pengganti (*successor*) agar struktur urutan pohon tetap terjaga setelah penghapusan. Method `getSuccessor()` membantu proses ini dengan mencari node yang memiliki nilai terkecil di dalam sub-pohon sebelah kanan milik node yang akan dihapus. Caranya dengan mengambil anak kanan dari node target, lalu menelusuri ke arah cabang kiri secara terus-menerus hingga ujung paling bawah. Setelah node terkecil tersebut ditemukan, posisinya akan dinaikkan untuk menggantikan posisi node yang dihapus, dan jalinan pointer lama ditata ulang kembali.

<br>

#### Pertanyaan 14.3.3 (Percobaan 2)

1. Apakah kegunaan dari atribut data dan idxLast yang ada di class BinaryTreeArray?
= Atribut `dataMahasiswa` (array) berfungsi sebagai wadah penyimpanan fisik yang menampung objek data mahasiswa sebagai perwakilan dari node-node pohon. Atribut `idxLast` berfungsi mencatat batas posisi indeks terakhir yang menyimpan data valid di dalam array tersebut.

<br>

2. Apakah kegunaan dari method populateData()?
= Method ini digunakan untuk menyalin atau mengonfigurasi sekumpulan array data mahasiswa dari luar sistem (seperti dari fungsi main) ke dalam properti internal kelas sekaligus menentukan nilai batas akhir `idxLast`.

<br>

3. Apakah kegunaan dari method traverselnOrder()?
= Digunakan untuk membaca dan mencetak seluruh data mahasiswa yang tersusun di dalam array dengan urutan penelusuran secara *In-Order* (Kiri, Root, Kanan) dengan memanfaatkan formula perhitungan indeks secara rekursif.

<br>

4. Jika suatu node binary tree disimpan dalam array indeks 2, maka di indeks berapakah posisi left child dan right child masing-masing?
= Berdasarkan formula pemetaan struktur pohon biner ke dalam indeks array:
- Posisi Left Child: 2 * idxStart + 1 = 2 * 2 + 1 = indeks 5
- Posisi Right Child: 2 * idxStart + 2 = 2 * 2 + 2 = indeks 6

<br>

5. Apa kegunaan statement int idxLast = 6 pada praktikum 2 percobaan nomor 4?
= Statement tersebut berfungsi menetapkan batasan operasional bagi fungsi rekursif bahwa data pohon biner yang tersedia dan valid untuk diolah di dalam elemen array hanya ada dari indeks ke-0 sampai dengan indeks ke-6 saja.

<br>

6. Mengapa indeks 2*idxStart+1 dan 2*idxStart+2 digunakan dalam pemanggilan rekursif, dan apa kaitannya dengan struktur pohon biner yang disusun dalam array?
= Rumus tersebut adalah implementasi rumus matematis dasar untuk memetakan hierarki hubungan induk-anak dari pohon biner lengkap (*complete binary tree*) ke dalam representasi linear berbasis array. Hubungan penunjuk pointer digantikan oleh perhitungan matematis tetap, di mana setiap elemen node pada indeks `i` akan selalu memiliki anak kiri di posisi indeks `2i+1` dan anak kanan di posisi indeks `2i+2`.