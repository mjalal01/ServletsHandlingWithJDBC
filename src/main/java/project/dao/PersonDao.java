/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import java.sql.Connection;
import java.util.ArrayList;
import project.dto.Person;
import project.dto.PersonPk;

/**
 *
 * @author Incognito
 */
public interface PersonDao {
    
    //insert
    public void insert (Person dto) throws Exception;
    
    //update
    public void update(PersonPk pk, Person dto) throws Exception;
    //delete
    
    public void delete(PersonPk pk) throws Exception;
    //select
    
    public ArrayList select () throws Exception;
    
    //Take the last integer for generating new Primary Key
    public Integer getLastId() throws Exception;
    
    public Connection getUserConn();

    public void setUserConn(Connection userConn);
    
}
