/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.web;

import java.util.ArrayList;
import project.dto.Person;
import project.dto.PersonPk;
import project.jdbc.PersonDaoImpl;

/**
 *
 * @author Incognito
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
       
       
        PersonDaoImpl p = new PersonDaoImpl();
        
        Person person = new Person();
        PersonPk pk = new PersonPk();
        
        pk.setPersonId(2);
        person.setFirst_name("");
        person.setLast_name("");
        person.setBirth("");
        person.setGender("M");
        person.setPhone("+99450457");
        person.setEmail("sayyad@gmail.com");
        
        System.out.println(pk.toString());
       
       
       
       
    }
    
}
