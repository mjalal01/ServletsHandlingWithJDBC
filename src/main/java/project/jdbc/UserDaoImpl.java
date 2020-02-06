/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.jdbc;

import java.sql.*;
import project.dao.UserDao;
import project.dto.User;

/**
 *
 * @author Incognito
 */




public class UserDaoImpl implements UserDao{
    
    private java.sql.Connection userConn;
    
    protected final String SQL_INERT="insert into users(user_id,login,password,person_id)"
            + " values(?,?,?,?)";
    
    
    @Override
    public void insert(User dto) throws Exception {
        
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            /*  Because in Oracle database, generated columns 
            *   for the first column will get the rowid(Row key)
            *   here is the sollution for it
            *   Must mention that in mySQL there is no such thing :))
            * */
            String genereatedColumns[] = {"user_id"};
            stmt=conn.prepareStatement(SQL_INERT,genereatedColumns);
            int index=1;
            
            if(dto.getUserId() != null){
                
                stmt.setInt(index++, dto.getUserId());
            }else{
                
               UserDaoImpl lastId = new UserDaoImpl();
               int id=lastId.getLastId();
               stmt.setInt(index++, ++id);
            }
            
            stmt.setString(index++, dto.getLogin());
            stmt.setString(index++,dto.getPassword());
            stmt.setInt(index++, dto.getPersonId() );
            
            stmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }
        }
    }

    @Override
    public Integer getLastId() throws Exception {
        final boolean isConnSupplied=(userConn!=null); 
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer result= null;
        try{
            
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            String sql = "select user_id from users where rownum<2 order by user_id desc";
            
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                result=rs.getInt(1);
            }
            if(result == null){
                result=1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }
        }
        
        return result;
    }

    @Override
    public User dynamicWhere(User dto) throws Exception {
        final boolean isConnSupplied = (userConn!=null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User result = null;
        
        try{
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            String sql = "select distinct user_id from users where login=? and password=?";
            stmt=conn.prepareStatement(sql);
            
            stmt.setString(1, dto.getLogin());
            stmt.setString(2, dto.getPassword());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                result=new User();
                result.setLogin(rs.getNString(1));
                result.setPassword(rs.getNString(2));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }
        }
        return result;
    }
    
}
