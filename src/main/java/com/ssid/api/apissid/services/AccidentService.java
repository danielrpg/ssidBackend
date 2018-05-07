package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Accident;
import java.util.List;

public interface AccidentService extends GenericService<Accident>{

    List<Accident> getAllAccidents();
}
