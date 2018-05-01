package com.ssid.api.apissid.services;


import com.ssid.api.apissid.command.FunctionCommand;
import com.ssid.api.apissid.domain.Function;
import com.ssid.api.apissid.repositories.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class FunctionServiceImpl extends GenericServiceImpl<Function> implements FunctionService {
    private FunctionRepository functionRepository;

    @Autowired
    public FunctionServiceImpl(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    @Override
    public List<Function> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : functionRepository.findByName(name).get();
    }

    @Transactional
    @Override
    public Function createFunction(FunctionCommand functionCommand) {
        Function function = new Function();
        function.setName(functionCommand.getName());
        function.setDescription(functionCommand.getDescription());

        function = save(function);
        return function;
    }

    @Override
    public boolean updateFunction(FunctionCommand functionCommand, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if(functionRepository.existsById(id)){
            Function functionDB = findById(id);

            if(functionDB.getName().compareTo(functionCommand.getName()) != 0) {
                functionDB.setName(functionCommand.getName());
                isChanged = true;
            }
            if(functionDB.getDescription().compareTo(functionCommand.getDescription()) != 0) {
                functionDB.setDescription(functionCommand.getDescription());
                isChanged = true;
            }

            if(isChanged) {
                Function functionSaved = save(functionDB);

                if (functionSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            createFunction(functionCommand);
        }

        return false;
    }

    @Override
    protected JpaRepository<Function, Long> getRepository() {
        return functionRepository;
    }
}
