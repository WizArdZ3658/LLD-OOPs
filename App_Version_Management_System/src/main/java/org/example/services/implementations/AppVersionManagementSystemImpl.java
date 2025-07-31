package org.example.services.implementations;

import org.example.enums.RolloutStrategyType;
import org.example.models.App;
import org.example.models.RolloutStrategyContext;
import org.example.models.UserDevice;
import org.example.models.VersionMetaData;
import org.example.services.AppVersionManagementSystem;
import org.example.services.AvailableCapabilities;
import org.example.services.RolloutStrategy;
import org.example.services.RolloutStrategyFactory;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class AppVersionManagementSystemImpl implements AppVersionManagementSystem {

    @Override
    public void uploadNewVersion(App app, VersionMetaData versionMetaData, File file) {
        String url = AvailableCapabilities.uploadFile(file);
        versionMetaData.setFileURL(url);
        app.addVersion(versionMetaData);
    }

    @Override
    public String createUpdatePatch(App app, VersionMetaData fromVersion, VersionMetaData toVersion) {
        return AvailableCapabilities.createDiffPack(fromVersion, toVersion);
    }

    @Override
    public void releaseVersion(App app, RolloutStrategyType rolloutStrategyType, List<UserDevice> devices, Float percentage) {
        VersionMetaData latestVersionMetaData = app.getVersions().get(app.getVersions().size()-1);
        RolloutStrategy rolloutStrategy = RolloutStrategyFactory.getInstance(rolloutStrategyType);
        RolloutStrategyContext context = RolloutStrategyContext.builder().devices(devices).percentage(percentage).build();
        rolloutStrategy.rolloutToDevices(app, latestVersionMetaData, context);
    }

    @Override
    public boolean isAppVersionSupported(VersionMetaData versionMetaData, UserDevice device) {
        return device.getOperatingSystemVersion() >= versionMetaData.getSupportedOSVersion() && Objects.equals(versionMetaData.getSupportedOS(), device.getOperatingSystem());
    }

    @Override
    public boolean checkForInstall(App app, UserDevice device) {
        List<VersionMetaData> versions = app.getVersions();
        for (VersionMetaData version : versions) {
            if (device.getOperatingSystemVersion() >= version.getSupportedOSVersion() && Objects.equals(version.getSupportedOS(), device.getOperatingSystem())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkForUpdates(App app, UserDevice device) {
        VersionMetaData latestVersionMetaData = app.getVersions().get(app.getVersions().size()-1);
        int versionOnDevice = device.getAppVersionMap().getOrDefault(app, -1);
        System.out.println("App version on device " + device + " is " + versionOnDevice);
        if (versionOnDevice == -1) {
            return false;
        }
        return latestVersionMetaData.getVersion() > versionOnDevice;
    }
}
