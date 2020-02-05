/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services.impl;

import project.dto.User;
import project.jdbc.UserDaoImpl;
import web.services.UserService;

/**
 *
 * @author Incognito
 */
public class UserServiceImpl implements UserService{

    @Override
    public boolean existingUser(User dto) throws Exception {
        
        UserDaoImpl dao = new UserDaoImpl();
        User  user= dao.dynamicWhere(dto);
        
        if (user != null){
            return true;
        }
        
        return false;
    }
    
}
