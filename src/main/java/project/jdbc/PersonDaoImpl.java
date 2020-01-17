/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.jdbc;

import java.sql.*;
import java.util.ArrayList;
import project.dao.PersonDao;
import project.dto.Person;
import project.dto.PersonPk;

/**
 *
 * @author Incognito
 */
public class PersonDaoImpl implements PersonDao{

    private java.sql.Connection userConn;

    
    //sql DML statements
    protected final String SQL_INSERT="insert into "+getTableName()+
            " (person_id,first_name,last_name,birth,gender,email,phone) "+
            "values(?,?,?,?,?,?,?)";
    
    protected final String SQL_UPDATE="update persons set first_name=?,"
            + "last_name=?,"
            + "birth=?,gender=?,email=?,phone=? where person_id=?";
    
    protected final String SQL_DELETE="delete from persons where person_id=?";
    
    protected final String SQL_SELECT="select * from persons";
    
    
    
    
    public String getTableName(){
        return "persons";
    }
    
    @Override
    public PersonPk insert(Person dto) throws Exception {
        
        final boolean isConnSupplied = (userConn != null);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            String genereatedColumns[] = {"person_id"};
            stmt=conn.prepareStatement(SQL_INSERT, genereatedColumns);
            int index=1;
            if (dto.getPersonId() != null) {
                stmt.setInt(index++, dto.getPersonId().intValue());
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            stmt.setString(index++,dto.getFirst_name());
            stmt.setString(index++,dto.getLast_name());
            stmt.setString(index++,dto.getBirth());
            stmt.setString(index++,dto.getGender());
            stmt.setString(index++,dto.getEmail());
            stmt.setString(index++,dto.getPhone());
            
            stmt.executeUpdate();
            
            // retrieve values from auto-increment columns
            rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                dto.setPersonId(new Integer(rs.getInt(1)));
            }

            reset(dto);
            return dto.createPk();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("smth went wrong");
        }finally{
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }
        }
        
    }

    @Override
    public void update(PersonPk pk, Person dto) throws Exception {
        final boolean isConnSupplied = (userConn != null);

        Connection conn = null;
        PreparedStatement stmt = null;    
        
        try{
            
            conn=isConnSupplied ? userConn : ResourceManager.getConnection();
            stmt=conn.prepareStatement(SQL_UPDATE);
            
            int index = 1;//Setting up the Updating values
            stmt.setString(index++, dto.getFirst_name());
            stmt.setString(index++, dto.getLast_name());
            stmt.setString(index++, dto.getBirth());
            stmt.setString(index++, dto.getGender());
            stmt.setString(index++, dto.getEmail());
            stmt.setString(index++, dto.getPhone());
            
            //Setting The primary key of the object which should be updated
            stmt.setInt(index, pk.getPersonId());
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Update Was Not successful");
        }finally{
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }
        }
    }

    @Override
    public void delete(PersonPk pk) throws Exception {
        final boolean isConnSupplied = (userConn != null);

        Connection conn = null;
        PreparedStatement stmt = null;    
        
        try{
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            stmt = conn.prepareStatement(SQL_DELETE);
             int index=1;
            stmt.setInt(index , pk.getPersonId());
            stmt.executeUpdate();
            
        }catch(Exception e){
            throw new Exception("Deleting was unsuccessfull");
        }finally{
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }
        }
        
    }

    @Override
    public ArrayList select() throws Exception {
        final boolean isConnSupplied = (userConn != null);

        ArrayList persons =  new ArrayList();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Person person = null;
        try{
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                 person = new Person();
                person.setPersonId(new Integer(rs.getInt(1)));
                person.setFirst_name(rs.getString(2));
                person.setLast_name(rs.getString(3));
                person.setBirth(rs.getString(4));
                person.setGender(rs.getString(5));
                person.setEmail(rs.getString(6));
                person.setPhone(rs.getString(7));
                persons.add(person);
            }
            return persons;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }
        }
        return persons;
    }

    @Override
    public Connection getUserConn() {
        return userConn;
    }

    @Override
    public void setUserConn(Connection userConn) {
        this.userConn = userConn;
    }
    
    
        protected void reset(Person dto) {
    }
}
