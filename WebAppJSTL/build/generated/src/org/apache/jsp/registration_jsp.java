package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            fuction getstate()\n");
      out.write("            {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                var country = document.getElementById(\"country\").value ;\n");
      out.write("                xhttp.open(\"GET\",\"getstates.jsp?country=\"+country,true);\n");
      out.write("                xhttp.send();\n");
      out.write("                xhttp.onreadystatechange = fuction(){\n");
      out.write("                  var listState = document.getElementById(\"state\");\n");
      out.write("                  listState.options.length = 0 ;\n");
      out.write("                  if(xhttp.status === 200 && xhhtp.readyState === 4)\n");
      out.write("                  {\n");
      out.write("                      var s = xhttp.responseText ;\n");
      out.write("                      var state = s.trim().split(\":\");\n");
      out.write("                      for(var i = 0;i<state.length;i++)\n");
      out.write("                      {\n");
      out.write("                          var opt = new Option(state[i],state[i]);\n");
      out.write("                          listState.append(opt);\n");
      out.write("                      }\n");
      out.write("                  }\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","password");
                PreparedStatement pst = con.prepareStatement("select * from country");
                ResultSet rs = pst.executeQuery();
        
      out.write("\n");
      out.write("        <center>\n");
      out.write("            <h1>Registration Form</h1><br><br>\n");
      out.write("        <form>\n");
      out.write("            User Name : <input type=\"text\" name=\"uname\" id=\"uname\"/><br><br>\n");
      out.write("            Email Address : <input type=\"email\" name=\"email\" id=\"email\"/><br><br>\n");
      out.write("            Contact no : <input type=\"text\" name=\"contact\" id=\"contact\"/><br><br>\n");
      out.write("            Country : <select name=\"country\" id=\"country\" onchange=\"getstate()\">\n");
      out.write("                <option><----Country----></option>\n");
      out.write("                ");

                    while(rs.next())
                    {
                
      out.write("\n");
      out.write("                <option>");
 out.println(rs.getString(1)); 
      out.write("</option>\n");
      out.write("                ");
  }
                 }
                 catch(Exception e)
                 {
                    System.out.println(e);
                 }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <br><br>\n");
      out.write("            State : <select name=\"state\" id=\"state\" onchange=\"getcity()\">\n");
      out.write("                <option><----state----></option>\n");
      out.write("                </select>\n");
      out.write("            <br><br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Register\" name=\"submit\">\n");
      out.write("        </form>\n");
      out.write("        </center>\n");
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
