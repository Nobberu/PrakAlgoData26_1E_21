import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class LoopCollection21 {

    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.push("Salak");

        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }
        System.out.println("\n" + fruits.toString());

        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }

        System.out.println("\n");
        // Mengisi kembali stack yang sudah kosong karena di-pop
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.push("Salak");

        fruits.push("Melon");
        fruits.push("Durian");

        System.out.println("");
        for (Iterator<String> it = fruits.iterator(); it.hasNext(); ) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }
        System.out.println("");

        fruits.stream().forEach(e -> {
            System.out.printf("%s ", e);
        });
        System.out.println("");

        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));
        }
        System.out.println("");

        // Modifikasi untuk menjawab pertanyaan percobaan No 5 dan 6
        System.out.println("\n--- Hasil Modifikasi Pertanyaan ---");
        fruits.set(fruits.size() - 1, "Strawberry"); // Ganti elemen terakhir
        fruits.addAll(Arrays.asList("Mango", "Guava", "Avocado")); // Tambah 3 buah
        Collections.sort(fruits); // Sorting ascending
        System.out.println(
            "Isi fruits setelah ditambah & disorting: " + fruits.toString()
        );
    }
}
