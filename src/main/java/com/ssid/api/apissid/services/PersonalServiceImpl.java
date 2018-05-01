package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.repositories.PersonalRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Jesus David Piérola Alvarado
 */
@Service
public class PersonalServiceImpl extends GenericServiceImpl<Personal> implements PersonalService {

    private PersonalRepository repository;

    public PersonalServiceImpl(PersonalRepository personalRepository) {
        this.repository = personalRepository;
    }

    @Override
    public List<Personal> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : repository.findByName(name).get();
    }

    @Override
    public boolean updatePersonal(Personal personal, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if (repository.existsById(id)) {
            Personal personalDB = findById(id);

            if (personalDB.getName().compareTo(personal.getName()) != 0) {
                personalDB.setName(personal.getName());
                isChanged = true;
            }

            if (personalDB.getPhoto() != personal.getPhoto()) {
                personalDB.setPhoto(personal.getPhoto());
                isChanged = true;
            }

            if (personalDB.getEmail().compareTo(personal.getEmail()) != 0) {
                personalDB.setEmail(personal.getEmail());
                isChanged = true;
            }

            if (personalDB.getAddress().compareTo(personal.getAddress()) != 0) {
                personalDB.setAddress(personal.getAddress());
                isChanged = true;
            }

            if (personalDB.getCellphone().compareTo(personal.getCellphone()) != 0) {
                personalDB.setCellphone(personal.getCellphone());
                isChanged = true;
            }

            if (personalDB.getTelephone().compareTo(personal.getTelephone()) != 0) {
                personalDB.setTelephone(personal.getTelephone());
                isChanged = true;
            }

            if (personalDB.getActive() != personal.getActive()) {
                personalDB.setActive(personal.getActive());
                isChanged = true;
            }

            if(personalDB.getArea() != personal.getArea()){
                personalDB.setArea(personal.getArea());
                isChanged = true;
            }

            if (isChanged) {
                Personal personalSaved = save(personalDB);

                if (personalSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            save(personal);
        }

        return false;
    }

    @Override
    protected JpaRepository<Personal, Long> getRepository() {
        return repository;
    }
}
