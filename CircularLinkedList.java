class CircularLinkedList <T> {

    class Node {
        T data;
        Node next;
        Node (T data){
            this.data = data;
            this.next = null;
        }
    }

    Node tail;

    CircularLinkedList(){
        tail = null;
    }

    void insertBegining(T data){
        Node newNode = new Node(data);
        if (tail == null){
            newNode.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    void insertLast(T data){
        Node newNode = new Node(data);
        if (tail == null){
            newNode.next= newNode;
            tail = newNode;
        }
        else{
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void deleteBeginig(){
        if (tail == null){
            System.out.println("Empty List");
            return;
        }
        if(tail.next == tail){
            tail = null;
            return;
        }
        else{
            tail.next = tail.next.next;
        }
    }

    void display(){
        if (tail == null){
            System.out.println("Empty List");
            return;
        }

        Node temp = tail.next;
        System.out.println();
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }while( temp != tail.next);
    }

    public static void main(String[] args) {
        CircularLinkedList <Integer> list = new CircularLinkedList<>();
        list.insertBegining(7);
        list.insertBegining(5);
        list.insertBegining(1);
        list.insertLast(8);

        // list.deleteBeginig();

        list.display();
    }
}


