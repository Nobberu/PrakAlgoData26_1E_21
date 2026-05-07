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
