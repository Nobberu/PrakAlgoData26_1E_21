import java.util.Scanner;

public class pemilihan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS, nilaiFinal;
        double persenTugas = 0.2,
            persenKuis = 0.2,
            persenUTS = 0.3,
            persenUAS = 0.4;
        String nilaiHuruf;

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("======================");
        System.out.printf("%-6s %s", "Masukkan Nilai Tugas", ": ");
        nilaiTugas = sc.nextDouble();
        System.out.printf("%-6s %s", "Masukkan Nilai Kuis", ": ");
        nilaiKuis = sc.nextDouble();
        System.out.printf("%-6s %s", "Masukkan Nilai UTS", ": ");
        nilaiUTS = sc.nextDouble();
        System.out.printf("%-6s %s", "Masukkan Nilai UAS:", ": ");
        nilaiUAS = sc.nextDouble();
        sc.close();

        if (
            nilaiTugas < 0 ||
            nilaiTugas > 100 ||
            nilaiKuis < 0 ||
            nilaiKuis > 100 ||
            nilaiUTS < 0 ||
            nilaiUTS > 100 ||
            nilaiUAS < 0 ||
            nilaiUAS > 100
        ) {
            System.out.println("======================");
            System.out.println("======================");
            System.out.println("Nilai tidak valid");
            System.out.println("======================");
            System.out.println("======================");
            System.exit(0);
        }

        nilaiFinal =
            (nilaiTugas * persenTugas) +
            (nilaiKuis * persenKuis) +
            (nilaiUTS * persenUTS) +
            (nilaiUAS * persenUAS);

        if (nilaiFinal > 80) {
            nilaiHuruf = "A";
        } else if (nilaiFinal > 73) {
            nilaiHuruf = "B+";
        } else if (nilaiFinal > 65) {
            nilaiHuruf = "B";
        } else if (nilaiFinal > 60) {
            nilaiHuruf = "C+";
        } else if (nilaiFinal > 50) {
            nilaiHuruf = "C";
        } else if (nilaiFinal > 39) {
            nilaiHuruf = "D";
        } else {
            nilaiHuruf = "E";
        }

        System.out.println("======================");
        System.out.println("======================");
        System.out.println("Nilai akhir: " + nilaiFinal);
        System.out.println("Nilai huruf: " + nilaiHuruf);
        System.out.println("======================");
        System.out.println("======================");
        if (nilaiHuruf == "D" || nilaiHuruf == "E") {
            System.out.println("ANDA TIDAK LULUS");
        } else {
            System.out.println("SELAMAT ANDA LULUS!");
        }
    }
}
