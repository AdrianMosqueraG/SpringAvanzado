package com.example.DBA1.QuerysAvanzadas.profesor.application.service.impl;

import com.example.DBA1.QuerysAvanzadas.profesor.application.service.interfaz.ProfesorCrudService;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.dto.input.ProfesorInputDto;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.dto.output.ProfesorOutputDto;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.entity.Profesor;
import com.example.DBA1.QuerysAvanzadas.profesor.infrastructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceCrudImpl implements ProfesorCrudService {


    @Autowired
    private ProfesorRepository profesorRepository;

    private ProfesorOutputDto converToDto(Profesor profesor){
        return new ProfesorOutputDto(profesor);
    }

    @Override
    public List<ProfesorOutputDto> getAll() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesores
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) throws Exception {
        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(profesorInputDto.profesor());
        if(profesorInputDto.profesor().getBranch().length() > 0){
            profesorRepository.save(profesorInputDto.profesor());
            return profesorOutputDto;
        }else {
            throw new Exception("Datos invalidos para aniadir a este profesor");
        }
    }

    @Override
    public ProfesorOutputDto deleteProfesor(int id) throws Exception {
        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(profesorRepository.findById(id));
        if(profesorRepository.findById(id) != null){
            profesorRepository.deleteById(id);
            return profesorOutputDto;
        }else {
            throw new Exception("No existe el profesor que se desea eliminar");
        }
    }

    @Override
    public ProfesorOutputDto modifyProfesor(int id, ProfesorInputDto profesorInputDto) {
        Profesor profesor = profesorRepository.findById(id);
        Profesor profesorInput = profesorInputDto.profesor();

        if (profesorInput.getComents() != null){
            profesor.setComents(profesorInput.getComents());
        }
        if (profesorInput.getBranch() != null){
            profesor.setBranch(profesorInput.getBranch());
        }
        if (profesorInput.getPersona() != null){
            profesor.setPersona(profesorInput.getPersona());
        }

        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(profesor);

        profesorRepository.save(profesor);

        return profesorOutputDto;
    }

}
