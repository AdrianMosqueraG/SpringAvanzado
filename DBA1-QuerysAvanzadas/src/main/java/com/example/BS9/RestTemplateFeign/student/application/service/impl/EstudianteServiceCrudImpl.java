package com.example.BS9.RestTemplateFeign.student.application.service.impl;

import com.example.BS9.RestTemplateFeign.student.application.service.interfaz.EstudianteCrudService;
import com.example.BS9.RestTemplateFeign.student.domain.dto.input.EstudianteInputDto;
import com.example.BS9.RestTemplateFeign.student.domain.dto.output.EstudianteOutputDto;
import com.example.BS9.RestTemplateFeign.student.domain.entity.Estudiante;
import com.example.BS9.RestTemplateFeign.student.infrastructure.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceCrudImpl implements EstudianteCrudService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    private EstudianteOutputDto converToDto(Estudiante estudiante){
        return new EstudianteOutputDto(estudiante);
    }

    @Override
    public List<EstudianteOutputDto> getAll() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) throws Exception {
        EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto(estudianteInputDto.estudiante());
        if(estudianteInputDto.estudiante().getName().length() > 0){
            estudianteRepository.save(estudianteInputDto.estudiante());
            return estudianteOutputDto;
        }else {
            throw new Exception("Datos invalidos para aniadir a este estudiante");
        }
    }

    @Override
    public EstudianteOutputDto deleteEstudiante(int id) throws Exception {
        EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto(estudianteRepository.findById(id));
        if(estudianteRepository.findById(id) != null){
            estudianteRepository.deleteById(id);
            return estudianteOutputDto;
        }else {
            throw new Exception("No existe el estudiante que se desea eliminar");
        }
    }

    @Override
    public EstudianteOutputDto modifyEstudiante(int id, EstudianteInputDto estudianteInputDto) {
        Estudiante estudiante = estudianteRepository.findById(id);
        Estudiante estudianteInput = estudianteInputDto.estudiante();

        if (estudianteInput.getName() != null){
            estudiante.setName(estudianteInput.getName());
        }
        if (estudianteInput.getNum_hours_week() != null){
            estudiante.setNum_hours_week(estudianteInput.getNum_hours_week());
        }
        if (estudianteInput.getComents() != null){
            estudiante.setComents(estudianteInput.getComents());
        }
        if (estudianteInput.getBranch() != null){
            estudiante.setBranch(estudianteInput.getBranch());
        }
        if (estudianteInput.getPersona() != null){
            estudiante.setPersona(estudianteInput.getPersona());
        }
        if (estudianteInput.getProfesor() != null){
            estudiante.setProfesor(estudianteInput.getProfesor());
        }
        if (estudianteInput.getAsignaturas() != null){
            estudiante.setAsignaturas(estudianteInput.getAsignaturas());
        }

        EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto(estudiante);

        estudianteRepository.save(estudiante);

        return estudianteOutputDto;
    }
}
