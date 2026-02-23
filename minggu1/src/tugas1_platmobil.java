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
