/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import serviceImp.PersonServiceImp;

@ManagedBean
@SessionScoped
public class PersonController {

    private Person person;
      private Person personView;
    private List<Person> persons;
    private PersonServiceImp personService = new PersonServiceImp();

  public String viewPerson(){
       // personView = new Person();
     //   personView = personService.getPersonById(id);    
        return "/view.xhtml?faces-redirect=true";  
    }
    
    public void save() {
        personService.save(person);
        System.out.println("Student saved");
    }

    public Person getPerson() {

        if (person == null) {
            person = new Person();
        }
        return person;
    }

    public void setStudent(Person person) {
        this.person = person;
    }

    public List<Person> getPersons() {
        persons = new ArrayList();
        persons = personService.getPersonList();
        System.out.println("Person Size: "+persons.size());
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    

    public void setStudents(List<Person> persons) {
        this.persons = persons;
    }

    public PersonServiceImp getPersonService() {
        return personService;
    }

    public void setPersonService(PersonServiceImp personService) {
        this.personService = personService;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPersonView() {        
        return personView;
    }

    public void setPersonView(Person personView) {
        this.personView = personView;
    }
    
     public void deletePerson(Person person) {
        personService.deletePerswon(person);
    }
    
    

}
