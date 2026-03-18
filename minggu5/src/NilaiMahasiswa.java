public class NilaiMahasiswa {

    public static int cariMaxUTS(Mahasiswa[] mhs, int low, int high) {
        if (low == high) {
            return mhs[low].nilaiUTS;
        }
        
        int mid = (low + high) / 2;
        int maxKiri = cariMaxUTS(mhs, low, mid);
        int maxKanan = cariMaxUTS(mhs, mid + 1, high);
        
        return Math.max(maxKiri, maxKanan);
    }

    public static int cariMinUTS(Mahasiswa[] mhs, int low, int high) {
        if (low == high) {
            return mhs[low].nilaiUTS;
        }
        
        int mid = (low + high) / 2;
        int minKiri = cariMinUTS(mhs, low, mid);
        int minKanan = cariMinUTS(mhs, mid + 1, high);
        
        return Math.min(minKiri, minKanan);
    }

    public static double hitungRataUAS(Mahasiswa[] mhs) {
        double total = 0;
        for (Mahasiswa m : mhs) {
            total += m.nilaiUAS;
        }
        return total / mhs.length;
    }
}