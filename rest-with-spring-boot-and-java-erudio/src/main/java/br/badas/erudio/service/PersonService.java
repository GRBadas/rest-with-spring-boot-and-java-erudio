package br.badas.erudio.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.badas.erudio.exception.ResourceNotFoundException;
import br.badas.erudio.model.Person;
import br.badas.erudio.repository.PersonRepository;

@Service
public class PersonService {

  private Logger logger = Logger.getLogger(PersonService.class.getName());
  
  @Autowired
  PersonRepository repository;

  public Person findById(Long id) {
    logger.info("Finding one Person");
    return repository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
  }

  public List<Person> findAll(){
    logger.info("retornando todas as pessoas");
     return repository.findAll();
  }
  
  public Person addPerson(Person person) {
    logger.info("Adding new person");

    return repository.save(person);
  } 

  public Person updatePerson(Person person) {

    logger.info("Editing person data");
    Person entity = repository.findById(person.getId())
    .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());

    return repository.save(person);
  }

  public void deletePerson(Long id){

    logger.info("Editing person data");
    Person entity = repository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
    repository.delete(entity);

  }
}
