package org.example.customdatastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    public void add(Node node) {
        if (this.head == null) {
//            System.out.println("adding first node");
            this.head = node;
        } else {
//            System.out.println("adding more node to tail");
//            System.out.println(this.tail);
            this.tail.setNextNode(node);
            node.setPrevNode(this.tail);
        }
        this.tail = node;
    }

    public void remove(Node node) {
        System.out.println(node);
        Node previousNode = node.getPrevNode();
        Node nextNode = node.getNextNode();
//        System.out.println(previousNode);
//        System.out.println(previousNode);
        if (previousNode != null) {
            previousNode.setNextNode(nextNode);
        } else {
            this.head = nextNode;
        }
        if (nextNode != null) {
            nextNode.setPrevNode(previousNode);
        } else {
            this.tail = previousNode;
        }
        node = null;
    }

    public void printList() {
        Node curr = this.head;
        while(curr != null) {
            System.out.print(curr);
            System.out.print("->");
            curr = curr.getNextNode();
        }
        System.out.println();
    }

}
