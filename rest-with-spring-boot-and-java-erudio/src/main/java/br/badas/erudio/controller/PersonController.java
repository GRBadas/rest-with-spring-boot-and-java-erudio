package br.badas.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.badas.erudio.model.Person;
import br.badas.erudio.service.PersonService;

@RestController
public class PersonController {

  @Autowired
  private PersonService service;

  @RequestMapping(value = "api/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Person findById(@PathVariable("id") Long id){
    return service.findById(id);
  }

  @RequestMapping(value = "api/person/peoplelist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> findAllPeople(){
    return service.findAll();
  }

  @PostMapping(value = "api/person/addperson", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Person addNewPerson(@RequestBody Person person){
    return service.addPerson(person);
  }
  
  @PutMapping(value = "api/person/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Person editPerson(@RequestBody Person person ) {
    return service.updatePerson(person);
  }

  @DeleteMapping(value = "api/person/delete/{id}")
  public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
    service.deletePerson(id);
    return ResponseEntity.noContent().build();
  }

}
