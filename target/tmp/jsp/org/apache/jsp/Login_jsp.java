/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.43.v20210629
 * Generated at: 2024-05-25 15:56:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("file:/C:/Users/Admin/.m2/repository/org/apache/struts/struts2-core/2.5.33/struts2-core-2.5.33.jar", Long.valueOf(1713062088674L));
    _jspx_dependants.put("jar:file:/C:/Users/Admin/.m2/repository/org/apache/struts/struts2-core/2.5.33/struts2-core-2.5.33.jar!/META-INF/struts-tags.tld", Long.valueOf(1701733154000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005factionerror_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("      \r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>HỆ THỐNG QUẢN LÝ RẠP CHIẾU PHIM</title>\r\n");
      out.write("    <!-- Favicon-->\r\n");
      out.write("    <link rel=\"icon\" href=\"../../favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Google Fonts -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core Css -->\r\n");
      out.write("    <link href=\"style/plugins/bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Waves Effect Css -->\r\n");
      out.write("    <link href=\"style/plugins/node-waves/waves.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("    <!-- Animation Css -->\r\n");
      out.write("    <link href=\"style/plugins/animate-css/animate.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom Css -->\r\n");
      out.write("    <link href=\"style/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"login-page\">\r\n");
      out.write("    <div class=\"login-box\">\r\n");
      out.write("        <div class=\"logo\">\r\n");
      out.write("            <br/>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"card\">\r\n");
      out.write("            <div class=\"body\">\r\n");
      out.write("            \r\n");
      out.write("                <form id=\"sign_in\" method=\"POST\" action=\"loginprocess\">\r\n");
      out.write("                \t");
      if (_jspx_meth_s_005factionerror_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    <div class=\"msg\"><h1>Đăng nhập</h1></div>\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <span class=\"input-group-addon\">\r\n");
      out.write("                            <i class=\"material-icons\">person</i>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <div class=\"form-line\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"username\" placeholder=\"Tên tài khoản\" required autofocus>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <span class=\"input-group-addon\">\r\n");
      out.write("                            <i class=\"material-icons\">lock</i>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <div class=\"form-line\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Mật khẩu\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                            <button class=\"btn btn-block bg-pink waves-effect\" type=\"submit\" style=\"margin-right: 15px;\">ĐĂNG NHẬP</button>\r\n");
      out.write("                  \r\n");
      out.write("                    </div>\r\n");
      out.write("                   \r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Jquery Core Js -->\r\n");
      out.write("    <script src=\"style/plugins/jquery/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core Js -->\r\n");
      out.write("    <script src=\"style/plugins/bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Waves Effect Plugin Js -->\r\n");
      out.write("    <script src=\"style/plugins/node-waves/waves.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Validation Plugin Js -->\r\n");
      out.write("    <script src=\"style/plugins/jquery-validation/jquery.validate.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom Js -->\r\n");
      out.write("    <script src=\"style/js/admin.js\"></script>\r\n");
      out.write("    <script src=\"style/js/pages/examples/sign-in.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<style>\r\n");
      out.write(".btn-block {\r\n");
      out.write("    float: right;\r\n");
      out.write("    width: 100px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005factionerror_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:actionerror
    org.apache.struts2.views.jsp.ui.ActionErrorTag _jspx_th_s_005factionerror_005f0 = (org.apache.struts2.views.jsp.ui.ActionErrorTag) _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.get(org.apache.struts2.views.jsp.ui.ActionErrorTag.class);
    boolean _jspx_th_s_005factionerror_005f0_reused = false;
    try {
      _jspx_th_s_005factionerror_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005factionerror_005f0.setParent(null);
      int _jspx_eval_s_005factionerror_005f0 = _jspx_th_s_005factionerror_005f0.doStartTag();
      if (_jspx_th_s_005factionerror_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.reuse(_jspx_th_s_005factionerror_005f0);
      _jspx_th_s_005factionerror_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005factionerror_005f0, _jsp_getInstanceManager(), _jspx_th_s_005factionerror_005f0_reused);
    }
    return false;
  }
}
