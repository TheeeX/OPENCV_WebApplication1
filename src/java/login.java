import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String n=request.getParameter("userName");  
            String p=request.getParameter("userPass");  
            out.println("<h1>Servlet ServletTest1 at " + request.getContextPath() + "</h1>");
             if(p.equals("aaa")){
                RequestDispatcher rd=request.getRequestDispatcher("test");  
                rd.forward(request, response);
            }
            else if(p.equals("qqq")){
                out.print("<h1>Welcome </h1><h2>"+n+"</h2>"); 
                RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
                rd.forward(request, response);
            }
            else{
                out.print("Sorry UserName or Password Error!");  
                RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
                rd.include(request, response);  
                      
            }  
        }
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
