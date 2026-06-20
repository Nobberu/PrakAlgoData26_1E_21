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
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    // Jawaban Pertanyaan No 2: Binary Search
    int binarySearch(String nim) {
        Mahasiswa21 dummyMhs = new Mahasiswa21(nim, "", "");
        // Collection harus disorting terlebih dahulu sebelum binary search
        Collections.sort(mahasiswas);
        return Collections.binarySearch(mahasiswas, dummyMhs);
    }

    // Jawaban Pertanyaan No 3: Sorting Ascending/Descending
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

        // menambahkan objek mahasiswa
        lm.tambah(m, m1, m2);

        // menampilkan list mahasiswa
        lm.tampil();

        // update mahasiswa
        lm.update(
            lm.linearSearch("201235"),
            new Mahasiswa21("201235", "Akhleema Lela", "021xx2")
        );
        System.out.println("");
        lm.tampil();

        System.out.println("\n--- Uji Coba Sorting ---");
        lm.sortDescending();
        lm.tampil();
    }
}
