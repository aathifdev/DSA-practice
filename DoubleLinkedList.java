class Node {
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoubleLinkedList {
    Node head = null;

    void insertBegining(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertLast(int data){
        if (head == null){
            insertBegining(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    void insertIndex(int index, int data){
        if (index < 0){
            System.out.println("Invalid Index");
            return;
        }
        Node temp = head;
        for (int i =0; i < index-1; i++){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        temp.next.prev = newNode;
    }

    void delete (int data){
        Node temp = head;
        if (head.data == data){
            head = head.next;
            return;
        }
        while (temp.next != null && temp.next.data != data){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("Invalid Data");
            return;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    void deleteIndex(int index){
        if (index < 0) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0){
            head = head.next;
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        if (temp.next == null || temp == null) {
            return;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    void display(){
        System.out.println();
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertBegining(1);
        list.insertBegining(2);
        list.insertBegining(3);


        list.delete(2);
        list.deleteIndex(2);
        
        list.display();

    }
}
