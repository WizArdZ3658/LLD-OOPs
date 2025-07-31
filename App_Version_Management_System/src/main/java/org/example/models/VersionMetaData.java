package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.OperatingSystemType;

@Getter
@Setter
@Builder
public class VersionMetaData {
    private int version;
    private Float supportedOSVersion;
    private OperatingSystemType supportedOS;
    private String releaseNotes;
    private String fileURL;

    @Override
    public String toString() {
        return "VersionMetaData{" +
                "version=" + version +
                ", supportedOSVersion=" + supportedOSVersion +
                ", supportedOS=" + supportedOS +
                ", releaseNotes='" + releaseNotes + '\'' +
                ", fileURL='" + fileURL + '\'' +
                '}';
    }
}
