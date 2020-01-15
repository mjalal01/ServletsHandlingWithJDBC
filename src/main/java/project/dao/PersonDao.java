/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import java.sql.Connection;
import project.dto.Person;
import project.dto.PersonPk;

/**
 *
 * @author Incognito
 */
public interface PersonDao {
    
    //insert
    public PersonPk insert (Person dto) throws Exception;
    
    //update
    public PersonPk update(PersonPk pk, Person dto) throws Exception;
    //delete
    
    public PersonPk delete(PersonPk pk) throws Exception;
    //select
    
    public Person[] select () throws Exception;
    
    
    public Connection getUserConn();

    public void setUserConn(Connection userConn);
    
}
