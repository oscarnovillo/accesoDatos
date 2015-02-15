/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.j2ee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.ObjectMapper;
import quevedo.library.Test;

/**
 *
 * @author oscar
 */
public class TestServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    if (session ==null) 
      session = request.getSession(true);
    
    ArrayList<Test> tests = new ArrayList();
    
    tests.add(new Test(1,"nn"));
    tests.add(new Test(2,"nen"));
    tests.add(new Test(3,"nan"));
    tests.add(new Test(4,"non"));
    
    
    request.setAttribute("tests", tests);
    
    
    if (request.getParameter("json")==null)
      request.getRequestDispatcher("newjsp.jsp").forward(request, response);
    else
    {
      response.setContentType("application/json");
         
    Test test= (Test)session.getAttribute("test");
    if (session.getAttribute("test")==null)
    {
     test= new Test(1,"nn");
      session.setAttribute("test", test);
    }
    test.setNum(test.getNum()+1);
    test.setNombre("test");
        // 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
 
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();
 
        // 3. Convert received JSON to Article
        //Article article = mapper.readValue(json, Article.class);
 
        // 4. Set response type to JSON
        response.setContentType("application/json");            
 
        // 5. Add article to List<Article>
        //articles.add(article);
 
        // 6. Send List<Article> as JSON to client
        response.addHeader("json", "1");
        mapper.writeValue(response.getOutputStream(), tests);
    }
    
    
    //esto ya no se ejecuta.
//    response.setContentType("text/html;charset=UTF-8");
//    try (PrintWriter out = response.getWriter()) {
//      /* TODO output your page here. You may use following sample code. */
//      out.println("<!DOCTYPE html>");
//      out.println("<html>");
//      out.println("<head>");
//      out.println("<title>Servlet TestServlet</title>");      
//      out.println("</head>");
//      out.println("<body>");
//      out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
//      for (String s : request.getParameterMap().keySet())
//      {
//
//        session.setAttribute(s,  request.getParameterMap().get(s)[0]+session.getAttribute(s));
//        out.println("<h1>Servlet TestServlet at " + s+" "+ request.getParameterMap().get(s)[0] + "</h1>");
//      }
//      response.addHeader("token","9999999");
//      out.println("<h1>Servlet TestServlet at " + session.getAttribute("pp") + "</h1>");
//      out.println("</body>");
//      out.println("</html>");
//    }
  }
  
  
  

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
