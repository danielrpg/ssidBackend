package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.FunctionPositionCommand;
import com.ssid.api.apissid.domain.FunctionPosition;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.domain.Requirement;


import java.util.List;

public interface FunctionPositionService  extends GenericService<FunctionPosition>{

    List<FunctionPosition> findByName(String name);
    FunctionPosition createFunctions(FunctionPositionCommand functionPositionCommand);
    boolean updateFunction(FunctionPositionCommand functionPositionCommand, Long id);
    List<FunctionPosition> findByPosition(Position position);
}
