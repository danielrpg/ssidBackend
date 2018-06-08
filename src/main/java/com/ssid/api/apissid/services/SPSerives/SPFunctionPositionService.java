package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Contract;
import com.ssid.api.apissid.domain.FunctionPosition;

import java.util.List;

public interface SPFunctionPositionService {
    List<FunctionPosition> getAllFunctions();

    Boolean createFunctions(FunctionPosition functionPosition);

    Boolean deleteFunctions(Long idFunctions);

    Contract updateFunctions(Long idFunctions, FunctionPosition functionPosition);
}
