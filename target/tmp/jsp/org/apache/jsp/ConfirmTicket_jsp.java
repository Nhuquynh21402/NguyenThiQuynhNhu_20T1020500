/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.43.v20210629
 * Generated at: 2024-05-25 17:22:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.type.ListType;
import com.fpt.ojtstem.model.TicketType;
import java.util.List;
import com.fpt.ojtstem.model.Account;

public final class ConfirmTicket_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.hibernate.type.ListType");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.fpt.ojtstem.model.TicketType");
    _jspx_imports_classes.add("com.fpt.ojtstem.model.Account");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005factionerror_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody;

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
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction.release();
    _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.release();
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<title>Admin_Quản lý bán vé</title>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu/lib_Head.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body class=\"theme-red\">\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu/nav_nv.jsp", out, false);
      out.write("\r\n");
      out.write("\t<section class=\"content\">\r\n");
      out.write("\t\t<div class=\"row clearfix\">\r\n");
      out.write("\t\t\t<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t<div class=\"body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>CHỌN LOẠI VÉ VÀ PHƯƠNG THỨC THANH TOÁN</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"container-fluid\" id=\"img\" style=\"padding-left: 30%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src=\"img/");
      if (_jspx_meth_s_005fproperty_005f0(_jspx_page_context))
        return;
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"width: 50%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_s_005factionerror_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  s:form
      org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction.get(org.apache.struts2.views.jsp.ui.FormTag.class);
      boolean _jspx_th_s_005fform_005f0_reused = false;
      try {
        _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
        _jspx_th_s_005fform_005f0.setParent(null);
        // /ConfirmTicket.jsp(36,8) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_s_005fform_005f0.setAction("Payment");
        // /ConfirmTicket.jsp(36,8) name = method type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_s_005fform_005f0.setMethod("post");
        int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
        if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_s_005fform_005f0);
          }
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"body\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row \">\r\n");
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"text-align: center;\">Chọn loại vé :</label> <select\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-control show-tick\" name=\"selectedTicketType\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"selectedTicketType\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\" style=\"text-align: center;\">--\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tChọn loại vé--</option>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");

													List<TicketType> listTicket = (List<TicketType>) session.getAttribute("listTicket");
													if (listTicket != null) {
														for (TicketType ticket : listTicket) {
													
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
            out.print(ticket.getTicketTypeName());
            out.write("\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align: center;\">");
            out.print(ticket.getTicketTypeName());
            out.write("</option>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");

													}
													}
													
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"text-align: center;\">Chọn phương thức\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tthanh toán :</label> <select class=\"form-control show-tick\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"selectedMethodPayment\" id=\"selectedMethodPayment\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\" style=\"text-align: center;\">--\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tChọn phương thức thanh toán--</option>\r\n");
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Tiền mặt\" style=\"text-align: center;\">Tiền\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tmặt</option>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"Chuyển khoản\" style=\"text-align: center;\">Chuyển\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tkhoản</option>\r\n");
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"button\" onclick=methodPayment()\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"btn btn-primary m-t-15 waves-effect\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tstyle=\"float: right;\">Xác nhận</button>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"btn btn-primary m-t-15 waves-effect\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"onBack()\" style=\"float: left;\">Quay lại</button>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_s_005fform_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.popBody();
          }
        }
        if (_jspx_th_s_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction.reuse(_jspx_th_s_005fform_005f0);
        _jspx_th_s_005fform_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fform_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fform_005f0_reused);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu/lib.jsp", out, false);
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\tdocument.getElementById(\"selectedTicketType\").addEventListener('change',function() {\t\r\n");
      out.write("\t\t");
List<TicketType> listTicket = (List<TicketType>) session.getAttribute("listTicket"); 
      out.write("\r\n");
      out.write("\t    var selectedValue = $(this).val();\r\n");
      out.write("\t    let data = [];\r\n");
      out.write("\t\tconsole.log(\"ngay : \", selectedValue);\r\n");
      out.write("\t\t");
for (TicketType ticket : listTicket) {
      out.write("\r\n");
      out.write("        data.push('");
      out.print(ticket.getTicketTypeName());
      out.write("');\r\n");
}
      out.write("\r\n");
      out.write("\tconsole.log(\"ngay hien tai: \", data);\r\n");
      out.write("\t\t\t\tif (!data.includes(selectedValue)) {\r\n");
      out.write("\t\t\t\t\talert(\"Loại vé không hợp lệ.\");\r\n");
      out.write("\t\t\t\t\t$(this).val(\"\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\tdocument.getElementById(\"selectedMethodPayment\").addEventListener('change',function() {\t\r\n");
      out.write("\r\n");
      out.write("\t    var selectedValue = $(this).val();\r\n");
      out.write("\t    let data = [];\r\n");
      out.write("\t\tconsole.log(\"ngay : \", selectedValue);\r\n");
      out.write("        data.push('Tiền mặt');\r\n");
      out.write("        data.push('Chuyển khoản');\r\n");
      out.write("\tconsole.log(\"ngay hien tai: \", data);\r\n");
      out.write("\t\t\t\tif (!data.includes(selectedValue)) {\r\n");
      out.write("\t\t\t\t\talert(\"Phương thức thanh toán không hợp lệ.\");\r\n");
      out.write("\t\t\t\t\t$(this).val(\"\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\tfunction onBack() {\r\n");
      out.write("\t\t\twindow.location.href = \"");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction methodPayment(){\r\n");
      out.write("\t\t\tconst TicketType = document.getElementById('selectedTicketType').value;\r\n");
      out.write("\t\t\tconst MethodPayment = document\r\n");
      out.write("\t\t\t\t\t.getElementById('selectedMethodPayment').value;\r\n");
      out.write("\t\t\tconsole.log(TicketType);\r\n");
      out.write("\t\t\tif (TicketType === \"\") {\r\n");
      out.write("\t\t\t\talert('Bạn chưa chọn lọai vé!!');\r\n");
      out.write("\t\t\t} else if (MethodPayment === \"\") {\r\n");
      out.write("\t\t\t\talert('Bạn chưa chọn phương thức thanh toán!!');\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\twindow.location.href = \"Payment?selectedTicketType=\"\r\n");
      out.write("\t\t\t\t\t\t+ TicketType + \"&&selectedMethodPayment=\"\r\n");
      out.write("\t\t\t\t\t\t+ MethodPayment;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<style>\r\n");
      out.write("\tlabel{\r\n");
      out.write("\tcolor:#000;\r\n");
      out.write("\t}\r\n");
      out.write("\t<style>\r\n");
      out.write("</body>\r\n");
      out.write("<style>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_s_005fproperty_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    boolean _jspx_th_s_005fproperty_005f0_reused = false;
    try {
      _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fproperty_005f0.setParent(null);
      // /ConfirmTicket.jsp(30,23) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fproperty_005f0.setValue("movie.image");
      int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
      if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      _jspx_th_s_005fproperty_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fproperty_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fproperty_005f0_reused);
    }
    return false;
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

  private boolean _jspx_meth_s_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f0 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    boolean _jspx_th_s_005furl_005f0_reused = false;
    try {
      _jspx_th_s_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005furl_005f0.setParent(null);
      // /ConfirmTicket.jsp(124,27) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005furl_005f0.setAction("bookingTicketAction");
      int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
      if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      _jspx_th_s_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_s_005furl_005f0_reused);
    }
    return false;
  }
}
