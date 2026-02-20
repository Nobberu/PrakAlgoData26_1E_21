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
