package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.RequirementCommand;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.domain.Requirement;
import com.ssid.api.apissid.repositories.PositionRepository;
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
    private PositionRepository positionRepository;

    @Autowired
    public RequirementServiceImpl(RequirementRepository repository, PositionRepository repositoryPosition) {

        this.requirementRepository = repository;
        this.positionRepository = repositoryPosition;
    }

//    @Autowired
//    public PositionServiceImpl(PositionRepository repositoryPosition) {
//        this.positionRepository = repositoryPosition;
//    }

    @Override
    public List<Requirement> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : requirementRepository.findByName(name).get();
    }
    @Override
    public List<Requirement> findByPosition(Position  position) {
        return StringUtils.isEmpty(position) ? null : requirementRepository.findByPosition(position);
    }


    @Transactional
    @Override
    public Requirement createRequirement(RequirementCommand requirementCommand) {

        Position position = positionRepository.findById(requirementCommand.getPosition_position_id()).get();

        Requirement requirement = new Requirement();
        requirement.setName(requirementCommand.getName());
        requirement.setDescription(requirementCommand.getDescription());
        requirement.setPosition(position);

        requirement = save(requirement);
        return requirement;
    }

    @Override
    public void saveRequirements(Requirement requirement) {
        this.requirementRepository.save(requirement);
    }

    @Override
    public boolean updateRequirement(RequirementCommand requirementCommand, Long id) {
        boolean isChanged = false;
        Position position = positionRepository.findById(requirementCommand.getPosition_position_id()).get();

        //si existe, actualizamos
        if(requirementRepository.existsById(id)){
            Requirement requirementDB = findById(id);

            if(requirementDB.getName().compareTo(requirementCommand.getName()) != 0) {
                requirementDB.setName(requirementCommand.getName());
                isChanged = true;
            }
            if(requirementDB.getDescription().compareTo(requirementCommand.getDescription()) != 0) {
                requirementDB. setDescription(requirementCommand.getDescription());
                isChanged = true;
            }
            if(requirementDB.getPosition().getId().compareTo(requirementCommand.getPosition_position_id()) != 0) {

                requirementDB.setPosition(position);
                isChanged = true;
            }


            if(isChanged) {
                requirementDB.setPosition(position);
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
