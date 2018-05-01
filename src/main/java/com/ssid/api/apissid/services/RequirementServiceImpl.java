package com.ssid.api.apissid.services;



import com.ssid.api.apissid.command.RequirementCommand;
import com.ssid.api.apissid.domain.Requirement;

import com.ssid.api.apissid.repositories.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RequirementServiceImpl extends GenericServiceImpl<Requirement> implements RequirementService {
    private RequirementRepository requirementRepository;

    @Autowired
    public RequirementServiceImpl(RequirementRepository repository) {
        this.requirementRepository = repository;
    }

    @Override
    public List<Requirement> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : requirementRepository.findByName(name).get();
    }

    @Transactional
    @Override
    public Requirement createRequirement(RequirementCommand requirementCommand) {
        Requirement requirement = new Requirement();
        requirement.setName(requirementCommand.getName());
        requirement.setDescription(requirementCommand.getDescription());

        requirement = save(requirement);
        return requirement;
    }

    @Override
    public boolean updateRequirement(RequirementCommand requirementCommand, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if(requirementRepository.existsById(id)){
            Requirement requirementDB = findById(id);

            if(requirementDB.getName().compareTo(requirementCommand.getName()) != 0) {
                requirementDB.setName(requirementCommand.getName());
                isChanged = true;
            }
            if(requirementDB.getDescription().compareTo(requirementCommand.getDescription()) != 0) {
                requirementDB.setDescription(requirementCommand.getDescription());
                isChanged = true;
            }

            if(isChanged) {
                Requirement requirementSaved = save(requirementDB);

                if (requirementSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            createRequirement(requirementCommand);
        }

        return false;
    }

    @Override
    protected JpaRepository<Requirement, Long> getRepository() {
        return requirementRepository;
    }
}
