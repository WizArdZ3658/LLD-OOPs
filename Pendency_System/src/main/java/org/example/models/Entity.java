package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Entity {
    private Integer id;
    private List<String> tags;
    private String tagsIdentifier;

    public Entity(Integer id, List<String> tags) {
        this.id = id;
        this.tags = tags;
        StringBuilder sb = new StringBuilder();
        for (String tag : tags) {
            sb.append(tag);
            sb.append(":");
        }
        this.tagsIdentifier = sb.toString();
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", tagsIdentifier='" + tagsIdentifier + '\'' +
                '}';
    }
}
