package com.ssid.api.apissid.services;


import com.ssid.api.apissid.command.FunctionPositionCommand;
import com.ssid.api.apissid.domain.FunctionPosition;
import com.ssid.api.apissid.repositories.FunctionPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class FunctionPositionServiceImpl extends GenericServiceImpl<FunctionPosition> implements FunctionPositionService {
    private FunctionPositionRepository functionPositionRepository;

    @Autowired
    public FunctionPositionServiceImpl(FunctionPositionRepository functionPositionRepository) {
        this.functionPositionRepository = functionPositionRepository;
    }

    @Override
    public List<FunctionPosition> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : functionPositionRepository.findByName(name).get();
    }

    @Transactional
    @Override
    public FunctionPosition createFunctionPosition(FunctionPositionCommand functionPositionCommand) {
        FunctionPosition functionPosition = new FunctionPosition();
        functionPosition.setName(functionPositionCommand.getName());
        functionPosition.setDescription(functionPositionCommand.getDescription());

        functionPosition = save(functionPosition);
        return functionPosition;
    }

    @Override
    public boolean updateFunctionPosition(FunctionPositionCommand functionPositionCommand, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if(functionPositionRepository.existsById(id)){
            FunctionPosition functionPositionDB = findById(id);

            if(functionPositionDB.getName().compareTo(functionPositionCommand.getName()) != 0) {
                functionPositionDB.setName(functionPositionCommand.getName());
                isChanged = true;
            }
            if(functionPositionDB.getDescription().compareTo(functionPositionCommand.getDescription()) != 0) {
                functionPositionDB.setDescription(functionPositionCommand.getDescription());
                isChanged = true;
            }

            if(isChanged) {
                FunctionPosition functionPositionSaved = save(functionPositionDB);

                if (functionPositionSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            createFunctionPosition(functionPositionCommand);
        }

        return false;
    }

    @Override
    protected JpaRepository<FunctionPosition, Long> getRepository() {
        return functionPositionRepository;
    }
}
