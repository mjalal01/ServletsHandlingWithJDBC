/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import project.dto.User;

/**
 *
 * @author Incognito
 */
public interface UserDao {
    
    //insert
    public void insert (User dto) throws Exception;
    
    //for generating autoincremented pk
    public Integer getLastId() throws Exception;
    
    public User dynamicWhere(User dto) throws Exception;
    
    //No need for implementing update delete or select 
    //In personImplementation they were just for handling jdbc
}
