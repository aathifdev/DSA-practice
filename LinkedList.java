class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;

    void instertBegining(int data){
        Node newNode = new Node(data);
        newNode.next = head;            // 3 2 1
        head = newNode;
    }

    void insertLast(int data){
        if (head == null){
            instertBegining(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;            // 3 2 1 4
    }

    void insertIndex(int index, int data){
        if (index<0) {
            System.out.println("Invalid Index");
        }
        Node temp = head;
        for (int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;     //3 2 5 1 4         - index 2, value = 5
        temp.next = newNode;
    }

    void delete (int data){         // This conditon for delete using data
        Node temp = head;
        if (head.data == data){
            head = head.next;
            return;
        }
        while(temp.next != null && temp.next.data != data){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("Invalid Index");
            return;
        }
        temp.next = temp.next.next;
    }

    void deleteIndex(int index){
        if (index < 0 ) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0){
            head = head.next;
            return;
        }
        Node temp = head;
        for ( int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
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
        LinkedList list = new LinkedList();
        list.instertBegining(1); // 1
        list.instertBegining(2); // 2 1
        list.instertBegining(3); // 3 2 1 

        list.insertLast(4); // 3 2 1 4

        list.insertIndex(2, 5); // 3 2 5 1 4

        list.delete(5); // 3 2 1 4

        list.deleteIndex(1); // 3 2 4

        list.display();

        list.reverse();

        list.display();

    }
    

}