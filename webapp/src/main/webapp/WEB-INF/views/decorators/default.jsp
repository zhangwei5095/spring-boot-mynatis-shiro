<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title><sitemesh:write property='title'/></title>
        <%@ include file="../commons/meta.jsp" %>
        <sitemesh:write property='head'/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 main">
                    <sitemesh:write property='body'/>
                </div>
            </div>
        </div>
    </body>
</html>
