import java.util.Scanner;

public class MainFaktorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai: ");
        int nilai = input.nextInt();

        Faktorial21 fk = new Faktorial21();

        System.out.println(
            "Nilai faktorial " +
                nilai +
                " Menggunakan BF: " +
                fk.faktorialBF(nilai)
        );
        System.out.println(
            "Nilai faktorial " +
                nilai +
                " Menggunakan DC: " +
                fk.faktorialDC(nilai)
        );

        input.close();
    }
}
