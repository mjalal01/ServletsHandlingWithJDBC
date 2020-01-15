/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import project.dto.User;
import project.dto.UserPk;

/**
 *
 * @author Incognito
 */
public interface UserDao {
    
    //insert
    public UserPk insert (User dto) throws Exception;
    
    //update 
    public UserPk update (UserPk pk, User dto) throws Exception;
    
    //delete
    public UserPk delete (UserPk pk) throws Exception;
    
    //select
    public User[] select () throws Exception;
    
}
