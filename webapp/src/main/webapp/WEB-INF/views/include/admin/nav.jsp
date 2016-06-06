<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../commons/taglibs.jsp" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse"
                    class="navbar-toggle collapsed" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Sunlearning</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown"
                       class="dropdown-toggle" href="#">
                        <i class="glyphicon glyphicon-envelope"></i>
                    </a>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown"
                       class="dropdown-toggle" href="#">
                        <i class="glyphicon glyphicon-bell"></i>
                    </a>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown"
                       class="dropdown-toggle" href="#">
                        <i class="glyphicon glyphicon-user"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人资料</a></li>
                        <li><a href="#">修改密码</a></li>
                        <li class="divider" role="separator"></li>
                        <li class="dropdown-header">角色</li>
                        <li><a href="#">学员</a></li>
                        <li><a href="#">培训管理员</a></li>
                        <li><a href="#">系统管理员</a></li>
                        <li class="divider" role="separator"></li>
                        <li class="dropdown-header"><s:message code="site.lang"/></li>
                        <li>
                            <a href="javascript: App.changeLang('zh_CN')"><s:message code="site.lang.simp.chinese"/></a>
                        </li>
                        <li>
                            <a href="javascript: App.changeLang('zh_TW')"><s:message code="site.lang.trad.chinese"/></a>
                        </li>
                        <li>
                            <a href="javascript: App.changeLang('en_US')"><s:message code="site.lang.english"/></a>
                        </li>
                        <li class="divider" role="separator"></li>
                        <li><a href="${ctx}/logout">退出</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown"
                       class="dropdown-toggle" href="#">
                        <i class="glyphicon glyphicon-option-horizontal"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/profile">个人资料</a></li>
                        <li><a href="${ctx}/account">修改密码</a></li>
                        <li><a href="${ctx}/logout">退出</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown"
                       class="dropdown-toggle" href="${ctx}/logout">
                        <i class="glyphicon glyphicon-log-out"></i>
                    </a>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    <span class="input-group-addon" id="basic-addon1"><i class="glyphicon glyphicon-search"></i></span>
                </div>
            </form>
        </div><!--/.nav-collapse -->
    </div>
</nav>
