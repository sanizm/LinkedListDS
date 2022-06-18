public class LinkedList<E> {

    private Node Head;
    private int size;
    private Node Tail;

    public LinkedList() {
        this.Head = null;
        this.size = 0;
        this.Tail = null;
    }

    private class Node {
        private E data;
        private Node next;
    }

    public void add(E data) {
        if (this.Head == null) {
            this.Head = new Node();
            this.Head.data = data;
            this.Tail = this.Head;
            this.Head.next = this.Tail;

        } else {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = null;
            this.Tail.next = newNode;
            this.Tail = newNode;
            size++;
        }
    }

    public boolean remove(E data) {

        Node current = this.Head;

        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                this.size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        Node prev = null;
        Node current = this.Head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.Head = prev;
    }

    public int size() {
        return this.size;
    }


    public void print() {
        Node current = this.Head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            if (current.next == null) break;
            sb.append("|" + current.data + "|-->");
            current = current.next;
        }
        assert current != null;
        sb.append("|").append(current.data).append("|");
        System.out.println(sb.toString());
    }


    public static void main(String[] argv) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        list.print();
        System.out.println("\n");
        list.reverse();
        list.print();

    }

}
