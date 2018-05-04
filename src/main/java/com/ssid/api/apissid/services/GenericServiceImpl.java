/**
 * @author: Edson A. Terceros T.
 */

package com.ssid.api.apissid.services;

import com.ssid.api.apissid.exceptions.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

    @Transactional
    @Override
    public List<T> findAll() {
        List<T> results = new ArrayList<>();
        getRepository().findAll().forEach(results::add);
        return results;
    }

    @Transactional
    @Override
    public T findById(Long id) {

        Optional<T> optional = getRepository().findById(id);
        if (!optional.isPresent()) {
            String typeName = (((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
            throw new NotFoundException(typeName + " id:" + id + " Not Found");
        }
        return optional.get();
    }

    @Transactional
    @Override
    public boolean update(T t, Long id) {
        //TODO: completar funcionalidad
        return false;
    }

    @Transactional
    @Override
    public T save(T model) {
        return getRepository().save(model);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if(getRepository().existsById(id)) {
            getRepository().deleteById(id);
        }
    }

    protected abstract JpaRepository<T, Long> getRepository();
}