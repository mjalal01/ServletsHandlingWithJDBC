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
public class UserPk {
    
    protected int idUser;

    public UserPk(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "UserPk{" + "idUser=" + idUser + '}';
    }
    
    
    
}
