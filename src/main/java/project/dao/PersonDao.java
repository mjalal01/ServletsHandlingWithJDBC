/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import java.sql.Connection;
import java.util.ArrayList;
import project.dto.Person;

/**
 *
 * @author Incognito
 */
public interface PersonDao {
    
    //insert
    public void insert (Person dto) throws Exception;
    
    //update
    public void update( Person dto) throws Exception;
    //delete
    
    public void delete(Person dto) throws Exception;
    //select
    
    public ArrayList select () throws Exception;
    
        //Method for finding the last pk int table
    //For generating new ids
    public Integer getLastId() throws Exception;
    
    public Connection getUserConn();

    public void setUserConn(Connection userConn);
    
}
