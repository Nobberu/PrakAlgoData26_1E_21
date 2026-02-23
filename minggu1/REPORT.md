# REPORT

<br>

### Percobaan 2.1: Pemilihan

Kode Program:

```java
Java

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
```

Hasil dijalankan program:

```bash
Bash

Program Menghitung Nilai Akhir
======================
Masukkan Nilai Tugas : 90
Masukkan Nilai Kuis : 90
Masukkan Nilai UTS : 90
Masukkan Nilai UAS: : 90
======================
======================
Nilai akhir: 99.0
Nilai huruf: A
======================
======================
SELAMAT ANDA LULUS!
```

<br>

### Percobaan 2.2: Perulangan

Kode Program:

```java
Java

import java.util.Scanner;

public class perulangan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        sc.close();

        int length = nim.length();
        String last2Str = nim.substring(length - 2);
        int last2Int = Integer.parseInt(last2Str);

        if (last2Int < 10) {
            last2Int += 10;
        }

        for (int i = 1; i <= last2Int; i++) {
            if (i == 10 || i == 15) {
                continue;
            } else if (i % 3 == 0) {
                System.out.print("#");
            } else if (i % 2 == 1) {
                System.out.print("*");
            } else if (i % 2 == 0 && !(i % 3 == 0)) {
                System.out.print(i);
            } else {
                System.out.print(i);
            }
        }
    }
}
```

Hasil dijalankan program:

```bash
Bash

Masukkan NIM: 254107020098
*2#4*#*8#*#*1416*#*20#22*#*26#28*#*32#34*#*38#40*#*44#46*#*50#52*#*56#58*#*62#64*#*68#70*#*74#76*#*80#82*#*86#88*#*92#94*#*98
```

<br>

### Percobaan 2.3: Array

Kode Program:

```java
Java

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
```

Hasil dijalankan program:

```bash
Bash

====================
Hasil Konversi Nilai
====================
MK                                      Nilai Angka         Nilai Huruf         Bobot Nilai
Pancasila                               90.0                A                   4.0
Konsep Teknologi Informasi              80.0                B+                  3.5
Critical Thinking dan Problem Solving   70.0                B                   3.0
Matematika Dasar                        60.0                C                   2.0
Bahasa Inggris                          50.0                D                   1.0
Dasar Pemrograman                       40.0                D                   1.0
Praktikum Dasar Pemrograman             30.0                E                   0.0
Keselamatan dan Kesehatan Kerja         20.0                E                   0.0
====================
IP: 1.8125
```

<br>

### Percobaan 2.4: Fungsi

Kode Program:

```java
Java

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

```

Hasil dijalankan program:

```bash
Bash

DATA STOK BUNGA:
=======================================================================
|                 | Aglonema   | Keladi     | Alocasta   | Mawar      |
-----------------------------------------------------------------------
| RoyalGarden 1   | 10         | 5          | 15         | 7          |
| RoyalGarden 2   | 6          | 11         | 9          | 12         |
| RoyalGarden 3   | 2          | 10         | 10         | 5          |
| RoyalGarden 4   | 5          | 7          | 12         | 9          |
=======================================================================

LAPORAN PENDAPATAN PER CABANG:
======================================================
|                 | Pendapatan     | Status          |
======================================================
| RoyalGarden 1   | Rp   1,725,000 | Sangat Baik     |
| RoyalGarden 2   | Rp   1,650,000 | Sangat Baik     |
| RoyalGarden 3   | Rp   2,760,000 | Sangat Baik     |
| RoyalGarden 4   | Rp     330,000 | Perlu Evaluasi  |
======================================================
```

<br>

### Tugas 1: Plat Mobil

Kode Program:

```java
Java

import java.util.Scanner;

public class tugas1_platmobil {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char kode[] = { 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T' };
        char kota[][] = {
            { 'B', 'A', 'N', 'T', 'E', 'N' },
            { 'J', 'A', 'K', 'A', 'R', 'T', 'A' },
            { 'B', 'A', 'N', 'D', 'U', 'N', 'G' },
            { 'C', 'I', 'R', 'E', 'B', 'O', 'N' },
            { 'B', 'O', 'G', 'O', 'R' },
            { 'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N' },
            { 'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G' },
            { 'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A' },
            { 'M', 'A', 'L', 'A', 'N', 'G' },
            { 'T', 'E', 'G', 'A', 'L' },
        };

        System.out.print("Masukkan kode plat: ");
        char input = sc.next().toUpperCase().charAt(0);

        int indexSearch = Search(kode, input);

        if (indexSearch == -1) {
            System.out.println("Kode plat tidak ditemukan.");
        } else {
            System.out.print("Kota: ");
            for (char c : kota[indexSearch]) {
                System.out.print(c);
            }
            System.out.println();
        }
        sc.close();
    }

    private static int Search(char[] arr, char x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}

```

Hasil dijalankan program:

```bash
Bash

Masukkan kode plat: N
Kota: MALANG
```

<br>

### Tugas 2: Jadwal Kuliah

Kode Program:

```java
Java

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

```

Hasil dijalankan program:

```bash
Bash

Masukkan jumlah jadwal yang akan dibuat: 2

Input jadwal ke-1
Nama mata kuliah: PrakASD
Ruang           : LPY3
Hari            : Jum'at
Jam             : berapa?
Tolong input jam hanya dengan digit!

Input jadwal ke-1
Nama mata kuliah: PrakASD
Ruang           : LPY3
Hari            : Jum'at
Jam             : 6

Input jadwal ke-2
Nama mata kuliah: ASD
Ruang           : LPY3
Hari            : Rabu
Jam             : 10

===============================================================
| Mata Kuliah          | Ruang      | Hari       | Jam        |
===============================================================
| PrakASD              | LPY3       | Jum'at     | 6          |
| ASD                  | LPY3       | Rabu       | 10         |
===============================================================

Cari jadwal berdasarkan hari: Rabu

Jadwal pada hari Rabu:
ASD (Ruang LPY3), Jam: 10

Cari jadwal berdasarkan nama mata kuliah: ASD

Detail mata kuliah ASD:
Ruang: LPY3
Hari: Rabu
Jam: 10
```
