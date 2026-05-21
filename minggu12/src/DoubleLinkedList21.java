public class DoubleLinkedList21 {
    Node21 head, tail;
    int size;

    public DoubleLinkedList21() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa21 data) {
        if (isEmpty()) {
            head = tail = new Node21(null, data, null);
        } else {
            Node21 newNode = new Node21(null, data, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Mahasiswa21 data) {
        if (isEmpty()) {
            head = tail = new Node21(null, data, null);
        } else {
            Node21 newNode = new Node21(tail, data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, Mahasiswa21 data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks di luar batas!");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node21 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node21 newNode = new Node21(current.prev, data, current);
            newNode.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa21 data) {
        Node21 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }
        if (current == tail) {
            addLast(data);
        } else {
            Node21 newNode = new Node21(current, data, current.next);
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        System.out.println("Data yang dihapus:");
        head.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        System.out.println("Data yang dihapus:");
        tail.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Indeks tidak valid atau List kosong.");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node21 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println("Data yang dihapus:");
            current.data.tampil();
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void removeAfter(String keyNim) {
        Node21 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Node target tidak ditemukan atau tidak ada node setelahnya.");
            return;
        }
        System.out.println("Data yang dihapus:");
        current.next.data.tampil();
        if (current.next == tail) {
            tail = current;
            tail.next = null;
        } else {
            current.next = current.next.next;
            current.next.prev = current;
        }
        size--;
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
        } else {
            System.out.println("Data Pertama:");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
        } else {
            System.out.println("Data Terakhir:");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        Node21 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Data pada index " + index + ":");
        current.data.tampil();
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node21 current = head;
        while (current != null) {
            current.data.tampil();
            System.out.println("-------------------------");
            current = current.next;
        }
        System.out.println("Total data: " + size);
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node21 current = tail;
        System.out.println("Daftar Data (Terbalik):");
        while (current != null) {
            current.data.tampil();
            System.out.println("-------------------------");
            current = current.prev;
        }
    }
}