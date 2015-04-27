package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <title>Login Form</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"loginstyle.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section class=\"container\">\n");
      out.write("            <div class=\"login\">\n");
      out.write("                ");

                    //check if user already logged in
                    //if it is, redirect to home
                    //if not, show the login page
                    if (session.getAttribute("sessionUser") != null) {
                        if(session.getAttribute("sessionUserRole")!=null&&session.getAttribute("sessionUserRole").equals("admin")){
                            response.sendRedirect("gameAdminHome.jsp?status=loggedIn");
                            return;
                        }else{
                        response.sendRedirect("home.jsp?status=loggedIn");
                        return;
                        }
                    }
                    String checker = request.getParameter("status");
                    if(checker!=null&&checker.equals("notLoggedIn")){
                
      out.write("\n");
      out.write("                        <font color=\"red\">Please Login First</font>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                <h1>Form Login SAGA</h1>\n");
      out.write("                <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("                    <p><input type=\"text\" name=\"username\" placeholder=\"Username\"></p>\n");
      out.write("                    <p><input type=\"password\" name=\"password\" placeholder=\"Password\"></p>\n");
      out.write("                    <p class=\"remember_me\">\n");
      out.write("                        <label>\n");
      out.write("                            <input type=\"checkbox\" name=\"remember_me\" id=\"remember_me\">\n");
      out.write("                            Remember me on this computer\n");
      out.write("                        </label>\n");
      out.write("                    </p>\n");
      out.write("                    <p class=\"submit\"><input type=\"submit\" name=\"LoginButton\" value=\"Login\"></p>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"login-help\">\n");
      out.write("                <a href=\"register.jsp\">Doesn't have SAGA Account? click here to register</a>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
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
