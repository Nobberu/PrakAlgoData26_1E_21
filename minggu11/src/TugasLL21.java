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

public class TugasLL21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLayananLL q = new QueueLayananLL();
        int pilih;
        do {
            System.out.println("\n=== Layanan Kemahasiswaan (LL) ===");
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