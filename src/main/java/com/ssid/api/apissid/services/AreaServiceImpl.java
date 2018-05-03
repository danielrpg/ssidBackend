package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AreaServiceImpl extends GenericServiceImpl<Area> implements AreaService {
    private AreaRepository repository;

    @Autowired
    public AreaServiceImpl(AreaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Area> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : repository.findByName(name).get();
    }

    @Override
    public boolean updateArea(Area area, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if (repository.existsById(id)) {
            Area areaDB = findById(id);

            if (areaDB.getName().compareTo(area.getName()) != 0) {
                areaDB.setName(area.getName());
                isChanged = true;
            }
            if (areaDB.getDescription().compareTo(area.getDescription()) != 0) {
                areaDB.setDescription(area.getDescription());
                isChanged = true;
            }

            if (isChanged) {
                Area areaSaved = save(areaDB);

                if (areaSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            save(area);
        }

        return false;
    }

    @Override
    protected JpaRepository<Area, Long> getRepository() {
        return repository;
    }
}
