package org.example.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RolloutStrategyContext {
    private List<UserDevice> devices;
    private Float percentage;
}
