package com.ssid.api.apissid.services;


import com.ssid.api.apissid.domain.PersonalPositionContract;
import com.ssid.api.apissid.repositories.PersonalPositionContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalPositionContractServiceImpl extends GenericServiceImpl<PersonalPositionContract>
        implements PersonalPositionContractService {
    private PersonalPositionContractRepository repository;

    @Autowired
    public PersonalPositionContractServiceImpl(PersonalPositionContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean updatePPC(PersonalPositionContract personalPositionContract, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if (repository.existsById(id)) {
            PersonalPositionContract personalPositionContractDB = findById(id);

            if (personalPositionContractDB.getInitDate() != personalPositionContractDB.getInitDate()) {
                personalPositionContractDB.setInitDate(personalPositionContract.getInitDate());
                isChanged = true;
            }
            if (personalPositionContractDB.getEndDate() != personalPositionContractDB.getEndDate()) {
                personalPositionContractDB.setEndDate(personalPositionContract.getEndDate());
                isChanged = true;
            }
            if (personalPositionContractDB.isStatus() != personalPositionContractDB.isStatus()) {
                personalPositionContractDB.setStatus(personalPositionContract.isStatus());
                isChanged = true;
            }
            if (personalPositionContractDB.getTurno().compareTo(personalPositionContract.getTurno()) != 0) {
                personalPositionContractDB.setTurno(personalPositionContract.getTurno());
                isChanged = true;
            }

            if (personalPositionContractDB.getPersonal() != personalPositionContractDB.getPersonal()) {
                personalPositionContractDB.setPersonal(personalPositionContract.getPersonal());
                isChanged = true;
            }
            if (personalPositionContractDB.getPosition() != personalPositionContractDB.getPosition()) {
                personalPositionContractDB.setPosition(personalPositionContract.getPosition());
                isChanged = true;
            }
            if (personalPositionContractDB.getContract() != personalPositionContractDB.getContract()) {
                personalPositionContractDB.setContract(personalPositionContract.getContract());
                isChanged = true;
            }

            if (isChanged) {
                PersonalPositionContract personalPositionContractSaved = save(personalPositionContractDB);

                if (personalPositionContractSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            save(personalPositionContract);
        }

        return false;
    }

    @Override
    protected JpaRepository<PersonalPositionContract, Long> getRepository() {
        return repository;
    }
}
