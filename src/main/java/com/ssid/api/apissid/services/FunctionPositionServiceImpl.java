package com.ssid.api.apissid.services;


import com.ssid.api.apissid.command.FunctionPositionCommand;
import com.ssid.api.apissid.domain.FunctionPosition;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.repositories.FunctionPositionRepository;
import com.ssid.api.apissid.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class FunctionPositionServiceImpl extends GenericServiceImpl<FunctionPosition> implements FunctionPositionService {
    private FunctionPositionRepository functionPositionRepository;
    private PositionRepository positionRepository;

    @Autowired
    public FunctionPositionServiceImpl(FunctionPositionRepository functionPositionRepository, PositionRepository repositoryPosition) {
        this.functionPositionRepository = functionPositionRepository;
        this.positionRepository = repositoryPosition;
    }

    @Override
    public List<FunctionPosition> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : functionPositionRepository.findByName(name).get();
    }
    @Override
    public List<FunctionPosition> findByPosition(Position  position) {
        return StringUtils.isEmpty(position) ? null : functionPositionRepository.findByPosition(position);
    }
    @Transactional
    @Override
    public FunctionPosition createFunctions(FunctionPositionCommand functionPositionCommand) {

        Position position =  positionRepository.findById(functionPositionCommand.getPosition_position_id()).get();

        FunctionPosition function = new FunctionPosition();
        function.setName(functionPositionCommand.getName());
        function.setDescription(functionPositionCommand.getDescription());
        function.setPosition(position);

        function = save(function);
        return function;
    }

    @Override
    public boolean updateFunction(FunctionPositionCommand functionPositionCommand, Long id) {
        boolean isChanged = false;
        Position position =  positionRepository.findById(functionPositionCommand.getPosition_position_id()).get();

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
            if(functionPositionDB.getPosition().getId().compareTo(functionPositionCommand.getPosition_position_id()) != 0) {

                functionPositionDB.setPosition(position);
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
            createFunctions(functionPositionCommand);
        }

        return false;
    }

    @Override
    protected JpaRepository<FunctionPosition, Long> getRepository() {
        return functionPositionRepository;
    }
}
