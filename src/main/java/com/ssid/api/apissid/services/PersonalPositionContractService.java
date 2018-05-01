package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.PersonalPositionContract;

/**
 * @author Jesús David Piérola Alvarado
 */
public interface PersonalPositionContractService extends GenericService<PersonalPositionContract> {
    boolean updatePPC(PersonalPositionContract personalPositionContract, Long id);
}
