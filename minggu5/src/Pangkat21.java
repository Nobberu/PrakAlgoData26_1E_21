public class Pangkat21 {

    int nilai, pangkat;

    Pangkat21(int n, int p) {
        this.nilai = n;
        this.pangkat = p;
    }

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil = hasil * a;
        }

        return hasil;
    }

    int pangkatDC(int a, int n) {
        if (n == 1) {
            return a;
        } else {
            if ((n & 1) == 1) {
                return (pangkatDC(a, (n >> 1)) * pangkatDC(a, (n >> 1)) * a);
            } else {
                return (pangkatDC(a, (n >> 1)) * pangkatDC(a, (n >> 1)));
            }
        }
    }
}
