public class BinaryTreeMain21 {
    public static void main(String[] args) {
        BinaryTree21 bst = new BinaryTree21();

        bst.add(new Buku21("B001", "Buku A", "Penulis A", 2015));
        bst.add(new Buku21("B002", "Buku B", "Penulis B", 2011));
        bst.add(new Buku21("B003", "Buku C", "Penulis C", 2020));
        bst.add(new Buku21("B004", "Buku D", "Penulis D", 2008));
        bst.add(new Buku21("B005", "Buku E", "Penulis E", 2022));
        bst.add(new Buku21("B005", "Buku F", "Penulis F", 2022));

        // Menghitung total buku
        int total = bst.hitungTotalBuku();
        System.out.println("Jumlah total buku di perpustakaan: " + total);

        // Menampilkan range diantara tahunAwal dan tahunAkhir
        bst.tampilBukuRentangTahun(2010, 2019);

        // Menampilkan buku paling baru
        bst.tampilBukuTerbaru();
    }
}