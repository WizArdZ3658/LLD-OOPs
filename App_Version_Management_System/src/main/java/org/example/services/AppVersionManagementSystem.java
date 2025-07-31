package org.example.services;

import org.example.enums.RolloutStrategyType;
import org.example.models.App;
import org.example.models.UserDevice;
import org.example.models.VersionMetaData;

import java.io.File;
import java.util.List;

public interface AppVersionManagementSystem {
    void uploadNewVersion(App app, VersionMetaData versionMetaData, File file);
    String createUpdatePatch(App app, VersionMetaData fromVersion, VersionMetaData toVersion);
    void releaseVersion(App app, RolloutStrategyType rolloutStrategyType, List<UserDevice> devices, Float percentage);

    boolean isAppVersionSupported(VersionMetaData versionMetaData, UserDevice device);    // will check if given targetVersion supports the input device using info like device android version, rollout strategies etc
    boolean checkForInstall(App app, UserDevice device);          // Check whether a given h/w + OS supports the the app or not
    boolean checkForUpdates(App app, UserDevice device);          // checks if an update is available for a given device.
}
