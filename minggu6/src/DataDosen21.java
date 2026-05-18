public class DataDosen21 {
    Dosen21[] dataDosen = new Dosen21[10];
    int idx = 0;

    public void tambah(Dosen21 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
            System.out.println("Data Dosen berhasil ditambahkan!");
        } else {
            System.out.println("Kapasitas data Dosen penuh!");
        }
    }

    public void tampil() {
        if (idx == 0) {
            System.out.println("Data Dosen kosong.");
            return;
        }
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
        }
    }

    // Menggunakan Bubble Sort (ASC)
    public void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (dataDosen[j - 1].usia > dataDosen[j].usia) {
                    Dosen21 temp = dataDosen[j];
                    dataDosen[j] = dataDosen[j - 1];
                    dataDosen[j - 1] = temp;
                }
            }
        }
        System.out.println("Data berhasil diurutkan berdasarkan Usia (Termuda - Tertua).");
    }

    // Menggunakan Selection Sort (DESC)
    public void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int max = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[max].usia) {
                    max = j;
                }
            }
            Dosen21 temp = dataDosen[i];
            dataDosen[i] = dataDosen[max];
            dataDosen[max] = temp;
        }
        System.out.println("Data berhasil diurutkan berdasarkan Usia (Tertua - Termuda).");
    }
}