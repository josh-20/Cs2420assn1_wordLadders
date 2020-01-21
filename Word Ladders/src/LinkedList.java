public class LinkedList {

    class Node {
        String word;
        Node next;
        public Node(String word){
            this.word = word;
            this.next = null;
        }
    }
    public Node head = null;
    public Node tail = null;

    public void addNode(String words){
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
    public void display(){
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


