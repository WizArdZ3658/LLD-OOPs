package org.example.services.implementations.rolloutStrategies;

import org.example.models.App;
import org.example.models.RolloutStrategyContext;
import org.example.models.UserDevice;
import org.example.models.VersionMetaData;
import org.example.services.AppVersionManagementSystem;
import org.example.services.AvailableCapabilities;
import org.example.services.RolloutStrategy;
import org.example.services.implementations.AppVersionManagementSystemImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PercentageRolloutStrategy implements RolloutStrategy {
    @Override
    public List<UserDevice> getDevices() {
        return List.of();
    }

    @Override
    public void rolloutToDevices(App app, VersionMetaData versionMetaData, RolloutStrategyContext context) {
        AppVersionManagementSystem appVersionManagementSystem = new AppVersionManagementSystemImpl();

        List<UserDevice> filteredDevices = new ArrayList<>();

        for (UserDevice device : context.getDevices()) {
            if (!appVersionManagementSystem.isAppVersionSupported(versionMetaData, device)) {
                continue;
            }

            if (appVersionManagementSystem.checkForUpdates(app, device)) {
                filteredDevices.add(device);
            } else if (appVersionManagementSystem.checkForInstall(app, device)) {
                filteredDevices.add(device);
            }
        }

        System.out.println("Filtered devices " + filteredDevices);

        context.setDevices(filteredDevices);
        List<UserDevice> devices = this.getRandomDevicesBasedOnPercentage(context);

        System.out.println("Randomized devices based on percentage " + devices);

        for (UserDevice device : devices) {
            if (appVersionManagementSystem.checkForUpdates(app, device)) {
                AvailableCapabilities.updateApp(device);
            } else if (appVersionManagementSystem.checkForInstall(app, device)) {
                AvailableCapabilities.installApp(device);
            }
        }
    }

    private List<UserDevice> getRandomDevicesBasedOnPercentage(RolloutStrategyContext context) {
        int k = (int) Math.ceil((context.getPercentage() / 100.0) * context.getDevices().size());

        List<UserDevice> result = new ArrayList<>(context.getDevices());
        Random random = new Random();

        for (int i = 0; i < k; i++) {
            int j = i + random.nextInt(result.size() - i);
            Collections.swap(result, i, j);
        }

        return result.subList(0, k);
    }
}
