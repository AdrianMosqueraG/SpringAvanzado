package com.example.BS9.RestTemplateFeign.profesor.application.service.interfaz;

import com.example.BS9.RestTemplateFeign.profesor.domain.dto.output.ProfesorOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorService {
    ProfesorOutputDto buscarPorId(int id) throws Exception;
    List<ProfesorOutputDto> buscarPorBranch(String branch);
}
