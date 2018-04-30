package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.repositories.PositionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl extends GenericServiceImpl<Position> implements PositionService{
    private PositionRepository repository;

    public PositionServiceImpl(PositionRepository positionRepository){
        this.repository = positionRepository;
    }

    @Override
    public boolean updatePosition(Position position, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if (repository.existsById(id)) {
            Position positionDB = findById(id);

            if (positionDB.getName().compareTo(position.getName()) != 0) {
                positionDB.setName(position.getName());
                isChanged = true;
            }

            if (positionDB.getDescription().compareTo(position.getDescription()) != 0) {
                positionDB.setDescription(position.getDescription());
                isChanged = true;
            }

            if (positionDB.getDescription().compareTo(position.getDescription()) != 0) {
                positionDB.setDescription(position.getDescription());
                isChanged = true;
            }

            if (positionDB.getLevel() != position.getLevel()) {
                positionDB.setLevel(position.getLevel());
                isChanged = true;
            }

            if(positionDB.getParentPosition() != position.getParentPosition()){
                positionDB.setParentPosition(position.getParentPosition());
                isChanged = true;
            }

            if (isChanged) {
                Position positionSaved = save(positionDB);

                if (positionSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            save(position);
        }

        return false;
    }

    @Override
    protected JpaRepository<Position, Long> getRepository() {
        return repository;
    }
}
