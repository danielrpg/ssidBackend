/**
 * @author: Edson A. Terceros T.
 */

package com.ssid.api.apissid.services;

import java.util.List;

public interface GenericService<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T model);

    void deleteById(Long id);

    boolean update(T t, Long id);
}
