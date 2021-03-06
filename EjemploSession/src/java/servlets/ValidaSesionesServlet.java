/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidaSesionesServlet extends HttpServlet {
   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

      response.setContentType("text/html");
      HttpSession sesion = request.getSession();
      String titulo = null;

      //Pedimos el atributo, y verificamos si existe
      String claveSesion = (String) sesion.getAttribute("claveSesion");

      if(claveSesion.equals("rodrigosanchez")){
        try(PrintWriter out=response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Good</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Sesion valida</h1></center>");
            out.println("<center><h1>Rodrigo Sanchez</h1></center>");
            out.println("<center><img src='gato.jpg'></center>");
            out.println("</body>");
            out.println("</html>");
        }
      }
      else
      {
          try(PrintWriter out=response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Sesion Erronea</h1></center>");
            out.println("<center><h1>Rodrigo Sanchez</h1></center>");
            out.println("</body>");
            out.println("</html>");
        }
      }


      //Mostramos los  valores en el cliente
      PrintWriter out = response.getWriter();
      out.println("¿Continua la Sesion y es valida?: " + titulo);
      out.println("<br>");
      out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());
  
    }

}
