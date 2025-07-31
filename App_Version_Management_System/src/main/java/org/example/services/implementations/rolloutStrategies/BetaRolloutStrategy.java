package org.example.services.implementations.rolloutStrategies;

import org.example.models.App;
import org.example.models.RolloutStrategyContext;
import org.example.models.UserDevice;
import org.example.models.VersionMetaData;
import org.example.services.AppVersionManagementSystem;
import org.example.services.AvailableCapabilities;
import org.example.services.RolloutStrategy;
import org.example.services.implementations.AppVersionManagementSystemImpl;

import java.util.List;

public class BetaRolloutStrategy implements RolloutStrategy {
    @Override
    public List<UserDevice> getDevices() {
        return List.of();
    }

    @Override
    public void rolloutToDevices(App app, VersionMetaData versionMetaData, RolloutStrategyContext context) {
        AppVersionManagementSystem appVersionManagementSystem = new AppVersionManagementSystemImpl();
        for (UserDevice device : context.getDevices()) {
            if (!appVersionManagementSystem.isAppVersionSupported(versionMetaData, device)) {
                continue;
            }

            if (appVersionManagementSystem.checkForUpdates(app, device)) {
                AvailableCapabilities.updateApp(device);
            } else if (appVersionManagementSystem.checkForInstall(app, device)) {
                AvailableCapabilities.installApp(device);
            }
        }
    }
}
