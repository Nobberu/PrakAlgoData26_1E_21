import java.util.Scanner;

class NodePembeli {

    Pembeli21 data;
    int noAntrian;
    NodePembeli prev, next;

    public NodePembeli(
        NodePembeli prev,
        Pembeli21 data,
        int noAntrian,
        NodePembeli next
    ) {
        this.prev = prev;
        this.data = data;
        this.noAntrian = noAntrian;
        this.next = next;
    }
}

class NodePesanan {

    Pesanan21 data;
    NodePesanan prev, next;

    public NodePesanan(NodePesanan prev, Pesanan21 data, NodePesanan next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

class DLLAntrian {

    NodePembeli head, tail;
    int counterUrutan = 1;

    public void tambahAntrian(Pembeli21 data) {
        if (head == null) {
            head = tail = new NodePembeli(null, data, counterUrutan, null);
        } else {
            NodePembeli newNode = new NodePembeli(
                tail,
                data,
                counterUrutan,
                null
            );
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(
            "Antrian berhasil ditambahkan dengan nomor: " + counterUrutan
        );
        counterUrutan++;
    }

    public void cetakAntrian() {
        if (head == null) {
            System.out.println("Antrian saat ini kosong.");
            return;
        }
        System.out.println("Daftar Antrian Pembeli");
        System.out.println(
            "=================================================="
        );
        System.out.printf(
            "%-12s | %-20s | %-15s\n",
            "No Antrian",
            "Nama",
            "No HP"
        );
        System.out.println(
            "--------------------------------------------------"
        );
        NodePembeli current = head;
        while (current != null) {
            System.out.printf(
                "%-12d | %-20s | %-15s\n",
                current.noAntrian,
                current.data.namaPembeli,
                current.data.noHp
            );
            current = current.next;
        }
        System.out.println(
            "=================================================="
        );
    }

    public Pembeli21 hapusAntrian() {
        if (head == null) return null;
        Pembeli21 p = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return p;
    }
}

class DLLPesanan {

    NodePesanan head, tail;

    public void tambahPesanan(Pesanan21 data) {
        if (head == null) {
            head = tail = new NodePesanan(null, data, null);
        } else {
            NodePesanan newNode = new NodePesanan(tail, data, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void sortPesananByName() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            NodePesanan current = head;
            while (current.next != null) {
                // Bubble sort mechanism on DLL data
                if (
                    current.data.namaPesanan.compareToIgnoreCase(
                        current.next.data.namaPesanan
                    ) > 0
                ) {
                    Pesanan21 temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void cetakPesanan() {
        if (head == null) {
            System.out.println("Belum ada data pesanan masuk.");
            return;
        }
        sortPesananByName(); // Sort data otomatis sebelum dicetak (Sesuai Aspek Penilaian 6)

        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println(
            "=================================================="
        );
        System.out.printf(
            "%-15s | %-20s | %-10s\n",
            "Kode Pesanan",
            "Nama Pesanan",
            "Harga"
        );
        System.out.println(
            "--------------------------------------------------"
        );
        NodePesanan current = head;
        int totalPendapatan = 0;
        while (current != null) {
            System.out.printf(
                "%-15d | %-20s | %-10d\n",
                current.data.kodePesanan,
                current.data.namaPesanan,
                current.data.harga
            );
            totalPendapatan += current.data.harga;
            current = current.next;
        }
        System.out.println(
            "=================================================="
        );
        System.out.println("TOTAL PENDAPATAN : Rp " + totalPendapatan);
    }
}

// Pembuatan node baru untuk rekap Quiz 2
class NodeRekap {

    Rekap21 data;
    NodeRekap prev, next;

    public NodeRekap(NodeRekap prev, Rekap21 data, NodeRekap next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

// Linked list baru untuk rekap Quiz 2
class LLRekap {

    NodeRekap head, tail;

    // ini belum work pak, saya sudah membuat function untuk tambah tapi ketika di run belum bisa menambah rekap setelah melakukan opsi ketiga 😭.
    public void tambahRekap(String namaPesanan) {
        NodeRekap current = head;

        while (current != null) {
            if (current.namaPesanan.equalsIgnoreCase(namaPesanan)) {
                current.jumlahPesanan++;
                return;
            }
            current = current.next;
        }

        NodeRekap newNode = new NodeRekap(tail, namaPesanan, 1, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void cetakRekap() {
        if (head == null) {
            System.out.println("Belum ada data rekap pesanan.");
            return;
        }

        System.out.println("REKAP PESANAN");
        System.out.println(
            "=================================================="
        );
        System.out.printf("%-20s | %-15s\n", "Nama Pesanan", "Jumlah");
        System.out.println(
            "--------------------------------------------------"
        );

        NodeRekap current = head;

        while (current != null) {
            System.out.printf(
                "%-20s | %-15d\n",
                current.namaPesanan,
                current.jumlahPesanan
            );

            current = current.next;
        }

        System.out.println(
            "=================================================="
        );
    }
}

public class SistemRoyalDelish21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLAntrian antrian = new DLLAntrian();
        DLLPesanan pesanan = new DLLPesanan();
        LLRekap rekap = new LLRekap();
        int menu;

        do {
            System.out.println("\n=================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("=================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Rekap Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();
                    antrian.tambahAntrian(new Pembeli21(nama, hp));
                    break;
                case 2:
                    antrian.cetakAntrian();
                    break;
                case 3:
                    Pembeli21 p = antrian.hapusAntrian();
                    if (p != null) {
                        System.out.println(
                            "Melayani Antrian: " + p.namaPembeli
                        );
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();

                        pesanan.tambahPesanan(
                            new Pesanan21(kode, namaPesanan, harga)
                        );
                        System.out.println(
                            p.namaPembeli + " telah memesan " + namaPesanan
                        );
                    } else {
                        System.out.println("Tidak ada antrian untuk dilayani.");
                    }
                    break;
                case 4:
                    pesanan.cetakPesanan();
                    break;
                case 5:
                    rekap.cetakRekap();
                    break;
                case 0:
                    System.out.println("Sistem ditutup. Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (menu != 0);
        sc.close();
    }
}
