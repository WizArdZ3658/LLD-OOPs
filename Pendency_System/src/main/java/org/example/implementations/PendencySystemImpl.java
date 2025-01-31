package org.example.implementations;

import org.example.customdatastructure.DoublyLinkedList;
import org.example.customdatastructure.Node;
import org.example.interfaces.PendencySystem;
import org.example.models.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PendencySystemImpl implements PendencySystem {
//    private final List<Entity> entityList = new ArrayList<>();
    private final DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    private final Map<Integer, Node> integerNodeMap = new HashMap<>();


    @Override
    public void startTracking(Integer id, List<String> hierarchicalTags) {
        Entity entity = new Entity(id, hierarchicalTags);
//        this.entityList.add(entity);
        Node node = new Node(entity);
        this.doublyLinkedList.add(node);
        integerNodeMap.put(id, node);
//        this.doublyLinkedList.printList();
    }

    @Override
    public void stopTracking(Integer id) {
        if (this.integerNodeMap.containsKey(id)) {
            Node node = this.integerNodeMap.get(id);
            System.out.println("prev node " + node.getPrevNode());
            System.out.println("next node " + node.getNextNode());
            this.doublyLinkedList.remove(node);
            this.integerNodeMap.remove(id);
        } else {
            System.out.print("Key not found in map : ");
            System.out.println(id);
        }
    }

    @Override
    public Integer getCounts(List<String> tags) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String tag : tags) {
            sb.append(tag);
            sb.append(":");
        }
        String tagsIdentifier = sb.toString();
        Node curr = this.doublyLinkedList.getHead();
        while(curr != null) {
            Entity entity = curr.getEntity();
            if (entity.getTagsIdentifier().startsWith(tagsIdentifier)) {
                count = count + 1;
            }
            curr = curr.getNextNode();
        }
        return count;
    }
}
