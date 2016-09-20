<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../commons/meta.table.jsp" %>

        <script type="text/javascript">
            $(function() {
                $('div#dt').table({
                    url : '${ctx}/admin/user/session/list',
                    model : [
                        {
                            name : 'usr_username',
                            display : '用户名',
                            format : function(entry) {
                                return $.render.linkTpl({
                                    href : '/admin/user/view/' + entry['usr_id'],
                                    text : entry['usr_username']
                                });
                            }
                        },
                        {
                            name : 'usr_email',
                            display : '邮箱'
                        },
                        {
                            name : 'usr_nickname',
                            display : '昵称',
                            format : null
                        }
                    ]
                });
            })
        </script>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">用户会话管理</div>
                    <div class="panel-body">
                        <div id="dt"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
