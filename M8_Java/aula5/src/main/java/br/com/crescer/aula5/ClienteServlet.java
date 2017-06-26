/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathias.ody
 */
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<String> nomes = new HashSet<String>();

        resp.setContentType("text/html");
        try (final PrintWriter out = resp.getWriter();) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<h1>Cliente</h1>");
            out.append("<form>");
            //for ()
            out.append("</body>");
            out.append("</html>");
        }
        
        /*try (final PrintWriter out = resp.getWriter();) {
            out.append("MATHIAS");
            out.Write
        }*/
        
        //super.doGet(req, resp);
    }
    
}
