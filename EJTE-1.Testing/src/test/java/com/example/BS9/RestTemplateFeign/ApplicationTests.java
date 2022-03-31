package com.example.BS9.RestTemplateFeign;

import com.example.BS9.RestTemplateFeign.persona.application.service.interfaz.PersonaCrudService;
import com.example.BS9.RestTemplateFeign.persona.application.service.interfaz.PersonaService;
import com.example.BS9.RestTemplateFeign.persona.domain.dto.input.PersonaInputDto;
import com.example.BS9.RestTemplateFeign.persona.domain.dto.output.PersonaOutputDto;
import com.example.BS9.RestTemplateFeign.persona.domain.entity.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {

	@Autowired
	PersonaCrudService personaCrudService;

	@Autowired
	PersonaService personaService;

	PersonaInputDto InputBueno = new PersonaInputDto(
			1,
			"Adrian",
			"a1234",
			"Adrian",
			"Mosquera",
			"aaa@bbb.com",
			"aaa@bbb.com",
			"Logrono",
			true,
			"1-1-1",
			"aaaaa",
			"1-1-1"
	);

	PersonaInputDto InputMalo = new PersonaInputDto(
			2,
			"Adr",
			"a1234",
			"Adrian",
			"Mosquera",
			"aaa@bbb.com",
			"aaa@bbb.com",
			"Logrono",
			true,
			"1-1-1",
			"aaaaa",
			"1-1-1"
	);

	@Test
	@DisplayName("Test add Persona")
	public void addPersonaTest() throws Exception {
		PersonaOutputDto personaEsperada = new PersonaOutputDto(InputBueno.persona());
		PersonaOutputDto personaNueva = personaCrudService.addPersona(InputBueno);
		Assertions.assertEquals(personaEsperada, personaNueva);
	}

	@Test
	@DisplayName("Test add Persona, comprobación de error")
	public void addPersonaFailTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {personaCrudService.addPersona(InputMalo);});
	}

	@Test
	@DisplayName("Test delete Persona")
	public void deletePersonaTest() throws Exception {
		PersonaOutputDto personaNueva = personaCrudService.addPersona(InputBueno);
		personaCrudService.deletePersona(personaNueva.getId_persona());
	}

	@Test
	@DisplayName("Test delete Persona, comprobación de error")
	public void deletePersonaFailTest() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			PersonaOutputDto personaNueva = personaCrudService.addPersona(InputBueno);
			personaCrudService.deletePersona(0);
		});
	}

	@Test
	@DisplayName("Test update Persona")
	 public void updatePersonaTest() throws Exception {
		PersonaOutputDto personaSinModificar = personaCrudService.addPersona(InputBueno);

		PersonaInputDto personaModificar = new PersonaInputDto(
				2,
				"Pedros",
				"a1234",
				"Pedros",
				"Mosquera",
				"aaa@bbb.com",
				"aaa@bbb.com",
				"Logrono",
				true,
				"1-1-1",
				"aaaaa",
				"1-1-1"
		);

		Assertions.assertNotEquals(personaSinModificar, personaCrudService.modifyPersona(personaSinModificar.getId_persona(), personaModificar));
	 }

	@Test
	@DisplayName("Test update Persona, comprobación de error")
	public void updatePersonaFailTest() throws Exception {

		Assertions.assertThrows(Exception.class, () -> {

			PersonaOutputDto personaSinModificar = personaCrudService.addPersona(InputBueno);

			PersonaInputDto personaModificar = new PersonaInputDto(
					2,
					"Ped",
					"a1234",
					"Ped",
					"Mosquera",
					"aaa@bbb.com",
					"aaa@bbb.com",
					"Logrono",
					true,
					"1-1-1",
					"aaaaa",
					"1-1-1"
			);

			personaCrudService.modifyPersona(personaSinModificar.getId_persona(), personaModificar);
		});
	}

	@Test
	@DisplayName("Test findAll Personas")
	public void findAllPersonas(){
		personaCrudService.getAll();
	}

	@Test
	@DisplayName("findId Persona")
	public void findByIdPersona() throws Exception {
		PersonaOutputDto personaBuscar = personaCrudService.addPersona(InputBueno);

		personaService.buscarPorId(personaBuscar.getId_persona());
	}

	@Test
	@DisplayName("findId Persona, comprobación de error")
	public void findByIdFailPersona() throws Exception {

		Assertions.assertThrows(Exception.class, () -> {
			PersonaOutputDto personaBuscar = personaCrudService.addPersona(InputBueno);

			personaService.buscarPorId(0);
		});
	}

}