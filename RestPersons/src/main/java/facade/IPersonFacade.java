/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Persons;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author vfgya_000
 */
public interface IPersonFacade {
  public void addEntityManagerFactory(EntityManagerFactory emf);
  public Persons addPerson(Persons p);  
  public Persons deletePerson(int id);  
  public Persons getPerson(int id);  
  public List<Persons> getPersons();
  public Persons editPerson(Persons p);  
}

