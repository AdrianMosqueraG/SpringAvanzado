package com.example.BS9.RestTemplateFeign.persona.infrastructure.controller;

import com.example.BS9.RestTemplateFeign.persona.application.service.interfaz.PersonaService;
import com.example.BS9.RestTemplateFeign.persona.domain.dto.output.PersonaOutputDto;
import com.example.BS9.RestTemplateFeign.persona.domain.entity.Persona;
import com.example.BS9.RestTemplateFeign.profesor.domain.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    EntityManager entityManager;

    @GetMapping("/getId/{id}")
    public PersonaOutputDto getId(@PathVariable int id) throws Exception{
        return personaService.buscarPorId(id);
    }

    @GetMapping("/getUser/{user}")
    public List<PersonaOutputDto> getUser(@PathVariable String user){
        return personaService.buscarPorUsuario(user);
    }




    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";


    @GetMapping("/get")
    public List<Persona> getData(@RequestParam(required=false,name="idCustomer") Integer idCustomer,
                                 @RequestParam(value="nameCustomer",required=false) String nameCustomer,
                                 @RequestParam(required=false) String addressCustomer,
                                 @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate, @RequestParam(required=false) String dateCondition			)
    {
        HashMap<String, Object> data=new HashMap<>();

        if (idCustomer!=null)
            data.put("id",idCustomer);
        if (nameCustomer!=null)
            data.put("name",nameCustomer);
        if (addressCustomer!=null)
            data.put("address",addressCustomer);
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        if (!dateCondition.equals(GREATER_THAN) && 	!dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition=GREATER_THAN;
        if (createdDate!=null)
        {
            data.put("created",createdDate);
            data.put("dateCondition",dateCondition);
        }

        return personaService.getData(data);

    }
    @GetMapping("/getQuery")
    public List<Persona> getDataQuery(@RequestParam(required=false,name="idCustomer") Integer idCustomer,
                                              @RequestParam(value="nameCustomer",required=false) String nameCustomer,
                                              @RequestParam(required=false) String addressCustomer,
                                              @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate,@RequestParam(required=false) String dateCondition			)
    {
        HashMap<String, Object> data=new HashMap<>();


        String sql="select e from CustomersEntity e where 1=1";

        if (idCustomer!=null)
            sql+=" and e.id = :idCustomer";
        if (nameCustomer!=null)
            sql+=" and e.name = :nameCustomer";
        if (addressCustomer!=null)
            sql+=" and e.address = :addressCustomer";
        String cond;
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        switch (dateCondition)
        {
            case GREATER_THAN:
                cond=">";
                break;
            case LESS_THAN:
                cond="<";
                break;
            default:
                cond="=";
        }

        if (createdDate!=null)
            sql+=" and e.created "+cond+" :createdDate";
        TypedQuery<Persona> query= entityManager.createQuery(sql,Persona.class);
        if (idCustomer!=null)
            query.setParameter("idCustomer", idCustomer);
        if (nameCustomer!=null)
            query.setParameter("nameCustomer", nameCustomer);

        if (addressCustomer!=null)
            query.setParameter("addressCustomer", addressCustomer);
        if (createdDate!=null)
            query.setParameter("createdDate", createdDate);
        return query.getResultList();

    }

}
