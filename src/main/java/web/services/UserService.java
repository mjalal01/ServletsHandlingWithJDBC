/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import project.dto.User;

/**
 *
 * @author Incognito
 */
public interface UserService {
    
    public boolean existingUser(User dto) throws Exception;
    
}
