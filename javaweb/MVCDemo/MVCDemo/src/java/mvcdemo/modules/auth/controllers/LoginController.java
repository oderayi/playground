/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcdemo.modules.auth.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcdemo.modules.auth.models.Authenticator;
import mvcdemo.modules.auth.models.User;

/**
 *
 * @author soderayi
 */
public class LoginController extends HttpServlet {
    
    public LoginController(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        RequestDispatcher dispatcher;
        
        Authenticator authenticator = new Authenticator();
        String result = authenticator.authenticate( username, password );
        if ( result.equals("success") ){
            dispatcher = req.getRequestDispatcher("/success.jsp");
            User user = new User( username, password );
            req.setAttribute( "user", user );
        } else {
            dispatcher = req.getRequestDispatcher("/error.jsp");
        }
        dispatcher.forward( req, resp );
    }   
}
