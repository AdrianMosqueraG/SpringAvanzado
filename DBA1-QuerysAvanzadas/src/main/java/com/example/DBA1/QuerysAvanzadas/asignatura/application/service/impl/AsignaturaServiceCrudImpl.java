package com.example.DBA1.QuerysAvanzadas.asignatura.application.service.impl;

import com.example.DBA1.QuerysAvanzadas.asignatura.application.service.interfaz.AsignaturaCrudService;
import com.example.DBA1.QuerysAvanzadas.asignatura.domain.dto.input.AsignaturaInputDto;
import com.example.DBA1.QuerysAvanzadas.asignatura.domain.dto.output.AsignaturaOutputDto;
import com.example.DBA1.QuerysAvanzadas.asignatura.domain.entity.Asignatura;
import com.example.DBA1.QuerysAvanzadas.asignatura.infrastructure.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceCrudImpl implements AsignaturaCrudService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    private AsignaturaOutputDto converToDto(Asignatura asignatura){return new AsignaturaOutputDto(asignatura);}

    @Override
    public List<AsignaturaOutputDto> getAll() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        return asignaturas
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) throws Exception {
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto(asignaturaInputDto.asignatura());
        if(asignaturaInputDto.asignatura().getAsignatura().length() > 0){
            asignaturaRepository.save(asignaturaInputDto.asignatura());
            return asignaturaOutputDto;
        }else {
            throw new Exception("Datos invalidos para aniadir esta asignatura");
        }
    }

    @Override
    public AsignaturaOutputDto deleteAsignatura(int id) throws Exception {
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto(asignaturaRepository.findById(id));
        if(asignaturaRepository.findById(id) != null){
            asignaturaRepository.deleteById(id);
            return asignaturaOutputDto;
        }else {
            throw new Exception("No existe la asignatura que se desea eliminar");
        }
    }

    @Override
    public AsignaturaOutputDto modifyAsignatura(int id, AsignaturaInputDto asignaturaInputDto) {
        Asignatura asignatura = asignaturaRepository.findById(id);
        Asignatura asignaturaInput = asignaturaInputDto.asignatura();

        if (asignaturaInput.getAsignatura() != null){
            asignatura.setAsignatura(asignaturaInput.getAsignatura());
        }
        if (asignaturaInput.getComment() != null){
            asignatura.setComment(asignaturaInput.getComment());
        }
        if (asignaturaInput.getInitial_date() != null){
            asignatura.setInitial_date(asignaturaInput.getInitial_date());
        }
        if (asignaturaInput.getFinish_date() != null){
            asignatura.setFinish_date(asignaturaInput.getFinish_date());
        }
        if (asignaturaInput.getEstudiantes() != null){
            asignatura.setEstudiantes(asignaturaInput.getEstudiantes());
        }

        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto(asignatura);

        asignaturaRepository.save(asignatura);

        return asignaturaOutputDto;
    }
}
