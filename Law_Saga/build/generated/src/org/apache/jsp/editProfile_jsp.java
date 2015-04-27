package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.saga.User;
import com.saga.Database;

public final class editProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"editprofilestyle.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Edit Profile</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if (session.getAttribute("sessionUser") == null) {
                response.sendRedirect("login.jsp?status=notLoggedIn");
                return;
            }
            Database db = new Database();
            String username = (String) session.getAttribute("sessionUser");
            User user = db.getUserDetail(username);

            if (request.getParameter("status") != null && request.getParameter("status").equals("success")) {
        
      out.write("\n");
      out.write("        <font color=\"red\">Profile Saved</font>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <form class=\"contact\" action=\"");
      out.print(response.encodeURL("ProfileServlet"));
      out.write("\" method=\"post\" >\n");
      out.write("            <input type=\"hidden\" name=\"username\" value=\"");
      out.print(user.getUsername());
      out.write("\"/>\n");
      out.write("            <p class=\"contact-input\">\n");
      out.write("                Username : <BOLD>");
      out.print(user.getUsername());
      out.write("</BOLD>\n");
      out.write("            </p>\n");
      out.write("            <p class=\"contact-input\">\n");
      out.write("                Password : <input type=\"text\" required id=\"password\" name=\"password\" value=");
      out.print(user.getPassword());
      out.write(" autofocus>\n");
      out.write("            </p>\n");
      out.write("            <p class=\"contact-input\">\n");
      out.write("                Email : <input type=\"text\" required id=\"email\" name=\"email\" value=");
      out.print(user.getEmail());
      out.write(" autofocus>\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p class=\"contact-input\">\n");
      out.write("                Credit Card Number : <input type=\"text\" id=\"CCN\" name=\"CCN\" type=\"number\" value=");
      out.print(user.getCCN());
      out.write(" autofocus>\n");
      out.write("            </p>\n");
      out.write("            <p class=\"contact-input\">\n");
      out.write("                Telephone : <input type=\"text\" id=\"tlp\" name=\"tlp\" required type=\"number\" value=");
      out.print(user.getTelp());
      out.write(" autofocus>\n");
      out.write("            </p>\n");
      out.write("            <p class=\"contact-input\">\n");
      out.write("                Addreses : <textarea id=\"alamat\" name=\"alamat\" required>");
      out.print(user.getAlamat());
      out.write(" </textarea>\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <p class=\"contact-submit\">\n");
      out.write("                <input type=\"submit\" value=\"Save\">\n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>   \n");
      out.write("            <CENTER>\n");
      out.write("                <form action=\"");
      out.print(response.encodeURL("home.jsp"));
      out.write("\" >\n");
      out.write("                    <p class=\"contact-submit\"><input type=\"submit\" name=\"back\" value=\"Back\"></p>\n");
      out.write("                </form>\n");
      out.write("            </CENTER>\n");
      out.write("        ");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
