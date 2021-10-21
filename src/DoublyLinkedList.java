import java.util.LinkedList;

public class DoublyLinkedList {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) {
            data = d;
        }
    }

    void insert(int newData) {
        Node newNode = new Node(newData);
        Node last = head;
        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    public void insert(DoublyLinkedList list, int data, int index) {
        Node newNode = new Node(data);
        newNode.next = null;

        int size = returnSize(list);

        if (index == size) {
            insert(data);
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
        } else if (index == 0) {
            newNode.next = head;
            newNode.prev = null;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
        } else if (index > 0 && index < size) {
            Node currNode = list.head, prev = null;
            int counter = 0;

            while (currNode != null && counter < index - 1) {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
            Node temp = currNode.next;
            currNode.next = newNode;
            newNode.next = temp;
            newNode.prev = currNode;
            newNode.next.prev = newNode;
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
        } else {
            System.out.println("Sorry, you can't add a Node at an index that's less than zero or greater than the size of the list.");
        }
    }

    public static void deleteAtIndex(DoublyLinkedList list, int index) {
        Node currNode = list.head, prev = null;
        int size = returnSize(list);

        if (index == 0 && currNode != null) {
            if (currNode.next == null) {
                list.head = null;
            } else {
                list.head = list.head.next;
            }
            System.out.println("Element at index " + index + " has been deleted.");
        } else if ((index > 0) && (index <= size)) {
            int counter = 0;
            while (currNode != null) {
                if (counter == index) {
                    if (index == size - 1) {
                        currNode.prev.next = null;
                    } else {
                        currNode.prev.next = currNode.next;
                        currNode.next.prev = currNode.prev;
                    }
                    System.out.println("Element at index " + index + " has been " +
                            "deleted.");
                    break;
                } else {
                    prev = currNode;
                    currNode = currNode.next;
                    counter++;
                }
            }
        } else {
            System.out.println("Element at index " + index + " not found.");
        }
    }

    public static int returnSize(DoublyLinkedList list) {
        Node currNode = list.head, prev = null;
        int counter = 0;

        while (currNode != null) {
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }
        return counter;
    }

    public static void size(DoublyLinkedList list) {
        int size = returnSize(list);
        System.out.println("This Doubly LinkedList is " + size + " elements long.");
    }

    public static int get(DoublyLinkedList list, int index) {
        Node currNode = list.head, prev = null;
        int value = -1;
        int counter = 0;
        int size = list.returnSize(list);

        if (index >= size || index < 0) {
            System.out.println("Sorry, there's no value at that index.");
            return value;
        } else {
            while (currNode != null) {
                if (counter == index) {
                    value = currNode.data;
                    System.out.println("The value at index " + index + " is " + value + ".");
                    break;
                } else {
                    prev = currNode;
                    currNode = currNode.next;
                    counter++;
                }
            }
            return value;
        }
    }

    public static boolean includes(DoublyLinkedList list, int key) {
        int counter = returnIndexOf(list, key);
        if (counter == -1) {
            System.out.println(key + " was not found in the list.");
        } else {
            System.out.println(key + " was found at element " + counter + ".");
        }
        return true;
    }

    public static int returnIndexOf(DoublyLinkedList list, int key) {
        Node currNode = list.head, prev = null;
        int counter = 0;

        if (currNode != null && currNode.data == key) {
            return counter;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }

        if (currNode == null) {
            return -1;
        }
        return counter;
    }

    public static void indexOf(DoublyLinkedList list, int key) {
        if (returnIndexOf(list, key) == -1) {
            System.out.println("Element of value " + key + " could not be found.");
        } else {
            System.out.println("The first index with value " + key + " is " + returnIndexOf(list, key) + ".");
        }
    }



    public void printList(Node node) {
        Node last = null;
        System.out.print("Doubly LinkedList (forward traversal): ");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.print("| Doubly LinkedList (backward traversal): ");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }

}
