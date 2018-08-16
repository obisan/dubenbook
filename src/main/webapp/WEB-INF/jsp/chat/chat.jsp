<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-5  toppad  pull-right col-md-offset-5 ">
            <a href="<c:url value="/home" />" >Home</a> |
            <a href="<c:url value="/profile/${me.user.username}" />" >Edit Profile</a> |
            <a href="<c:url value="/logout" />">Logout</a>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Здравствуйте, ${me.user.username}, вот список ваших сообщений</h3>
                </div>

                <div class="row p-5">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                            <tr>
                                <th class="col-lg-12" colspan="3">
                                    <form class="form" action="/message/send" method="post" id="messageForm" modelAttribute="message">
                                        <div class="form-group" hidden="hidden">
                                            <div class="col-xs-6">
                                                <input type="text" class="form-control" name="profile1.user.username" id="username1" value="${me.user.username}">
                                            </div>
                                        </div>

                                        <div class="form-group" hidden="hidden">
                                            <div class="col-xs-6">
                                                <input type="text" class="form-control" name="profile2.user.username" id="username2" value="${mate.user.username}">
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <div class="col-xs-6">
                                                        <input type="text" class="form-control" name="text" id="text" title="enter a message">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <div class="col-xs-12">
                                                        <button class="btn btn-sm btn-success" type="Send">Save</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </th>
                            </tr>
                            <tr>
                                <th class="border-0 text-uppercase small font-weight-bold"></th>
                                <th class="border-0 text-uppercase small font-weight-bold">${me.user.username}</th>
                                <th class="border-0 text-uppercase small font-weight-bold">${mate.user.username}</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${messages}" var="message">
                                <tr>
                                    <td>${message.datetime}</td>
                                    <td><c:if test="${message.profile1.id == me.id}" >${message.text}</c:if></td>
                                    <td><c:if test="${message.profile1.id != me.id}" >${message.text}</c:if></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<!-- /container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>