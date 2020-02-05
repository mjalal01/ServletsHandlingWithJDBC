/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dto;

/**
 *
 * @author Incognito
 */
public class User {
    
    //The columns of the table
    protected Integer userId;
    protected String login;
    protected String password;
    protected Integer personId;
    
    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + 
                ", login=" + login + 
                ", password=" + password + 
                ", personId=" + personId + '}';
    }
    
    
}
