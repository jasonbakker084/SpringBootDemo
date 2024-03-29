/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1.service;

import com.example.demo1.dao.PersonDao;
import com.example.demo1.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author jasonbakker
 */
@Service
public class PersonService {
    
    private final PersonDao personDao;
    
@Autowired
    public PersonService(@Qualifier("postgres")PersonDao personDao) {
        this.personDao = personDao;
    }
                
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
    
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    
     public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
     
     public int deletePerson(UUID id) {
         return personDao.deletePersonById(id);
     }
     
     public int updatePerson(UUID id, Person newPerson) {
         return personDao.updatPersonById(id, newPerson);
     }
}
