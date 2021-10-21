public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(6);
        list.insert(4);
        list.insert(2);
        list.insert(8);
        list.printList(list.head);
        list.insert(list, 17, 3);
        list.printList(list.head);

        list.deleteAtIndex(list, 4);
        list.printList(list.head);

        list.size(list);
        list.get(list, 3);
        list.includes(list, 101);
        list.indexOf(list, 4);
        list.printList(list.head);
    }
}
