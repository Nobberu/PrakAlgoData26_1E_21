import java.util.Scanner;

public class array {

    static String MK[] = {
        "Pancasila",
        "Konsep Teknologi Informasi",
        "Critical Thinking dan Problem Solving",
        "Matematika Dasar",
        "Bahasa Inggris",
        "Dasar Pemrograman",
        "Praktikum Dasar Pemrograman",
        "Keselamatan dan Kesehatan Kerja",
    };

    static Double nilaiAngka[] = new Double[MK.length];
    static String nilaiHuruf[] = new String[MK.length];
    static Double bobotNilai[] = new Double[MK.length];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double totalBobot = 0.0,
            ip = 0.0;

        System.out.println("==============================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("==============================");
        for (int i = 0; i <= (MK.length - 1); i++) {
            System.out.print("Masukkan nilai angka untuk MK " + MK[i] + ": ");
            nilaiAngka[i] = sc.nextDouble();

            // Limiter
            if (nilaiAngka[i] < 0 || nilaiAngka[i] > 100) {
                System.out.println("Inputkan hanya nilai 0 - 100.");
                i--;
                continue;
            }

            if (nilaiAngka[i] > 80 && nilaiAngka[i] <= 100) {
                nilaiHuruf[i] = "A";
                bobotNilai[i] = 4.0;
            } else if (nilaiAngka[i] > 73 && nilaiAngka[i] <= 80) {
                nilaiHuruf[i] = "B+";
                bobotNilai[i] = 3.5;
            } else if (nilaiAngka[i] > 65 && nilaiAngka[i] <= 73) {
                nilaiHuruf[i] = "B";
                bobotNilai[i] = 3.0;
            } else if (nilaiAngka[i] > 60 && nilaiAngka[i] <= 65) {
                nilaiHuruf[i] = "C+";
                bobotNilai[i] = 2.5;
            } else if (nilaiAngka[i] > 50 && nilaiAngka[i] <= 60) {
                nilaiHuruf[i] = "C";
                bobotNilai[i] = 2.0;
            } else if (nilaiAngka[i] > 39 && nilaiAngka[i] <= 50) {
                nilaiHuruf[i] = "D";
                bobotNilai[i] = 1.0;
            } else if (nilaiAngka[i] <= 39) {
                nilaiHuruf[i] = "E";
                bobotNilai[i] = 0.0;
            }
            totalBobot += bobotNilai[i];
        }
        sc.close();

        ip = totalBobot / MK.length;

        System.out.println("====================");
        System.out.println("Hasil Konversi Nilai");
        System.out.println("====================");
        System.out.printf(
            "%-40s %-20s %-20s %s \n",
            "MK",
            "Nilai Angka",
            "Nilai Huruf",
            "Bobot Nilai"
        );
        for (int i = 0; i <= (MK.length - 1); i++) {
            System.out.printf(
                "%-40s %-20s %-20s %s \n",
                MK[i],
                nilaiAngka[i],
                nilaiHuruf[i],
                bobotNilai[i]
            );
        }
        System.out.println("====================");
        System.out.println("IP: " + ip);
    }
}
