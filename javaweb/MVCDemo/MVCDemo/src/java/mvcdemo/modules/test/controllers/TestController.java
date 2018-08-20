/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcdemo.modules.test.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcdemo.Film;
import mvcdemo.FilmHelper;

/**
 *
 * @author soderayi
 */
public class TestController extends HttpServlet {
    
    public TestController(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        FilmHelper filmHelper = new FilmHelper();
        FilmHelper filmHelper2 = new FilmHelper();
        //Film film = filmHelper2.getFilmByID( 7 );
        List filmList = filmHelper.getFilmTitles(1,5);
        req.setAttribute("filmList", filmList);
//        req.setAttribute("film", film);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/test.jsp");
        dispatcher.forward(req, resp);       
    }
    
}
