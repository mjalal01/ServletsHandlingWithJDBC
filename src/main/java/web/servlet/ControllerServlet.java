/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import project.dto.Person;
import project.dto.User;
import project.jdbc.PersonDaoImpl;
import project.jdbc.UserDaoImpl;
import web.services.impl.UserServiceImpl;

/**
 *
 * @author Incognito
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet{

    //This method used for redirecting to other methods
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws Exception{
        
        String action = request.getParameter("action");
        if(action.equals("addUser")){
            this.addUser(request,response);
        }else if(action.equals("validateUser")){
            this.validateUser(request, response);
        }else if(action.equals("contact")){
            
        }
    }
    
    //Did not use in my project 
    //But this method is one of the ways 
    //to check if the user has already logged in
    //Other methods using cookies,tokens an so on
    protected void confirmSession(HttpServletRequest request, HttpServletResponse response){
        
        try{
            HttpSession session = request.getSession();
            String login = (String) session.getAttribute("login");
            
            if(login == null){
                
                request.getRequestDispatcher("/Pages/Contact.html").forward(request, response);
            }else {
                
                request.getRequestDispatcher("/index.html").forward(request, response);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
    }
    
    //Validating user in loggining
    //Redirecting to home page if it is okay
    //If user not registered stay at the login page
    protected void validateUser(HttpServletRequest req,  HttpServletResponse res) throws Exception{
        
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        
        User dao = new User();
        dao.setLogin(email);
        dao.setPassword(pass);
        
        UserServiceImpl user = new UserServiceImpl();
        //For checking if user is registered
        if(user.existingUser(dao)){
            HttpSession session = req.getSession();
            session.setAttribute("login", dao.getLogin());
            session.setAttribute("pass", dao.getPassword());
            
            req.getRequestDispatcher("/Pages/Home.html").forward(req, res);
        }else{
            
            req.getRequestDispatcher("/index.html").forward(req, res);
        }
        
    }
    
    
    //Adding user to the database
    protected void addUser(HttpServletRequest request, HttpServletResponse response){
        
        try{
            PersonDaoImpl perInsert =  new PersonDaoImpl();
            UserDaoImpl userInsert = new UserDaoImpl();
            
            Person person = new Person();
            person.setFirst_name(request.getParameter("first_name"));
            person.setLast_name(request.getParameter("last_name"));
            person.setBirth(request.getParameter("birthday"));
            person.setEmail(request.getParameter("email"));
            person.setGender(request.getParameter("gender"));
            person.setPhone(request.getParameter("phone"));
            person.setPassword(request.getParameter("pass"));
            
            perInsert.insert(person);
            
            User user = new User();
            user.setLogin(person.getEmail());
            user.setPassword(person.getPassword());
            user.setPersonId(perInsert.getLastId());
            
            userInsert.insert(user);
            
            
            request.getRequestDispatcher("/Pages/Home.html").forward(request, response);
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        try {
            this.processRequest(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
