<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title><sitemesh:write property='title'/></title>
        <%@ include file="../commons/meta.jsp" %>
        <%@ include file="../commons/meta.admin.jsp" %>
        <sitemesh:write property='head'/>
    </head>
    <body>
        <%@ include file="../include/admin/nav.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 col-md-3 sidebar">
                    <%@ include file="../include/admin/sidebar.jsp" %>
                </div>
                <div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 main">
                    <%@ include file="../include/admin/breadcrumb.jsp" %>
                    <sitemesh:write property='body'/>
                </div>
            </div>
        </div>
    </body>
</html>
