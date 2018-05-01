package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.FunctionPositionCommand;
import com.ssid.api.apissid.domain.FunctionPosition;


import java.util.List;

public interface FunctionPositionService  extends GenericService<FunctionPosition>{

    List<FunctionPosition> findByName(String name);
    FunctionPosition createFunctionPosition(FunctionPositionCommand functionPositionCommand);
    boolean updateFunctionPosition(FunctionPositionCommand functionPositionCommand, Long id);
}
