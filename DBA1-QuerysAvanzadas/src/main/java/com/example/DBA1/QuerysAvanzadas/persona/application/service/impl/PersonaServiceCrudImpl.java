package com.example.DBA1.QuerysAvanzadas.persona.application.service.impl;

import com.example.DBA1.QuerysAvanzadas.persona.application.service.interfaz.PersonaCrudService;
import com.example.DBA1.QuerysAvanzadas.persona.domain.dto.input.PersonaInputDto;
import com.example.DBA1.QuerysAvanzadas.persona.domain.dto.output.PersonaOutputDto;
import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import com.example.DBA1.QuerysAvanzadas.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceCrudImpl implements PersonaCrudService {

    @Autowired
    private PersonaRepository personaRepository;

    private PersonaOutputDto converToDto(Persona persona){
        return new PersonaOutputDto(persona);
    }

    //Mostrar todas las personas
    public List<PersonaOutputDto> getAll(){
        List<Persona> personas = personaRepository.findAll();
        return personas
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    //Aniadir personas
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception {
        PersonaOutputDto personaOutputDto = new PersonaOutputDto(personaInputDto.persona());
        if(personaInputDto.persona().getUsuario().length() > 4){
            personaRepository.save(personaInputDto.persona());
            return personaOutputDto;
        }else {
            throw new Exception("Datos invalidos para aniadir a esta persona");
        }
    }

    //Borrar personas
    public PersonaOutputDto deletePersona(int id) throws Exception {
        PersonaOutputDto personaOutputDto = new PersonaOutputDto(personaRepository.findById(id));
        if(personaRepository.findById(id) != null){
            personaRepository.deleteById(id);
            return personaOutputDto;
        }else {
            throw new Exception("No existe el usuario que se desea eliminar");
        }
    }

    //Modificar personas
    public PersonaOutputDto modifyPersona(int id, PersonaInputDto personaInputDto){
        Persona persona = personaRepository.findById(id);
        Persona personaInput = personaInputDto.persona();

        if (personaInput.getUsuario() != null  && personaInput.getName().length() >= 5){
            persona.setUsuario(personaInputDto.getUsuario());
        }
        if(personaInput.getPassword() != null){
            persona.setPassword(personaInputDto.getPassword());
        }
        if(personaInput.getName() != null){
            persona.setName(personaInputDto.getName());
        }
        if(personaInput.getSurname() != null){
            persona.setSurname(personaInputDto.getSurname());
        }
        if(personaInput.getCompany_email() != null){
            persona.setCompany_email(personaInputDto.getCompany_email());
        }
        if(personaInput.getPersonal_email() != null){
            persona.setPersonal_email(personaInputDto.getPersonal_email());
        }
        if(personaInput.getCity() != null){
            persona.setCity(personaInputDto.getCity());
        }
        if(personaInput.getActive() != null){
            persona.setActive(personaInputDto.getActive());
        }
        if(personaInput.getCreated_date() != null){
            persona.setCreated_date(personaInputDto.getCreated_date());
        }
        if(personaInput.getImagen_url() != null){
            persona.setImagen_url(personaInputDto.getImagen_url());
        }
        if(personaInput.getTermination_date() != null){
            persona.setTermination_date(personaInputDto.getTermination_date());
        }

        PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);

        personaRepository.save(persona);

        return personaOutputDto;
    }

}
