class fungsi {

    static int bunga[][] = {
        { 10, 5, 15, 7 },
        { 6, 11, 9, 12 },
        { 2, 10, 10, 5 },
        { 5, 7, 12, 9 },
    };

    static int harga[] = { 75_000, 50_000, 60_000, 10_000 };

    static String[] jenisBunga = { "Aglonema", "Keladi", "Alocasta", "Mawar" };

    public static void main(String[] args) {
        TabelStok();
        Hitung(bunga);
        Pendapatan();
    }

    static double[] incomePerBunga = new double[jenisBunga.length];
    static double[] incomePerCabang = new double[bunga[0].length];

    static void Hitung(int[][] arr) {
        for (int j = 0; j < arr[0].length; j++) {
            double totalIncomeCabang = 0;
            for (int i = 0; i < arr.length; i++) {
                totalIncomeCabang += (harga[j] * arr[i][j]);
            }
            incomePerCabang[j] = totalIncomeCabang;
        }

        for (int i = 0; i < arr.length; i++) {
            double totalIncomeBunga = 0;
            for (int j = 0; j < arr[i].length; j++) {
                totalIncomeBunga += (harga[j] * arr[i][j]);
            }
            incomePerBunga[i] = totalIncomeBunga;
        }
    }

    static void Pendapatan() {
        System.out.println("\nLAPORAN PENDAPATAN PER CABANG:");
        System.out.println(
            "======================================================"
        );
        System.out.printf(
            "| %-15s | %-14s | %-15s |\n",
            "",
            "Pendapatan",
            "Status"
        );
        System.out.println(   
            "======================================================"
        );

        for (int i = 0; i < incomePerCabang.length; i++) {
            String status = (incomePerCabang[i] > 1_500_000)
                ? "Sangat Baik"
                : "Perlu Evaluasi";

            System.out.printf(
                "| RoyalGarden %-3d | Rp%,12.0f | %-15s |\n",
                i + 1,
                incomePerCabang[i],
                status
            );
        }
        System.out.println(
            "======================================================"
        );
    }

    static void TabelStok() {
        System.out.println("\nDATA STOK BUNGA:");
        System.out.println(
            "======================================================================="
        );
        System.out.printf(
            "| %-15s | %-10s | %-10s | %-10s | %-10s |\n",
            "",
            jenisBunga[0],
            jenisBunga[1],
            jenisBunga[2],
            jenisBunga[3]
        );
        System.out.println(
            "-----------------------------------------------------------------------"
        );

        for (int i = 0; i < bunga.length; i++) {
            System.out.printf("| %-15s |", "RoyalGarden " + (i + 1)); // i + 1 agar mulai dari 1
            for (int j = 0; j < bunga[i].length; j++) {
                System.out.printf(" %-10d |", bunga[i][j]);
            }
            System.out.println();
        }
        System.out.println(
            "======================================================================="
        );
    }
}
