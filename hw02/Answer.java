package hw02;

class Answer {

    Node head;

    public void reverse() { // head = 1 -> 2 -> 3 -> 4 -> null
      // Введите свое решение ниже
        if (head.next == null){ // if 1 -> null
            return;
        }
        Node nextNode;
        Node currNode = head.next; // 2 -> 3
        Node prevNode = head; // 1 -> 2
        head.next = null; // 1 -> null
        while (currNode.next != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        } 
        currNode.next = prevNode;
        head = currNode;
    }
}
