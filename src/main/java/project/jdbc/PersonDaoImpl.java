/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.jdbc;

import java.sql.*;
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
    protected final String SQL_UPDATE="";
    protected final String SQL_DELETE="";
    protected final String SQL_SELECT="";
    
    
    
    
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
    
    
        protected void reset(Person dto) {
    }
}
