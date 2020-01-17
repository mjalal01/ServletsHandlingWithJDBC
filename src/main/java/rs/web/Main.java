/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.web;

import project.dto.Person;
import project.jdbc.PersonDaoImpl;
import project.jdbc.ResourceManager;

/**
 *
 * @author Incognito
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        PersonDaoImpl p = new PersonDaoImpl();
        
        Person person = new Person();
        
        person.setPersonId(1);
        person.setFirst_name("Jalal");
        person.setLast_name("Mekhtiyev");
        person.setBirth("01.01.2000");
        person.setGender("M");
        person.setPhone("+994507991228");
        person.setEmail("djalal@gmail.com");
        
        p.insert(person);
        
    }
    
}
