import java.util.Scanner;

public class tugas2_jadwal {

    // Lazy fix to java scanner bug (hehe)
    static Scanner scInt = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah jadwal yang akan dibuat: ");
        int jml = scInt.nextInt();

        String[][] jadwal = new String[jml][4];

        Input(jadwal);
        TampilkanSemua(jadwal);

        System.out.print("\nCari jadwal berdasarkan hari: ");
        String cariHari = scString.nextLine();
        BerdasarHari(jadwal, cariHari);

        System.out.print("\nCari jadwal berdasarkan nama mata kuliah: ");
        String cariMK = scString.nextLine();
        BerdasarMK(jadwal, cariMK);
    }

    static void Input(String[][] jadwal) {
        for (int i = 0; i < jadwal.length; i++) {
            System.out.println("\nInput jadwal ke-" + (i + 1));
            System.out.print("Nama mata kuliah: ");
            jadwal[i][0] = scString.nextLine();

            System.out.print("Ruang           : ");
            jadwal[i][1] = scString.nextLine();

            System.out.print("Hari            : ");
            jadwal[i][2] = scString.nextLine();

            System.out.print("Jam             : ");
            jadwal[i][3] = scString.nextLine();

            // Quick "Hari" regex checking if user inputs a number instead of day name (just a random thought)
            boolean isNomor = jadwal[i][2].matches(".*\\d.*");

            // Another regex checking for "Jam" if the user inputs letter or symbol mistakenly
            boolean onlyNomor = jadwal[i][3].matches(".*\\D.*");

            // Well ofcourse, the check
            if (isNomor) {
                System.out.println("Tolong input hari hanya dengan nama hari!");
                i--;
                continue;
            } else if (onlyNomor) {
                System.out.println("Tolong input jam hanya dengan digit!");
                i--;
                continue;
            }
        }
    }

    static void TampilkanSemua(String[][] jadwal) {
        System.out.println(
            "\n==============================================================="
        );
        System.out.printf(
            "| %-20s | %-10s | %-10s | %-10s |\n",
            "Mata Kuliah",
            "Ruang",
            "Hari",
            "Jam"
        );
        System.out.println(
            "==============================================================="
        );
        for (String[] baris : jadwal) {
            System.out.printf(
                "| %-20s | %-10s | %-10s | %-10s |\n",
                baris[0],
                baris[1],
                baris[2],
                baris[3]
            );
        }
        System.out.println(
            "==============================================================="
        );
    }

    static void BerdasarHari(String[][] jadwal, String hari) {
        System.out.println("\nJadwal pada hari " + hari + ":");
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][2].equalsIgnoreCase(hari)) {
                System.out.printf(
                    "%s (Ruang %s), Jam: %s\n",
                    jadwal[i][0],
                    jadwal[i][1],
                    jadwal[i][3]
                );
            }
        }
    }

    static void BerdasarMK(String[][] jadwal, String mk) {
        System.out.println("\nDetail mata kuliah " + mk + ":");
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][0].equalsIgnoreCase(mk)) {
                System.out.println(
                    "Ruang: " +
                        jadwal[i][1] +
                        "\nHari: " +
                        jadwal[i][2] +
                        "\nJam: " +
                        jadwal[i][3]
                );
            }
        }
    }
}
