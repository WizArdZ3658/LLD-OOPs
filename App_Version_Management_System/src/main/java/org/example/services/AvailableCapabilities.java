package org.example.services;

import org.example.models.UserDevice;
import org.example.models.VersionMetaData;

import java.io.File;

public class AvailableCapabilities {

    //    will flash the app file in the device
    public static void installApp(UserDevice device) {
        System.out.println("App installed on device " + device.getId());
    }

    //    will flash the diff pack in the device
    public static void updateApp(UserDevice device) {
        System.out.println("App updated on device " + device.getId());
    }

    //    will consume 2 app files and create diff pack file from sourceFile to targetFile
    public static String createDiffPack(VersionMetaData fromVersion, VersionMetaData toVersion) {
        System.out.println("Generated diff pack.");
        return "mdfsakndksanmdsam";
    }

    //    will upload the file in some storage and return its url.
    public static String uploadFile(File fileContent) {
        System.out.println("File uploaded.");
        return "https://s3-ap-south-1.com/bin/app.apk";
    }

    //    returns a file content, which could then be flashed using either installApp or updateApp methods
    public static File getFile(String fileUrl) {
        return new File("Documents/file.txt");
    }
}
