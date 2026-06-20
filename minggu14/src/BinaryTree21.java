public class BinaryTree21 {

    Node21 root;

    public BinaryTree21() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Buku21 buku) {
        Node21 newNode = new Node21(buku);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node21 current = root;
            while (true) {
                Node21 parent = current;
                // pengurutan bst
                if (buku.tahunTerbit < current.buku.tahunTerbit) {
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

    // menghitung jumlah total buku
    public int hitungTotalBuku() {
        return hitungTotalBukuRekursif(root);
    }

    private int hitungTotalBukuRekursif(Node21 node) {
        if (node == null) {
            return 0;
        }
        return (
            1 +
            hitungTotalBukuRekursif(node.left) +
            hitungTotalBukuRekursif(node.right)
        );
    }

    // menampilkan buku range tahunAwal ke tahunAkhir (memakai  inorder traversal)
    public void tampilBukuRentangTahun(int tahunAwal, int tahunAkhir) {
        System.out.println(
            "\nBuku terbit diantara tahun " + tahunAwal + " - " + tahunAkhir
        );
        tampilBukuRentangTahunRekursif(root, tahunAwal, tahunAkhir);
    }

    private void tampilBukuRentangTahunRekursif(
        Node21 node,
        int tahunAwal,
        int tahunAkhir
    ) {
        if (node != null) {
            tampilBukuRentangTahunRekursif(node.left, tahunAwal, tahunAkhir);
            if (
                node.buku.tahunTerbit >= tahunAwal &&
                node.buku.tahunTerbit <= tahunAkhir
            ) {
                node.buku.tampilInformasi();
            }
            tampilBukuRentangTahunRekursif(node.right, tahunAwal, tahunAkhir);
        }
    }

    // menampilkan informasi buku dengan tahun terbit paling baru
    public void tampilBukuTerbaru() {
        if (isEmpty()) {
            System.out.println("node kosong.");
            return;
        }
        Node21 current = root;
        // langsung mengambil yang kanan karena tahun paling baru di bst pasti berada di ujung paling kanan.
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("\nBuku dengan Tahun Terbit Paling Baru");
        current.buku.tampilInformasi();
    }
}
