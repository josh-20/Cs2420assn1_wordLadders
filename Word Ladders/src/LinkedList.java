public class LinkedList {

    class Node {
        WordInfo word;
        Node next;
        public Node(WordInfo word){
            this.word = word;
            this.next = null;
        }
    }
    public Node head = null;
    public Node tail = null;

    public void enqueue(WordInfo words){
        Node newNode = new Node(words);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public Node dequeue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return null;
        }
        Node tempNode = head;
        head = head.next;
        return tempNode;
    }
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }

    public void print(){
        Node current = head;
        if (head == null){
            System.out.println("list is empty");
            return;
        }
        System.out.println("Nodes of single list");
        while(current != null) {
            System.out.println(current.word + " ");
            current = current.next;
        }
        System.out.println();
    }
}


