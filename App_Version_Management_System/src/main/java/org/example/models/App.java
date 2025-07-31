package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.OperatingSystemType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class App {
    private int id;
    private String name;
    private List<VersionMetaData> versions;
    private Set<OperatingSystemType> supportedOperatingSystems;

    public App(int id, String name, Set<OperatingSystemType> supportedOperatingSystems) {
        this.id = id;
        this.name = name;
        this.versions = new ArrayList<>();
        this.supportedOperatingSystems = supportedOperatingSystems;
    }

    public void addVersion(VersionMetaData metaData) {
        this.versions.add(metaData);
    }

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", versions=" + versions +
                ", supportedOperatingSystems=" + supportedOperatingSystems +
                '}';
    }
}
