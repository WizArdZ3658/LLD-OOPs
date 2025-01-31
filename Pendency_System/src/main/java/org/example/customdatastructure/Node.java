package org.example.customdatastructure;

import lombok.Getter;
import lombok.Setter;
import org.example.models.Entity;

@Getter
@Setter
public class Node {
    private Entity entity;
    private Node nextNode;
    private Node prevNode;

    public Node(Entity entity) {
        this.entity = entity;
        this.nextNode = null;
        this.prevNode = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "entity=" + this.entity +
                '}';
    }
}
