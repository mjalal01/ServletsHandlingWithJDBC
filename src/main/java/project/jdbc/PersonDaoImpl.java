/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.jdbc;

import java.sql.Connection;
import project.dao.PersonDao;
import project.dto.Person;
import project.dto.PersonPk;

/**
 *
 * @author Incognito
 */
public class PersonDaoImpl implements PersonDao{

    private java.sql.Connection userConn;

    
    @Override
    public PersonPk insert(Person dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonPk update(PersonPk pk, Person dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonPk delete(PersonPk pk) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person[] select() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Connection getUserConn() {
        return userConn;
    }

    @Override
    public void setUserConn(Connection userConn) {
        this.userConn = userConn;
    }
    
}
