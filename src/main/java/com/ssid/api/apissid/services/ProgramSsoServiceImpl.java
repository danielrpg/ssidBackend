package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ProgramSso;
import com.ssid.api.apissid.exceptions.NotFoundException;
import com.ssid.api.apissid.repositories.ProgramSsoRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramSsoServiceImpl implements ProgramSsoService {
    private ProgramSsoRepository programSsoRepository;

    public ProgramSsoServiceImpl(ProgramSsoRepository programSsoRepository) {
        this.programSsoRepository = programSsoRepository;
    }

    @Override
    public List<ProgramSso> getProgramsSso() {
        return this.programSsoRepository.findAll();
    }

    @Override
    public ProgramSso saveProgramSso(ProgramSso programSso) {
        return this.programSsoRepository.save(programSso);
    }

    @Override
    public ProgramSso getProgramById(Long id) {
        Optional<ProgramSso> optional = programSsoRepository.findById(id);
        if (!optional.isPresent()) {
            String typeName = (((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
            throw new NotFoundException(typeName + " id:" + id + " Not Found");
        }
        return optional.get();
    }

    @Override
    public void deleteProgramById(Long id) {
        Optional<ProgramSso> programSso = this.programSsoRepository.findById(id);
        this.programSsoRepository.delete(programSso.get());

    }

    @Override
    public ProgramSso updateProgram(ProgramSso programSso, Long id) {
        Optional<ProgramSso> updateProgram  = this.programSsoRepository.findById(id);
        if(!updateProgram.isPresent())
            return null;
        programSso.setId(id);
        this.programSsoRepository.save(programSso);
        return programSso;
    }
}
