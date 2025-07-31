package org.example.services;

import org.example.models.App;
import org.example.models.RolloutStrategyContext;
import org.example.models.UserDevice;
import org.example.models.VersionMetaData;

import java.util.List;

public interface RolloutStrategy {
    List<UserDevice> getDevices();
    void rolloutToDevices(App app, VersionMetaData versionMetaData, RolloutStrategyContext context);
}
