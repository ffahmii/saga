/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

<<<<<<< HEAD

=======
import com.saga.DBLog;
<<<<<<< HEAD
import com.saga.DBSaga_Client;
=======
import com.saga.Database;
>>>>>>> 85858baee65ceb44de0366e6d2e4022fa2c2fc61
>>>>>>> origin/master
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fahmi
 */
@WebServlet(urlPatterns = {"/pembelian"})
public class pembelian extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idGame = request.getParameter("gameId");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String username = request.getParameter("username");
        String item = request.getParameter("item");
        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
<<<<<<< HEAD
        String date = dmyFormat.format(myDate) + " " + hours + ":" + minutes + ":" + seconds;

=======
        String date = dmyFormat.format(myDate) + " " + hours+":"+minutes+":"+seconds;
        
<<<<<<< HEAD
=======
>>>>>>> origin/master
        DBLog db = new DBLog();
        out.print("Add to log user  = " + db.addLog(username, idGame, date, item, amount));

        DBSaga_Client dbClient = new DBSaga_Client();
        dbClient.chargeCard(idGame, username, amount);
        response.sendRedirect("gundule.jsp");
>>>>>>> 85858baee65ceb44de0366e6d2e4022fa2c2fc61
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
