package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.OperatingSystemType;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserDevice {
    private int id;
    private OperatingSystemType operatingSystem;
    private Float operatingSystemVersion;
    private Map<App, Integer> appVersionMap;

    public UserDevice(int id, OperatingSystemType operatingSystem, Float osVersion) {
        this.id = id;
        this.operatingSystem = operatingSystem;
        this.operatingSystemVersion = osVersion;
        this.appVersionMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return "UserDevice{" +
                "id=" + id +
                ", operatingSystem=" + operatingSystem +
                ", operatingSystemVersion=" + operatingSystemVersion +
                '}';
    }
}
