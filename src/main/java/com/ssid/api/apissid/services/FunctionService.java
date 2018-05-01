package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.FunctionCommand;
import com.ssid.api.apissid.domain.Function;


import java.util.List;

public interface FunctionService  extends GenericService<Function>{

    List<Function> findByName(String name);
    Function createFunction(FunctionCommand functionCommand);
    boolean updateFunction(FunctionCommand functionCommand, Long id);
}
